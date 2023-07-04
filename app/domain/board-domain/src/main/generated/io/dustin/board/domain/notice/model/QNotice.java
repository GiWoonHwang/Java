package io.dustin.board.domain.notice.model;

import static com.querydsl.core.types.PathMetadataFactory.*;
import io.dustin.board.common.extenstion.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QNotice is a Querydsl query type for Notice
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QNotice extends EntityPathBase<Notice> {

    private static final long serialVersionUID = 534108032L;

    public static final QNotice notice = new QNotice("notice");

    public final io.dustin.common.model.QBaseEntity _super = new io.dustin.common.model.QBaseEntity(this);

    public final NumberPath<Long> adminId = createNumber("adminId", Long.class);

    public final NumberPath<Long> clickCount = createNumber("clickCount", Long.class);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<io.dustin.common.code.YesOrNo> isDeleted = createEnum("isDeleted", io.dustin.common.code.YesOrNo.class);

    public final NumberPath<Long> likeCount = createNumber("likeCount", Long.class);

    public final StringPath subject = createString("subject");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QNotice(String variable) {
        super(Notice.class, forVariable(variable));
    }

    public QNotice(Path<? extends Notice> path) {
        super(path.getType(), path.getMetadata());
    }

    public QNotice(PathMetadata metadata) {
        super(Notice.class, metadata);
    }

    public com.querydsl.core.BooleanBuilder indexByCountPagination(Long nextId) {
        return NoticeExtension.indexByCountPagination(this, nextId);
    }

}

