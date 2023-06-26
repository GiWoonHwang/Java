package io.dustin.apps.board.domain.community.posting.repository.custom.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.dustin.apps.board.domain.community.posting.model.dto.PostingDto;
import io.dustin.apps.board.domain.community.posting.repository.custom.CustomPostingRepository;
import io.dustin.apps.common.code.BoardType;
import io.dustin.apps.common.code.YesOrNo;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.querydsl.core.types.Projections.constructor;
import static io.dustin.apps.board.domain.bookmark.model.QBookmark.bookmark;
import static io.dustin.apps.board.domain.community.comment.model.QComment.comment;
import static io.dustin.apps.board.domain.community.posting.model.QPosting.posting;
import static io.dustin.apps.board.domain.like.model.QLike.like;

@RequiredArgsConstructor
public class CustomPostingRepositoryImpl implements CustomPostingRepository {

    private final JPAQueryFactory query;

    @Override
    public List<PostingDto> getPostingList(long loginId, Long nextId, int size) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if(nextId != null) {
            booleanBuilder.and(posting.id.lt(nextId));
        }

        JPAQuery<PostingDto> jPAQuery = query.select(constructor(PostingDto.class,
                        posting.id,
                        posting.userId,
                        posting.subject,
                        posting.content,
                        new CaseBuilder().when(like.id.isNotNull()).then(true).otherwise(false).as("isLike"),
                        new CaseBuilder().when(bookmark.id.isNotNull()).then(true).otherwise(false).as("isBookmark"),
                        posting.commentCount.as("commentCnt"),
                        posting.clickCount.as("clickCnt"),
                        posting.likeCount,
                        posting.createdAt
                ))
                .from(posting)
                .leftJoin(like).on(
                        like.boardType.eq(BoardType.POSTING)
                        .and(like.boardId.eq(posting.id))
                        .and(like.userId.eq(loginId))

                )
                .leftJoin(bookmark).on(
                        bookmark.boardId.eq(posting.id)
                        .and(bookmark.userId.eq(loginId))
                )
                .where(
                    booleanBuilder,
                    posting.isDeleted.ne(YesOrNo.Y)
                )
                .orderBy(posting.id.desc())
                .limit(size);

        return jPAQuery.fetch();
    }
}
