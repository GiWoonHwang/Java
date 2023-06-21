package io.dustin.apps.board.domain.qna.question.model.dto;

import io.dustin.apps.board.domain.qna.question.model.Question;
import lombok.Builder;
import java.time.LocalDateTime;

@Builder
public record QuestionDto(
        Long id,

        String subject,

        String content,

        Long userId,

        LocalDateTime createdAt
) {
        public static QuestionDto from(Question question) {
            return QuestionDto.builder()
                    .id(question.getId())
                    .subject(question.getSubject())
                    .content(question.getContent())
                    .userId(question.getUserID())
                    .createdAt(question.getCreatedAt())
                    .build();
        }

}
