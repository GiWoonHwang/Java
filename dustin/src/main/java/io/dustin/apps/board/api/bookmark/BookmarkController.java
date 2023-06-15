package io.dustin.apps.board.api.bookmark;

import io.dustin.apps.board.api.usecase.bookmark.DeleteBookmarkUseCase;
import io.dustin.apps.board.api.usecase.bookmark.WriteBookmarkUseCase;
import io.dustin.apps.board.api.usecase.like.DeleteLikeUseCase;
import io.dustin.apps.board.api.usecase.like.WriteLikeUseCase;
import io.dustin.apps.board.domain.bookmark.model.dto.BookMarkDto;
import io.dustin.apps.board.domain.like.model.LikeCountService;
import io.dustin.apps.board.domain.like.model.dto.LikeDto;
import io.dustin.apps.board.domain.like.model.dto.LikeItCommand;
import io.dustin.apps.common.model.QueryPage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BookmarkController {

    private final WriteBookmarkUseCase writeBookmarkUseCase;
    private final DeleteBookmarkUseCase deleteBookmarkUseCase;

    @PostMapping("/bookmarks/add")
    public BookMarkDto add(@RequestBody BookMarkDto bookMarkDto) {
        // TODO 북마크 테이블에 저장되는 로직
        System.out.println("북마크 저장했습니다.");
        return writeBookmarkUseCase.execute(bookMarkDto.userId(), bookMarkDto.boardId(), bookMarkDto.boardType());
    }

    @PatchMapping("/bookmarks/cancel")
    public BookMarkDto cancel(BookMarkDto bookMarkDto) {
        // TODO 북마크 테이블에 삭제되는 로직
        System.out.println("북마크 삭제했습니다.");
        return deleteBookmarkUseCase.execute(bookMarkDto.id(), bookMarkDto.userId(), bookMarkDto.boardId(), bookMarkDto.boardType());
    }

}