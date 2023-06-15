package io.dustin.apps.board.api.usecase.follow;

import io.dustin.apps.board.domain.follow.model.Follow;
import io.dustin.apps.board.domain.follow.model.dto.FollowDto;
import io.dustin.apps.board.domain.follow.service.WriteFollowService;
import io.dustin.apps.board.domain.like.model.Like;
import io.dustin.apps.board.domain.like.model.dto.LikeDto;
import io.dustin.apps.common.code.BoardType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WriteFollowUseCase {

    private final WriteFollowService writeFollowService;

    public FollowDto execute(Long followerId, Long followingId) {
        Follow follow = writeFollowService.create(followerId, followingId);
        FollowDto dto = FollowDto.from(follow);
        return FollowDto.from(follow);
    }
}
