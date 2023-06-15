package io.dustin.apps.board.domain.bookmark.service;

import io.dustin.apps.board.domain.bookmark.model.Bookmark;
import io.dustin.apps.board.domain.bookmark.repository.BookmarkRepository;
import io.dustin.apps.board.domain.like.model.Like;
import io.dustin.apps.common.code.BoardType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WriteBookmarkService {

    private final BookmarkRepository bookmarkRepository;

    public Bookmark create(Long userId, Long boardId, BoardType boardType){
        Bookmark bookmark = Bookmark.builder()
                .userId(userId)
                .boardId(boardId)
                .boardType(boardType)
                .build();
        this.bookmarkRepository.save(bookmark);
        return bookmark;
    }

    public void delete(Long id){
        this.bookmarkRepository.deleteById(id);
    }


}
