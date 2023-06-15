package io.dustin.apps.board.api.usecase.bookmark;

import io.dustin.apps.board.domain.bookmark.model.Bookmark;
import io.dustin.apps.board.domain.bookmark.model.dto.BookMarkDto;
import io.dustin.apps.board.domain.bookmark.service.ReadBookmarkService;
import io.dustin.apps.board.domain.bookmark.service.WriteBookmarkService;
import io.dustin.apps.common.code.BoardType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DeleteBookmarkUseCase {

    private final WriteBookmarkService writeBookmarkService;
    private final ReadBookmarkService readBookmarkService;

    public BookMarkDto execute(Long id, Long userId, Long boardId, BoardType boardType) {
        Bookmark bookmark = readBookmarkService.getBookmark(id);
        if(!bookmark.getUserId().equals(userId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제 권한이 없습니다.");
        }
        writeBookmarkService.delete(id);
        BookMarkDto dto = BookMarkDto.from(bookmark);
        return BookMarkDto.from(bookmark);
    }
}
