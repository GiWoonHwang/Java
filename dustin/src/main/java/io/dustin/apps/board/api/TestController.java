package io.dustin.apps.board.api;

import io.dustin.apps.board.domain.LikeCountService;
import io.dustin.apps.board.domain.like.model.dto.LikeItCommand;
import io.dustin.apps.common.code.BoardType;
import io.dustin.apps.common.model.QueryPage;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TestController {

    @PostMapping("/like")
    public String like(QueryPage queryPage, @RequestBody LikeItCommand command) {
        // TODO 좋아요 테이블에 저장되는 로직
        System.out.println(queryPage.pageable());
        System.out.println("좋아요 저장했습니다.");
        LikeCountService lcs = command.getBoardType().getBean();
        lcs.count(command.getBoardId());
        return "hello";
    }

    @PatchMapping("/unlike")
    public String unlike(@RequestBody LikeItCommand command) {
        System.out.println("좋아요 삭제했습니다.");
        LikeCountService lcs = command.getBoardType().getBean();
        lcs.unCount(command.getBoardId());
        return "hello";
    }

}
