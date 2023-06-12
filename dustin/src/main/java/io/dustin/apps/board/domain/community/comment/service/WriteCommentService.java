package io.dustin.apps.board.domain.community.comment.service;

import io.dustin.apps.board.domain.LikeCountService;
import io.dustin.apps.board.domain.community.comment.repository.CommentRepository;
import io.dustin.apps.board.domain.community.posting.model.Posting;
import io.dustin.apps.board.domain.community.comment.model.Comment;
import io.dustin.apps.user.domain.model.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service("comment")
public class WriteCommentService implements LikeCountService {
    private final CommentRepository commentRepository;

    public Comment create(Posting posting, String content, SiteUser author){
        Comment comment = Comment.builder()
                .content(content)
                .posting(posting)
                .author(author)
                .build();
        this.commentRepository.save(comment);
        return comment;
    }

    @Transactional
    public void updateContent(Comment comment, String content){
        comment.updateContent(content);
    }

    public void delete(Comment comment){
        comment.delete();
    }


    @Override
    public void likeCount(long id) {
        System.out.println("코멘트 게시판 id : [" + id + "] 카운트 하나 올림");
    }

    @Override
    public void likeUncount(long id) {
        System.out.println("코멘트 게시판 id : [" + id + "] 코멘트 카운트 하나 내림");
    }

}
