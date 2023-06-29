package io.dustin.board.domain.like.model.dto;

import io.dustin.board.common.code.BoardType;
import io.dustin.board.domain.like.model.Like;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record LikeDto (
        Long id,
        Long boardId,
        Long userId,
        BoardType boardType,
        LocalDateTime createdAt
) {
    public static LikeDto from(Like like) {
        return LikeDto.builder()
                .id(like.getId())
                .boardId(like.getBoardId())
                .userId(like.getUserId())
                .boardType(like.getBoardType())
                .createdAt(like.getCreatedAt())
                .build();
    }


}
