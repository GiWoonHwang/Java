//package io.dustin.apps.board.domain.qna.comment;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//import io.dustin.apps.board.domain.qna.comment.model.Comment;
//import io.dustin.apps.board.domain.qna.question.model.Question;
//import io.dustin.apps.user.domain.model.SiteUser;
//import lombok.RequiredArgsConstructor;
//
//import org.springframework.stereotype.Service;
//
//@RequiredArgsConstructor
//@Service // 없으면 @org.springframework.beans.factory.annotation.Autowired(required=true)에러 발생
//public class CommentService {
//
//    private CommentRepository commentRepository;
//
//    public Comment create(Question question, SiteUser author, String content){
//
//        Comment c = new Comment();
//        c.setContent(content);
//        c.setCreateDate(LocalDateTime.now());
//        c.setQuestion(question);
//        c.setAuthor(author);
//        c = this.commentRepository.save(c);
//        return c;
//    }
//
//    public Optional<Comment> getComment(Integer id) {
//        return this.commentRepository.findById(id);
//    }
//
//    public Comment modify(Comment c, String content) {
//        c.setContent(content);
//        c.setModifyDate(LocalDateTime.now());
//        c = this.commentRepository.save(c);
//        return c;
//    }
//
//    public void delete(Comment c) {
//        this.commentRepository.delete(c);
//    }
//}
