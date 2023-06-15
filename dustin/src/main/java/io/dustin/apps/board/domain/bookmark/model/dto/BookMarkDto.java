package io.dustin.apps.board.domain.bookmark.model.dto;

import io.dustin.apps.board.domain.bookmark.model.Bookmark;
import io.dustin.apps.board.domain.like.model.Like;
import io.dustin.apps.board.domain.like.model.dto.LikeDto;
import io.dustin.apps.common.code.BoardType;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BookMarkDto (
        Long id,
        Long boardId,
        Long userId,
        BoardType boardType,
        LocalDateTime createdAt

) {
    public static BookMarkDto from(Bookmark bookmark) {
        return BookMarkDto.builder()
                .id(bookmark.getId())
                .boardId(bookmark.getBoardId())
                .userId(bookmark.getUserId())
                .boardType(bookmark.getBoardType())
                .createdAt(bookmark.getCreatedAt())
                .build();
    }
}
