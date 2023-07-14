package io.dustin.apps.board.api.usecase.blockeduser;

import io.dustin.apps.board.domain.blockeduser.model.BlockedUser;
import io.dustin.apps.board.domain.blockeduser.model.dto.BlockedUserDto;
import io.dustin.apps.board.domain.blockeduser.service.ReadBlockedUserService;
import io.dustin.apps.board.domain.blockeduser.service.WriteBlockedUserService;
import io.dustin.apps.common.exception.BadRequestParameterException;
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
        try{
            /**
             * 프론트에서 db에 존재하지 않는 데이터를 던졌다
             * 나의 생각으로는 readBlockedUserService.getBlockedUser 에서 처리한 에러를 반환해야 한다고 생각했지만
             * 실제로는 catch 구문의  throw new BadRequestParameterException("잘못된 요청입니다.")를 반환했다
             * 왜 그런걸까?  일단 위의 상황을 정리해보면 if 문은 필요없는 코드가 된다.
             */

            BlockedUser blockedUser = readBlockedUserService.getBlockedUser(fromUserId, toUserId);
//            if(blockedUser == null) {
//                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "존재 하지 않는 데이터 입니다.");
//            }
//            if(!blockedUser.getFromUserId().equals(fromUserId)) {
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제 권한이 없습니다.");
//            }
            writeBlockedUserService.delete(fromUserId, toUserId);
            BlockedUserDto dto = BlockedUserDto.from(blockedUser);
            return BlockedUserDto.from(blockedUser);

        }catch (Exception e) {
            throw new BadRequestParameterException("잘못된 요청입니다.");
        }
    }



}
