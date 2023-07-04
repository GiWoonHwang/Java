package io.dustin.board.domain.follow.repository;


import io.dustin.board.domain.follow.model.Follow;
import io.dustin.common.repository.BaseRepository;

public interface FollowRepository extends BaseRepository<Follow, Long> {

    Follow findByFollowerIdAndFollowingId(Long followerId, Long followingId);
    void deleteByFollowerIdAndFollowingId(Long followerId, Long followingId);


}
