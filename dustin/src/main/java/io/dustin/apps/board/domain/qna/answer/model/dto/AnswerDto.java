package io.dustin.apps.board.domain.qna.answer.model.dto;

import io.dustin.apps.board.domain.qna.answer.model.Answer;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record AnswerDto(
    Long id,
    String content,

    Long admin,

    LocalDateTime createdAt
) {
    public static AnswerDto from(Answer answer) {
        return AnswerDto.builder()
                .id(answer.getId())
                .content(answer.getContent())
                .admin(answer.getAdmin())
                .createdAt(answer.getCreatedAt())
                .build();
    }

}