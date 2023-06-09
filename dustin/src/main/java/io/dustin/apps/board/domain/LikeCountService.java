package io.dustin.apps.board.domain;

public interface LikeCountService {
    void likeCount(long id);
    void likeUncount(long id);
}
