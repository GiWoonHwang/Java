package io.dustin.apps.board.api.usecase.like;

import io.dustin.apps.board.domain.like.model.Like;
import io.dustin.apps.board.domain.like.model.dto.LikeDto;
import io.dustin.apps.board.domain.like.service.ReadLIkeService;
import io.dustin.apps.board.domain.like.service.WriteLikeService;
import io.dustin.apps.common.code.BoardType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DeleteLikeUseCase {

    private final WriteLikeService writeLikeService;
    private final ReadLIkeService readLIkeService;

    public LikeDto execute(Long boardId, Long userId, BoardType boardType) {
        Like like = readLIkeService.getLike(boardId, userId, boardType);
        if(!like.getUserId().equals(userId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제 권한이 없습니다.");
        }
        writeLikeService.delete(boardId, userId, boardType);
        LikeDto dto = LikeDto.from(like);
        return LikeDto.from(like);
    }

}
