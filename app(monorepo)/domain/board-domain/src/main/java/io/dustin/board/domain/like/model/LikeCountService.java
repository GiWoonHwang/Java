package io.dustin.board.domain.like.model;

public interface LikeCountService {
    void likeCount(long id);
    void likeUnCount(long id);
}
