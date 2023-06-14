package io.dustin.apps.board.api.like;

import io.dustin.apps.board.api.usecase.like.DeleteLikeUsecase;
import io.dustin.apps.board.api.usecase.like.WriteLikeUseCase;
import io.dustin.apps.board.domain.like.model.LikeCountService;
import io.dustin.apps.board.domain.like.model.dto.LikeDto;
import io.dustin.apps.board.domain.like.model.dto.LikeItCommand;
import io.dustin.apps.common.model.QueryPage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class LikeController {

    private final WriteLikeUseCase writeLikeUseCase;
    private final DeleteLikeUsecase deleteLikeUsecase;

    @PostMapping("/like")
    public LikeDto like(QueryPage queryPage, @RequestBody LikeItCommand command) {
        // TODO 좋아요 테이블에 저장되는 로직
        System.out.println(queryPage.pageable());
        System.out.println("좋아요 저장했습니다.");
        LikeCountService lcs = command.getBoardType().getBean();
        lcs.likeCount(command.getBoardId());
        return writeLikeUseCase.execute(command.getBoardId(), command.getUserId(), command.getBoardType());
    }

    @PatchMapping("/unlike")
    public LikeDto unlike(@RequestBody LikeItCommand command) {
        // TODO 좋아요 테이블에 삭제되는 로직
        System.out.println("좋아요 삭제했습니다.");
        LikeCountService lcs = command.getBoardType().getBean();
        lcs.likeUncount(command.getBoardId());
        return deleteLikeUsecase.execute(command.getId(), command.getBoardId(), command.getUserId(), command.getBoardType());
    }

}
