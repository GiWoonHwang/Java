package io.dustin.apps.board.domain.notice.model.dto;

import io.dustin.apps.board.domain.community.posting.model.Posting;
import io.dustin.apps.board.domain.notice.model.Notice;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record NoticeDto (

        Long id,

        String subject,

        String content,

        Long admin,

        LocalDateTime createdAt

) {
    public static NoticeDto from(Notice notice) {
        return NoticeDto.builder()
                .id(notice.getId())
                .subject(notice.getSubject())
                .content(notice.getContent())
                .admin(notice.getAdmin())
                .createdAt(notice.getCreatedAt())
                .build();
    }



}

