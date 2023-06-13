package io.dustin.apps.board.domain.community.comment.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QComment is a Querydsl query type for Comment
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QComment extends EntityPathBase<Comment> {

    private static final long serialVersionUID = -501580623L;

    public static final QComment comment = new QComment("comment");

    public final io.dustin.apps.common.model.QBaseEntity _super = new io.dustin.apps.common.model.QBaseEntity(this);

    public final NumberPath<Long> author = createNumber("author", Long.class);

    public final NumberPath<Long> clickCount = createNumber("clickCount", Long.class);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<io.dustin.apps.common.code.YesOrNo> isDeleted = createEnum("isDeleted", io.dustin.apps.common.code.YesOrNo.class);

    public final NumberPath<Long> likeCount = createNumber("likeCount", Long.class);

    public final NumberPath<Long> posting = createNumber("posting", Long.class);

    public final NumberPath<Long> reply = createNumber("reply", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QComment(String variable) {
        super(Comment.class, forVariable(variable));
    }

    public QComment(Path<? extends Comment> path) {
        super(path.getType(), path.getMetadata());
    }

    public QComment(PathMetadata metadata) {
        super(Comment.class, metadata);
    }

}

