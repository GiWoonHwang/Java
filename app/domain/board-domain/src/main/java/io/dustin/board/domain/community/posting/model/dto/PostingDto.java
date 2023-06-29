package io.dustin.board.domain.community.posting.model.dto;

import io.dustin.board.common.model.IdAble;
import io.dustin.board.domain.community.posting.model.Posting;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record PostingDto (
        Long id,
        Long userId,
        @NotBlank
        @Min(5)
        String subject,
        @NotBlank
        @Min(5)
        String content,
        Boolean isLike,
        Boolean isBookmark,
        Long commentCnt,
        Long clickCnt,
        Long likeCount,
        LocalDateTime createdAt

) implements IdAble {
    public static PostingDto from(Posting posting) {
        return PostingDto.builder()
                .id(posting.getId())
                .userId(posting.getUserId())
                .subject(posting.getSubject())
                .content(posting.getContent())
                .createdAt(posting.getCreatedAt())
                .build();
    }

    @Override
    public Long getId() {
        return this.id;
    }

}
