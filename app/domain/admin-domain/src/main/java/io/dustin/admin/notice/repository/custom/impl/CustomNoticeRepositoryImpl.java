package io.dustin.admin.notice.repository.custom.impl;

import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.dustin.admin.notice.model.QNotice;
import io.dustin.admin.notice.model.dto.NoticeDto;
import io.dustin.admin.notice.repository.custom.CustomNoticeRepository;
import io.dustin.board.common.code.BoardType;
import io.dustin.board.domain.like.model.QLike;
import io.dustin.common.code.YesOrNo;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.querydsl.core.types.Projections.constructor;


@RequiredArgsConstructor
public class CustomNoticeRepositoryImpl implements CustomNoticeRepository {

    private final JPAQueryFactory query;

    @Override
    public NoticeDto getNotice(long userId, long noticeId) {
        JPAQuery<NoticeDto> jPAQuery = query.select(constructor(NoticeDto.class,
                        QNotice.notice.id,
                        QNotice.notice.adminId,
                        QNotice.notice.subject,
                        QNotice.notice.content,
                        new CaseBuilder().when(QLike.like.id.isNotNull()).then(true).otherwise(false).as("isLike"),
                        QNotice.notice.clickCount,
                        QNotice.notice.createdAt

                ))
                .from(QNotice.notice)
                .leftJoin(QLike.like).on(
                        QLike.like.boardType.eq(BoardType.NOTICE)
                                .and(QLike.like.boardId.eq(QNotice.notice.id))
                                .and(QLike.like.userId.eq(userId))

                )
                .where(
                        QNotice.notice.isDeleted.ne(YesOrNo.Y),
                        QNotice.notice.id.eq(noticeId)

                );

        return jPAQuery.fetchOne();
    }

    @Override
    public List<NoticeDto> getNoticeList(long userId, Long nextId, int size) {
        JPAQuery<NoticeDto> jPAQuery = query.select(constructor(NoticeDto.class,
                        QNotice.notice.id,
                        QNotice.notice.adminId,
                        QNotice.notice.subject,
                        QNotice.notice.content,
                        new CaseBuilder().when(QLike.like.id.isNotNull()).then(true).otherwise(false).as("isLike"),
                        QNotice.notice.clickCount,
                        QNotice.notice.createdAt

                ))
                .from(QNotice.notice)
                .leftJoin(QLike.like).on(
                        QLike.like.boardType.eq(BoardType.NOTICE)
                                .and(QLike.like.boardId.eq(QNotice.notice.id))
                                .and(QLike.like.userId.eq(userId))

                )
                .where(
                        QNotice.notice.isDeleted.ne(YesOrNo.Y),
                        QNotice.notice.indexByCountPagination(nextId)

                )
                .orderBy(QNotice.notice.id.desc())
                .limit(size);
        return jPAQuery.fetch();
    }
}
