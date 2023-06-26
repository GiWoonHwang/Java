package io.dustin.apps.board.domain.community.posting.model.dto;

import io.dustin.apps.board.domain.community.comment.model.Comment;
import io.dustin.apps.board.domain.community.comment.model.dto.CommentDto;
import io.dustin.apps.board.domain.community.posting.model.Posting;
import io.dustin.apps.common.model.ResponseWithScroll;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record PostingDetailDto (
        PostingDto posting,

        ResponseWithScroll<List<CommentDto>> comment

) {
    public static PostingDetailDto from(PostingDto posting,  ResponseWithScroll<List<CommentDto>> comment) {
        return PostingDetailDto.builder()
                .posting(posting)
                .comment(comment)
                .build();
    }

}
