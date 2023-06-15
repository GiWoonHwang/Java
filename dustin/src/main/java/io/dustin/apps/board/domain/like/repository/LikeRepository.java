package io.dustin.apps.board.domain.like.repository;

import io.dustin.apps.board.domain.like.model.Like;
import io.dustin.apps.common.code.BoardType;
import io.dustin.apps.common.repository.BaseRepository;

public interface LikeRepository extends BaseRepository<Like, Long> {

    void deleteByUserIdAndBoardIdAndBoardType(Long userId, Long boardId, BoardType boardType);

    boolean existsByUserIdAndBoardIdAndBoardType(Long userId, Long boardId, BoardType boardType);
}
