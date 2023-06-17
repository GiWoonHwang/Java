package io.dustin.apps.board.domain.follow.repository;

import io.dustin.apps.board.domain.follow.model.Follow;
import io.dustin.apps.common.repository.BaseRepository;

public interface FollowRepository extends BaseRepository<Follow, Long> {

    Follow getFollowByFollowerIdAndFollowingId(Long followerId, Long followingId);
    void deleteByFollowerIdAndFollowingId(Long followerId, Long followingId);

    boolean existsByFollowerIdAndFollowingId(Long followerId, Long followingId);

}
