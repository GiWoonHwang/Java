package io.dustin.apps.board.domain.follow.service;

import io.dustin.apps.board.domain.follow.model.Follow;
import io.dustin.apps.board.domain.follow.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WriteFollowService {
    private FollowRepository followRepository;

    public Follow getFollow(Long followerId, Long followingId) {
        return this.followRepository.getFollowByFollowerIdAndFollowingID(followerId,followingId);
    }

    public Follow create(Long followerID, Long followingId){
        Follow follow = Follow.builder()
                .followerID(followerID)
                .followingId(followingId)
                .build();
        this.followRepository.save(follow);
        return follow;
    }

    public void delete(Long followerID, Long followingId) {
        this.followRepository.deleteByFollowerIdAndFollowingID(followerID, followingId);
    }



}
