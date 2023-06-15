package io.dustin.apps.board.domain.follow.repository;

import io.dustin.apps.board.domain.follow.model.Follow;
import io.dustin.apps.common.repository.BaseRepository;

public interface FollowRepository extends BaseRepository<Follow, Long> {

    Follow getFollowByFollowerIdAndFollowingID(Long followerId, Long followingId);
    void deleteByFollowerIdAndFollowingID(Long followerId, Long followingId);

    boolean existsByFollowerIdAndFollowingId(Long followerId, Long followingId);

}
