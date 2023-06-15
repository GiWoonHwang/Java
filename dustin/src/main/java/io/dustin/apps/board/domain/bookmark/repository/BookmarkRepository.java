package io.dustin.apps.board.domain.bookmark.repository;

import io.dustin.apps.board.domain.bookmark.model.Bookmark;
import io.dustin.apps.common.code.BoardType;
import io.dustin.apps.common.repository.BaseRepository;

public interface BookmarkRepository extends BaseRepository<Bookmark, Long> {

    void deleteByUserIdAndBoardIdAndBoardType(Long userId, Long boardId, BoardType boardType);

    boolean existsByUserIdAndBoardIdAndBoardType(Long userId, Long boardId, BoardType boardType);
}