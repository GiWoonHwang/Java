package io.dustin.apps.board.domain.community.comment.service;

import io.dustin.apps.board.domain.community.comment.model.dto.CommentDto;
import io.dustin.apps.board.domain.community.comment.repository.CommentRepository;
import io.dustin.apps.board.domain.community.comment.model.Comment;
import io.dustin.apps.board.domain.community.posting.model.Posting;
import io.dustin.apps.common.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static io.dustin.apps.common.utils.OptionalUtils.getEntity;

/**
 * cqrs -> srp
 */
@Service
@RequiredArgsConstructor
public class ReadCommentService {

    private final CommentRepository commentRepository;

    @Transactional(readOnly = true)
    public List<CommentDto> getCommentsByPosting(long loginId, long postingId, int size, Long nextId) {
        return commentRepository.commentListByPosting(loginId, postingId, size, nextId);
    }

    @Transactional(readOnly = true)
    public List<CommentDto> replyListByComment(long loginId, long commentId, int size, Long nextId) {
        return commentRepository.replyListByComment(loginId, commentId, size, nextId);
    }


    @Transactional(readOnly = true)
    public Comment findById(long id) {
        Optional<Comment> optional = this.commentRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }
    @Transactional(readOnly = true)
    public Comment findByIdOrThrow(long id) {
        Optional<Comment> optional = this.commentRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            throw new DataNotFoundException("""
                    id [#1]로 조회된 게시물이 없습니다.""".replace("#1", String.valueOf(id)));
        }
    }

}
