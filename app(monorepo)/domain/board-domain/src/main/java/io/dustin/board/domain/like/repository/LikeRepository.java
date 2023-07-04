package io.dustin.board.domain.like.repository;


import io.dustin.board.domain.like.model.Like;
import io.dustin.board.common.code.BoardType;
import io.dustin.common.repository.BaseRepository;

import java.util.Optional;

public interface LikeRepository extends BaseRepository<Like, Long> {

    void deleteByUserIdAndBoardIdAndBoardType(Long userId, Long boardId, BoardType boardType);
    Optional<Like> findByUserIdAndBoardIdAndBoardType(Long userId, Long boardId, BoardType boardType);
}
