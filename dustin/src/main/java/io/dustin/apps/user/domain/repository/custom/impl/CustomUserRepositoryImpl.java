package io.dustin.apps.user.domain.repository.custom.impl;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.dustin.apps.common.code.BoardType;
import io.dustin.apps.user.domain.model.dto.LikeItUser;
import io.dustin.apps.user.domain.repository.custom.CustomUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static com.querydsl.core.types.Projections.bean;
import static io.dustin.apps.board.domain.like.model.QLike.like;
import static io.dustin.apps.user.domain.model.QSiteUser.siteUser;

@RequiredArgsConstructor
public class CustomUserRepositoryImpl implements CustomUserRepository {

    private final JPAQueryFactory query;

    @Override
    public List<LikeItUser> findAllLikeItUser(Long boardId, BoardType boardType, Pageable pageable) {

        JPAQuery<LikeItUser> jPAQuery = query.select(bean(LikeItUser.class,
                    siteUser.id,
                    siteUser.nickName
                ))
                .from(siteUser)
                .innerJoin(like).on(siteUser.id.eq(like.userId))
                .where(
                    like.boardId.eq(boardId),
                    like.boardType.eq(boardType)
                )
                .orderBy(siteUser.nickName.asc());
        if(pageable != null) {
            jPAQuery.offset(pageable.getOffset())
                    .limit(pageable.getPageSize());

        }
        return jPAQuery.fetch();
    }
}
