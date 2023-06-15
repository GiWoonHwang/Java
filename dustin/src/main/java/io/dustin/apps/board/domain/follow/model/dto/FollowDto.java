package io.dustin.apps.board.domain.follow.model.dto;

import io.dustin.apps.board.domain.follow.model.Follow;
import io.dustin.apps.board.domain.like.model.Like;
import io.dustin.apps.board.domain.like.model.dto.LikeDto;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record FollowDto (
        Long id,
        Long followerID,
        Long followingId,

        LocalDateTime createdAt
) {
    public static FollowDto from(Follow follow) {
        return FollowDto.builder()
                .id(follow.getId())
                .followerID(follow.getFollowerID())
                .followingId(follow.getFollowingId())
                .createdAt(follow.getCreatedAt())
                .build();
    }
}
