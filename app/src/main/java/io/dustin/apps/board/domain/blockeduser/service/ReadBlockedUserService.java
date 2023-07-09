package io.dustin.apps.board.domain.blockeduser.service;


import io.dustin.apps.board.domain.blockeduser.model.BlockedUser;
import io.dustin.apps.board.domain.blockeduser.repository.BlockedUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static io.dustin.apps.common.utils.OptionalUtils.getEntity;

@RequiredArgsConstructor
@Service
public class ReadBlockedUserService {

    private final BlockedUserRepository blockedUserRepository;

    public BlockedUser getBlockedUser(Long fromUserId, Long toUserId) { return getEntity(this.blockedUserRepository.findByFromUserIdAndToUserId(fromUserId, toUserId), BlockedUser.class, "bookmark not found"); }
}
