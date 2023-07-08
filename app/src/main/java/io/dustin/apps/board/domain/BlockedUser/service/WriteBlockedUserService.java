package io.dustin.apps.board.domain.BlockedUser.service;

import io.dustin.apps.board.domain.BlockedUser.model.BlockedUser;
import io.dustin.apps.board.domain.BlockedUser.repository.BlockedUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class WriteBlockedUserService {

    private final BlockedUserRepository blockedUserRepository;

    public BlockedUser create(Long fromUserId, Long toUserId){
        BlockedUser blockedUser = BlockedUser.builder()
                    .fromUserId(fromUserId)
                    .toUserId(toUserId)
                    .build();
        this.blockedUserRepository.save(blockedUser);
        return blockedUser;
    }

    @Transactional
    public void delete(Long fromUserId, Long toUserId) { this.blockedUserRepository.deleteByFromUserIdAndToUserId(fromUserId, toUserId);}



}
