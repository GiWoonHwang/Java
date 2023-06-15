package io.dustin.apps.board.domain.like.service;

import io.dustin.apps.board.domain.like.model.Like;
import io.dustin.apps.board.domain.like.repository.LikeRepository;
import io.dustin.apps.common.code.BoardType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public void delete(Long id){
        this.likeRepository.deleteById(id);
    }
}
