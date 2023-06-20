package io.dustin.apps.board.domain.community.comment.service;

import io.dustin.apps.board.domain.like.model.LikeCountService;
import io.dustin.apps.board.domain.community.comment.repository.CommentRepository;
import io.dustin.apps.board.domain.community.posting.model.Posting;
import io.dustin.apps.board.domain.community.comment.model.Comment;
import io.dustin.apps.common.exception.DataNotFoundException;
import io.dustin.apps.user.domain.model.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service("comment")
public class WriteCommentService implements LikeCountService {

    private final CommentRepository commentRepository;

    public Comment create(Long userId, Long posting, Long reply, String content){
        Comment comment = Comment.builder()
                .content(content)
                .posting(posting)
                .userId(userId)
                .reply(reply)
                .build();
        this.commentRepository.save(comment);
        return comment;
    }

    @Transactional
    public void updateContent(Comment comment, String content){
        comment.updateContent(content);
    }

    @Transactional
    public void delete(Comment comment){
        comment.delete();
    }


    @Override
    public void likeCount(long id) { System.out.println("코멘트 게시판 id : [" + id + "] 카운트 하나 올림");
        Comment comment = this.findByIdOrThrow(id);
        Long LikeCount = comment.getLikeCount() + 1;
        comment.countUp(LikeCount);
    }

    @Override
    public void likeUnCount(long id) {
        System.out.println("코멘트 게시판 id : [" + id + "] 코멘트 카운트 하나 내림");
        Comment comment = this.findByIdOrThrow(id);
        Long LikeCount = comment.getLikeCount() - 1;
        comment.countUp(LikeCount);
    }

    public Comment findById(long id) {
        Optional<Comment> optional = this.commentRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    public Comment findByIdOrThrow(long id) {
        Optional<Comment> optional = this.commentRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            throw new DataNotFoundException("""
                    id [#1]로 조회된 댓글이 없습니다.""".replace("#1", String.valueOf(id)));
        }
    }


}
