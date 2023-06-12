package io.dustin.apps.board.domain.community.comment.service;

import io.dustin.apps.board.domain.community.comment.repository.CommentRepository;
import io.dustin.apps.board.domain.community.comment.model.Comment;
import io.dustin.apps.board.domain.community.posting.model.Posting;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        /** todo
         *  clickCount 한개 증가시키기
         */
        return getEntity(this.commentRepository.findById(id), Comment.class, "comment not fount");
    }

    @Transactional(readOnly = true)
    public Page<Comment> getList(Pageable pageable) {
//        List<Sort.Order> sorts = new ArrayList<>();
//        sorts.add(Sort.Order.desc("createDate"));
//        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return commentRepository.findAll(pageable);
    }

}
