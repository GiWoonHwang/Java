package io.dustin.board.domain.community.comment.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.dustin.board.common.model.IdAble;
import io.dustin.board.domain.community.comment.model.Comment;
import io.dustin.board.domain.community.posting.model.Posting;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CommentDto (
        Long id,

        @JsonIgnore
        Posting posting,

        @NotBlank
        @Min(5)
        String content,

        Boolean isLike,

        Boolean isReply,

        Long userId,

        Long postingId,

        Long replyId,

        LocalDateTime createdAt
) implements IdAble {

    public static CommentDto from(Comment comment) {
            return CommentDto.builder()
                .id(comment.getId())
            .content(comment.getContent())
            .userId(comment.getUserId())
            .postingId(comment.getPostingId())
            .replyId(comment.getReplyId())
            .createdAt(comment.getCreatedAt())
            .build();
}

    @Override
    public Long getId() {
        return this.id;
    }
}


