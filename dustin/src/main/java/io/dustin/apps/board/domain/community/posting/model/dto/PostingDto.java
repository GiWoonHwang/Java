package io.dustin.apps.board.domain.community.posting.model.dto;

import io.dustin.apps.board.domain.community.posting.model.Posting;
import io.dustin.apps.board.domain.qna.question.model.Question;
import io.dustin.apps.board.domain.qna.question.model.dto.QuestionDto;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record PostingDto (

        Long id,

        String subject,

        String content,

        Long userId,

        LocalDateTime createdAt

) {
    public static PostingDto from(Posting posting) {
        return PostingDto.builder()
                .id(posting.getId())
                .subject(posting.getSubject())
                .content(posting.getContent())
                .userId(posting.getAuthor())
                .createdAt(posting.getCreatedAt())
                .build();
    }

}
