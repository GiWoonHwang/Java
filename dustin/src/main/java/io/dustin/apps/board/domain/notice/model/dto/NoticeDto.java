package io.dustin.apps.board.domain.notice.model.dto;

import io.dustin.apps.board.domain.community.posting.model.Posting;
import io.dustin.apps.board.domain.notice.model.Notice;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record NoticeDto (

        Long id,

        Long adminId,

        String subject,

        String content,

        LocalDateTime createdAt

) {
    public static NoticeDto from(Notice notice) {
        return NoticeDto.builder()
                .id(notice.getId())
                .subject(notice.getSubject())
                .content(notice.getContent())
                .adminId(notice.getAdminId())
                .createdAt(notice.getCreatedAt())
                .build();
    }



}

