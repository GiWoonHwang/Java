package io.dustin.board.domain.qna.answer.model.dto;

import io.dustin.board.domain.qna.answer.model.Answer;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record AnswerDto(
    Long id,
    @NotBlank
    @Min(5)
    String content,

    Long adminId,

    Long questionId,

    LocalDateTime createdAt
) {
    public static AnswerDto from(Answer answer) {
        return AnswerDto.builder()
                .id(answer.getId())
                .content(answer.getContent())
                .adminId(answer.getAdminId())
                .questionId(answer.getQuestionId())
                .createdAt(answer.getCreatedAt())
                .build();
    }

}