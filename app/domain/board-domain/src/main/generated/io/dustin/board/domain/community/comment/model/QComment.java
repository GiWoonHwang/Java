package io.dustin.board.domain.community.comment.model;

import static com.querydsl.core.types.PathMetadataFactory.*;
import io.dustin.board.common.extenstion.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QComment is a Querydsl query type for Comment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QComment extends EntityPathBase<Comment> {

    private static final long serialVersionUID = -486277581L;

    public static final QComment comment = new QComment("comment");

    public final io.dustin.common.model.QBaseEntity _super = new io.dustin.common.model.QBaseEntity(this);

    public final NumberPath<Long> clickCount = createNumber("clickCount", Long.class);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<io.dustin.common.code.YesOrNo> isDeleted = createEnum("isDeleted", io.dustin.common.code.YesOrNo.class);

    public final NumberPath<Long> likeCount = createNumber("likeCount", Long.class);

    public final NumberPath<Long> postingId = createNumber("postingId", Long.class);

    public final NumberPath<Long> replyId = createNumber("replyId", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QComment(String variable) {
        super(Comment.class, forVariable(variable));
    }

    public QComment(Path<? extends Comment> path) {
        super(path.getType(), path.getMetadata());
    }

    public QComment(PathMetadata metadata) {
        super(Comment.class, metadata);
    }

    public com.querydsl.core.BooleanBuilder indexByCountPagination(Long nextId) {
        return CommentExtension.indexByCountPagination(this, nextId);
    }

}

