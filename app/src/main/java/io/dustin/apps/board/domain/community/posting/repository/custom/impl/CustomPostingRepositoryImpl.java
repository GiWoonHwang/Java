package io.dustin.apps.board.domain.community.posting.repository.custom.impl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import io.dustin.apps.board.domain.blockeduser.model.BlockedUser;
import io.dustin.apps.board.domain.blockeduser.repository.BlockedUserRepository;
import io.dustin.apps.board.domain.blockeduser.service.ReadBlockedUserService;
import io.dustin.apps.board.domain.community.posting.model.dto.PostingDto;
import io.dustin.apps.board.domain.community.posting.repository.custom.CustomPostingRepository;
import io.dustin.apps.common.code.BoardType;
import io.dustin.apps.common.code.YesOrNo;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import static com.querydsl.core.types.Projections.constructor;
import static io.dustin.apps.board.domain.bookmark.model.QBookmark.bookmark;
import static io.dustin.apps.board.domain.community.posting.model.QPosting.posting;
import static io.dustin.apps.board.domain.like.model.QLike.like;

@RequiredArgsConstructor
public class CustomPostingRepositoryImpl implements CustomPostingRepository {

    private final JPAQueryFactory query;
    private final ReadBlockedUserService readBlockedUserService;




    @Override
    public PostingDto getPosting(long userId, long postingId) {


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
                                .and(like.userId.eq(userId))

                )
                .leftJoin(bookmark).on(
                        bookmark.boardId.eq(posting.id)
                                .and(bookmark.userId.eq(userId))
                )
                .where(
                        posting.id.eq(postingId)
                );

        return jPAQuery.fetchOne();
    }



    @Override
    public List<PostingDto> getPostingList(long userId, Long nextId, int size) {
        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if(nextId != null) {
            booleanBuilder.and(posting.id.lt(nextId));
        }

        /** userID가 차단한 리스트를 가져온다*/
        List<BlockedUser> toUserIdList = readBlockedUserService.getToUserIdList(userId);
        List<Long> toUserIds = toUserIdList.stream().map(BlockedUser::getToUserId).collect(Collectors.toList());

        /** userID를 차단한 리스트를 가져온다*/
        List<BlockedUser> fromUserIdList = readBlockedUserService.getFromUserIdList(userId);
        List<Long> fromUserIds = fromUserIdList.stream().map(BlockedUser::getFromUserId).collect(Collectors.toList());



        booleanBuilder.and(posting.userId.notIn(toUserIds).and(posting.userId.notIn(fromUserIds)));


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
                        .and(like.userId.eq(userId))

                )
                .leftJoin(bookmark).on(
                        bookmark.boardId.eq(posting.id)
                        .and(bookmark.userId.eq(userId))
                )
                .where(
                    booleanBuilder,
                    posting.isDeleted.ne(YesOrNo.Y)
                    /**
                      * 차단,제한 테이블에서 userId가 차단한 유저의 id,  userId를 차단한 유저의 id 리스트를 찾아서 그 유저들이 만든 게시물은 보이지 않아야 한다.
                    */

                )
                .orderBy(posting.id.desc())
                .limit(size);

        return jPAQuery.fetch();
    }
}
