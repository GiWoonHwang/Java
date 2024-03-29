package io.dustin.admin.notice.model.dto;


import io.dustin.admin.notice.model.Notice;
import io.dustin.common.model.IdAble;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record NoticeDto (

        Long id,

        Long adminId,

        @NotBlank
        @Min(5)
        String subject,

        @NotBlank
        @Min(5)
        String content,

        Boolean isLike,

        Long clickCount,

        LocalDateTime createdAt

) implements IdAble {
    public static NoticeDto from(Notice notice) {
        return NoticeDto.builder()
                .id(notice.getId())
                .subject(notice.getSubject())
                .content(notice.getContent())
                .adminId(notice.getAdminId())
                .clickCount(notice.getClickCount())
                .createdAt(notice.getCreatedAt())
                .build();
    }

    @Override
    public Long getId() {
        return this.id;
    }



}

