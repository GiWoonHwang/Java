package io.dustin.board.common.extenstion;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.annotations.QueryDelegate;
import com.querydsl.core.annotations.QueryEntity;
import io.dustin.board.domain.community.comment.model.Comment;
import io.dustin.board.domain.community.comment.model.QComment;

@QueryEntity

public class CommentExtension {

    @QueryDelegate(Comment.class)
    public static BooleanBuilder indexByCountPagination(QComment comment, Long nextId) {
        BooleanBuilder builder = new BooleanBuilder();
        if(nextId != null) {
            builder.and(comment.id.lt(nextId));
        }
        return builder;
    }
}
