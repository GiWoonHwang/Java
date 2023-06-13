package io.dustin.apps.board.domain.like.service;

import io.dustin.apps.board.domain.like.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReadLIkeService {

    private final LikeRepository likeRepository;

    /**
     * todo
     * 특정 게시물의 좋아요 누른사람리스트를 가져온다
     */
}
