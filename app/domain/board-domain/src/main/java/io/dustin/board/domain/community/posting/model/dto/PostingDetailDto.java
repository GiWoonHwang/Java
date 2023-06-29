package io.dustin.board.domain.community.posting.model.dto;

import io.dustin.board.common.model.ResponseWithScroll;
import io.dustin.board.domain.community.comment.model.dto.CommentDto;
import lombok.Builder;

import java.util.List;

@Builder
public record PostingDetailDto (
        PostingDto posting,

        ResponseWithScroll<List<CommentDto>> commentList

) {
    public static PostingDetailDto from(PostingDto posting, ResponseWithScroll<List<CommentDto>> commentList) {
        return PostingDetailDto.builder()
                .posting(posting)
                .commentList(commentList)
                .build();
    }

}
