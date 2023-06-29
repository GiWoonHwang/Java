package io.dustin.board.domain.like.repository;


import io.dustin.board.common.code.BoardType;
import io.dustin.board.common.repository.BaseRepository;
import io.dustin.board.domain.like.model.Like;

import java.util.Optional;

public interface LikeRepository extends BaseRepository<Like, Long> {

    void deleteByUserIdAndBoardIdAndBoardType(Long userId, Long boardId, BoardType boardType);
    Optional<Like> findByUserIdAndBoardIdAndBoardType(Long userId, Long boardId, BoardType boardType);
}
