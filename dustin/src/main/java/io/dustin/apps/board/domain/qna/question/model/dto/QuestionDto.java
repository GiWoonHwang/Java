package io.dustin.apps.board.domain.qna.question.model.dto;

import io.dustin.apps.board.domain.qna.question.model.Question;
import lombok.Builder;
import java.time.LocalDateTime;

@Builder
public record QuestionDto(
        Long id,

        String subject,

        String content,

        String authorName,

        LocalDateTime createdAt
) {
        public static QuestionDto from(Question question) {
            return QuestionDto.builder()
                    .id(question.getId())
                    .subject(question.getSubject())
                    .content(question.getContent())
                    .authorName(question.getAuthor().getNickName())
                    .createdAt(question.getCreatedAt())
                    .build();
        }

}
