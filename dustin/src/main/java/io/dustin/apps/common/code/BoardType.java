package io.dustin.apps.common.code;

import io.dustin.apps.board.domain.LikeCountService;
import io.dustin.apps.board.domain.community.comment.service.WriteCommentService;
import io.dustin.apps.board.domain.qna.question.service.WriteQuestionService;
import io.dustin.apps.common.provider.ApplicationContextProvider;
import io.dustin.apps.common.utils.CommonUtil;
import io.dustin.apps.common.utils.Supplier;
import lombok.Getter;

public enum BoardType {

    POSTING("posting", () -> CommonUtil.getBean("posting", LikeCountService.class)),
    COMMENT("comment", () -> CommonUtil.getBean("comment", LikeCountService.class));

    private String code;

    private Supplier<LikeCountService> supplier;

    BoardType(String code, Supplier<LikeCountService> supplier) {
        this.code = code;
        this.supplier = supplier;
    }

    public LikeCountService getBean() {
        return this.supplier.get();
    }

}
