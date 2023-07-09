package io.dustin.apps.board.api.usecase.blockeduser;

import io.dustin.apps.board.domain.blockeduser.model.BlockedUser;
import io.dustin.apps.board.domain.blockeduser.model.dto.BlockedUserDto;
import io.dustin.apps.board.domain.blockeduser.service.ReadBlockedUserService;
import io.dustin.apps.board.domain.blockeduser.service.WriteBlockedUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DeleteBlockedUserUseCase {

    private final WriteBlockedUserService writeBlockedUserService;
    private final ReadBlockedUserService readBlockedUserService;

    public BlockedUserDto execute(Long fromUserId, Long toUserId) {
        BlockedUser blockedUser = readBlockedUserService.getBlockedUser(fromUserId, toUserId);
        if(!blockedUser.getFromUserId().equals(fromUserId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제 권한이 없습니다.");
        }
        writeBlockedUserService.delete(fromUserId, toUserId);
        BlockedUserDto dto = BlockedUserDto.from(blockedUser);
        return BlockedUserDto.from(blockedUser);
    }



}
