package io.dustin.apps.board.domain.qna.question.model.dto;

import io.dustin.apps.board.domain.qna.question.model.Question;
import lombok.Builder;
import java.time.LocalDateTime;

@Builder
public record QuestionDto(
        Long id,

        Long userId,

        String subject,

        String content,

        LocalDateTime createdAt
) {
        public static QuestionDto from(Question question) {
            return QuestionDto.builder()
                    .id(question.getId())
                    .userId(question.getUserId())
                    .subject(question.getSubject())
                    .content(question.getContent())
                    .createdAt(question.getCreatedAt())
                    .build();
        }

}
