package io.dustin.apps.board.domain.notice.repository.custom.impl;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.dustin.apps.board.domain.notice.model.dto.NoticeDto;
import io.dustin.apps.board.domain.notice.repository.custom.CustomNoticeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.querydsl.core.types.Projections.constructor;
import static io.dustin.apps.board.domain.notice.model.QNotice.notice;

@RequiredArgsConstructor
public class CustomNoticeRepositoryImpl implements CustomNoticeRepository {

    private final JPAQueryFactory query;

    @Override
    public List<NoticeDto> findNotices(Long nextId, int size) {
        JPAQuery<NoticeDto> jPAQuery = query.select(constructor(NoticeDto.class,
                        notice.id,
                        notice.adminId,
                        notice.subject,
                        notice.content,
                        notice.clickCount,
                        notice.createdAt

                ))
                .from(notice)
                .where(
                        notice.isDeleted.isNotNull(),
                        notice.indexByCountPagination(nextId)

                )
                .orderBy(notice.id.desc())
                .limit(size);
        return jPAQuery.fetch();
    }
}
