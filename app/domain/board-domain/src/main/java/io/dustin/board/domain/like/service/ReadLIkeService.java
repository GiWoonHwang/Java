package io.dustin.board.domain.like.service;

import io.dustin.board.common.code.BoardType;
import io.dustin.board.domain.like.model.Like;
import io.dustin.board.domain.like.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static io.dustin.board.common.utils.OptionalUtils.getEntity;

@RequiredArgsConstructor
@Service
public class ReadLIkeService {

    private final LikeRepository likeRepository;

    @Transactional(readOnly = true)
    public Like getLike(Long userId, Long boardId, BoardType boardType) {
        return getEntity(this.likeRepository.findByUserIdAndBoardIdAndBoardType(userId, boardId, boardType), Like.class, "like not found");
    }

}
