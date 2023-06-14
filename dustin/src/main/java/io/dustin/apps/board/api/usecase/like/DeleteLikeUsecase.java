package io.dustin.apps.board.api.usecase.like;

import io.dustin.apps.board.domain.like.model.Like;
import io.dustin.apps.board.domain.like.model.dto.LikeDto;
import io.dustin.apps.board.domain.like.service.ReadLIkeService;
import io.dustin.apps.board.domain.like.service.WriteLikeService;
import io.dustin.apps.common.code.BoardType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteLikeUsecase {

    private final WriteLikeService writeLikeService;
    private final ReadLIkeService readLIkeService;

    public LikeDto execute(Long id, Long boardId, Long userId, BoardType boardType) {
        Like like = readLIkeService.
        writeLikeService.delete(id);
        LikeDto dto = LikeDto.from(like);
        return LikeDto.from(like);
    }

}
