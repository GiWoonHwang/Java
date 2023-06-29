package io.dustin.board.domain.community.comment.repository;

import io.dustin.board.common.repository.BaseRepository;
import io.dustin.board.domain.community.comment.model.Comment;
import io.dustin.board.domain.community.comment.repository.custom.CustomCommentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentRepository extends BaseRepository<Comment, Long>, CustomCommentRepository {

    Page<Comment> findAll(Pageable pageable);


}
