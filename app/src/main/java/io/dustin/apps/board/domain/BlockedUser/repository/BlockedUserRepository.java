package io.dustin.apps.board.domain.BlockedUser.repository;

import io.dustin.apps.board.domain.BlockedUser.model.BlockedUser;
import io.dustin.apps.common.repository.BaseRepository;

import java.util.Optional;

public interface BlockedUserRepository extends BaseRepository<BlockedUser, Long> {


    void deleteByFromUserIdAndToUserId(Long fromUserId, Long toUserId);
    Optional<BlockedUser> findByFromUserIdAndToUserId(Long fromUserId, Long toUserId);


}
