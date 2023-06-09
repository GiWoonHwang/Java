package io.dustin.apps.board.domain.community.comment.model.dto;

import io.dustin.apps.board.domain.community.comment.model.Comment;
import io.dustin.apps.board.domain.community.posting.model.Posting;
import io.dustin.apps.board.domain.qna.answer.model.Answer;
import io.dustin.apps.board.domain.qna.question.model.Question;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CommentDto (
        Long id,

        String content,

        String authorName,

        Comment comment,

        Posting posting,

        LocalDateTime createdAt
){
        public static CommentDto from(Comment comment) {
            return CommentDto.builder()
                .id(comment.getId())
            .content(comment.getContent())
            .authorName(comment.getAuthor().getNickName())
            .posting(comment.getPosting())
            .createdAt(comment.getCreatedAt())
            .build();
}
}


