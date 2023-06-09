package io.dustin.apps.board.domain;

public interface LikeCountService {
    void count(long id);
    void unCount(long id);
}
