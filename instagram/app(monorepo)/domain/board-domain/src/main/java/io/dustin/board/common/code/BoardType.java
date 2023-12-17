package io.dustin.board.common.code;

import io.dustin.board.domain.like.model.LikeCountService;
import io.dustin.common.utils.CommonUtil;

import java.util.function.Supplier;

public enum BoardType {

    POSTING("posting", () -> CommonUtil.getBean("posting", LikeCountService.class)),
    COMMENT("comment", () -> CommonUtil.getBean("comment", LikeCountService.class)),
    NOTICE("notice", () -> CommonUtil.getBean("notice", LikeCountService.class));



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
