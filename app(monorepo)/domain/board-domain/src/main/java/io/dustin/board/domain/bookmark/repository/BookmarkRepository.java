package io.dustin.board.domain.bookmark.repository;

import io.dustin.board.domain.bookmark.model.Bookmark;
import io.dustin.common.repository.BaseRepository;

import java.util.Optional;

public interface BookmarkRepository extends BaseRepository<Bookmark, Long> {

    void deleteByUserIdAndBoardId(Long userId, Long boardId);

    Optional<Bookmark> findByUserIdAndBoardId(Long userId, Long boardId);
}
