package io.dustin.apps.board.domain.qna.comment.service;

import io.dustin.apps.board.domain.qna.comment.repository.CommentRepository;
import io.dustin.apps.board.domain.qna.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static io.dustin.apps.common.utils.OptionalUtils.getEntity;

/**
 * cqrs -> srp
 */
@Service
@RequiredArgsConstructor
public class ReadCommentService {

    private final CommentRepository commentRepository;

    @Transactional(readOnly = true)
    public Comment getComment(Long id) {
        return getEntity(this.commentRepository.findById(id), Comment.class, "comment not fount");
    }

}
