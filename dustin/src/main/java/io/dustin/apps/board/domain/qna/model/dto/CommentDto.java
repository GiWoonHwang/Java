package io.dustin.apps.board.domain.qna.model.dto;

import io.dustin.apps.board.domain.qna.model.Answer;
import io.dustin.apps.board.domain.qna.model.Comment;
import io.dustin.apps.board.domain.qna.model.Question;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CommentDto (
        Long id,

        String content,

        String authorName,

        Comment comment,

        Answer answer,

        Question question,

        LocalDateTime createdAt
){
        public static CommentDto from(Comment comment) {
            return CommentDto.builder()
                .id(comment.getId())
            .content(comment.getContent())
            .authorName(comment.getAuthor().getNickName())
            .question(comment.getQuestion())
            .createdAt(comment.getCreatedAt())
            .build();
}
}


