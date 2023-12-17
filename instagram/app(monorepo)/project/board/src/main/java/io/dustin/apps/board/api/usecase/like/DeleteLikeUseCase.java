package io.dustin.apps.board.api.usecase.like;

import io.dustin.board.domain.like.model.Like;
import io.dustin.board.domain.like.model.dto.LikeDto;
import io.dustin.board.domain.like.service.ReadLIkeService;
import io.dustin.board.domain.like.service.WriteLikeService;
import io.dustin.board.common.code.BoardType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DeleteLikeUseCase {

    private final WriteLikeService writeLikeService;
    private final ReadLIkeService readLIkeService;

    @Transactional
    public LikeDto execute(Long userId, Long boardId, BoardType boardType) {
        Like like = readLIkeService.getLike(userId, boardId, boardType);
        if(!like.getUserId().equals(userId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제 권한이 없습니다.");
        }
        writeLikeService.delete(userId, boardId, boardType);
        LikeDto dto = LikeDto.from(like);
        return LikeDto.from(like);
    }

}
