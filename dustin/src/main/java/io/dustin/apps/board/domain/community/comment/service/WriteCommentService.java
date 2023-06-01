package io.dustin.apps.board.domain.community.comment.service;

import io.dustin.apps.board.domain.community.comment.repository.CommentRepository;
import io.dustin.apps.board.domain.qna.answer.model.Answer;
import io.dustin.apps.board.domain.community.comment.model.Comment;
import io.dustin.apps.board.domain.qna.question.model.Question;
import io.dustin.apps.user.domain.model.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class WriteCommentService {
    private final CommentRepository commentRepository;

    public Comment create(Question question, String content, SiteUser author){
        Comment comment = Comment.builder()
                .content(content)
                .question(question)
                .author(author)
                .build();
        this.commentRepository.save(comment);
        return comment;
    }

    public Comment create(Answer answer, String content, SiteUser author){
        Comment comment = Comment.builder()
                .content(content)
                .answer(answer)
                .author(author)
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

}
