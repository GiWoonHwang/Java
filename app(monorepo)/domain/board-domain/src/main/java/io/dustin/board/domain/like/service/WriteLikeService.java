package io.dustin.board.domain.like.service;

import io.dustin.board.domain.like.model.Like;
import io.dustin.board.domain.like.repository.LikeRepository;
import io.dustin.board.common.code.BoardType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class WriteLikeService {

    private final LikeRepository likeRepository;

    public Like create(Long userId, Long boardId, BoardType boardType){
        Like like = Like.builder()
                .userId(userId)
                .boardId(boardId)
                .boardType(boardType)
                .build();
        this.likeRepository.save(like);
        return like;
    }

    @Transactional
    public void delete(Long userId, Long boardId, BoardType boardType){
        this.likeRepository.deleteByUserIdAndBoardIdAndBoardType(userId, boardId, boardType);
    }
}
