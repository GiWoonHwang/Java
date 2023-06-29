package io.dustin.board.domain.qna.question.model.dto;

import io.dustin.board.common.model.IdAble;
import io.dustin.board.domain.qna.question.model.Question;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record QuestionDto(
        Long id,

        Long userId,

        @NotBlank
        @Min(5)
        String subject,

        @NotBlank
        @Min(5)
        String content,

        Boolean isComment,

        LocalDateTime createdAt
) implements IdAble {
        public static QuestionDto from(Question question) {
            return QuestionDto.builder()
                    .id(question.getId())
                    .userId(question.getUserId())
                    .subject(question.getSubject())
                    .content(question.getContent())
                    .createdAt(question.getCreatedAt())
                    .build();
        }

    @Override
    public Long getId() {
        return this.id;
    }

}
