package io.dustin.board.common.model.extension;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.annotations.QueryDelegate;
import io.dustin.board.domain.notice.model.Notice;
import io.dustin.board.domain.notice.model.QNotice;

public class NoticeExtension {
    @QueryDelegate(Notice.class)
    public static BooleanBuilder indexByCountPagination(QNotice notice, Long nextId) {
        BooleanBuilder builder = new BooleanBuilder();
        if(nextId != null) {
            builder.and(notice.id.lt(nextId));
        }
        return builder;
    }
}
