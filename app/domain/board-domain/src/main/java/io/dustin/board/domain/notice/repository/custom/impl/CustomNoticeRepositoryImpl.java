package io.dustin.board.domain.notice.repository.custom.impl;

import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.dustin.board.common.code.BoardType;
import io.dustin.board.common.code.YesOrNo;
import io.dustin.board.domain.notice.model.dto.NoticeDto;
import io.dustin.board.domain.notice.repository.custom.CustomNoticeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.querydsl.core.types.Projections.constructor;
import static io.dustin.board.domain.like.model.QLike.like;
import static io.dustin.board.domain.notice.model.QNotice.notice;


@RequiredArgsConstructor
public class CustomNoticeRepositoryImpl implements CustomNoticeRepository {

    private final JPAQueryFactory query;

    @Override
    public NoticeDto getNotice(long userId, long noticeId) {
        JPAQuery<NoticeDto> jPAQuery = query.select(constructor(NoticeDto.class,
                        notice.id,
                        notice.adminId,
                        notice.subject,
                        notice.content,
                        new CaseBuilder().when(like.id.isNotNull()).then(true).otherwise(false).as("isLike"),
                        notice.clickCount,
                        notice.createdAt

                ))
                .from(notice)
                .leftJoin(like).on(
                        like.boardType.eq(BoardType.NOTICE)
                                .and(like.boardId.eq(notice.id))
                                .and(like.userId.eq(userId))

                )
                .where(
                        notice.isDeleted.ne(YesOrNo.Y),
                        notice.id.eq(noticeId)

                );

        return jPAQuery.fetchOne();
    }

    @Override
    public List<NoticeDto> getNoticeList(long userId, Long nextId, int size) {
        JPAQuery<NoticeDto> jPAQuery = query.select(constructor(NoticeDto.class,
                        notice.id,
                        notice.adminId,
                        notice.subject,
                        notice.content,
                        new CaseBuilder().when(like.id.isNotNull()).then(true).otherwise(false).as("isLike"),
                        notice.clickCount,
                        notice.createdAt

                ))
                .from(notice)
                .leftJoin(like).on(
                        like.boardType.eq(BoardType.NOTICE)
                                .and(like.boardId.eq(notice.id))
                                .and(like.userId.eq(userId))

                )
                .where(
                        notice.isDeleted.ne(YesOrNo.Y),
                        notice.indexByCountPagination(nextId)

                )
                .orderBy(notice.id.desc())
                .limit(size);
        return jPAQuery.fetch();
    }
}
