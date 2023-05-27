package dustin.apps.board.domain.qna.comment;

import java.security.Principal;
import java.util.Optional;

import dustin.apps.board.domain.qna.validation.CommentForm;
import dustin.apps.board.domain.qna.question.service.WriteQuestionService;
import dustin.apps.board.domain.qna.user.service.WriteUserService;
import jakarta.validation.Valid;

import dustin.apps.board.domain.qna.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import dustin.apps.board.domain.qna.model.Question;
import dustin.apps.board.domain.qna.model.SiteUser;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private WriteQuestionService questionService;

    @Autowired
    private WriteUserService userService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/create/question/{id}")
    public String createQuestionComment(CommentForm commentForm) {
        return "comment_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping(value = "/create/question/{id}")
    public String createQuestionComment(@PathVariable("id") Integer id, @Valid CommentForm commentForm,
                                        BindingResult bindingResult, Principal principal) {
        Optional<Question> question = Optional.ofNullable(this.questionService.getQuestion(id));
        Optional<SiteUser> user = Optional.ofNullable(this.userService.getUser(principal.getName())); // 왜 오류가 날까 ??

        if(question.isPresent() && user.isPresent()) { // 유저랑 게시물이 존재하면 댓글 쓰게 하라
            if(bindingResult.hasErrors()){

                return "comment_form";
            }
            Comment c = this.commentService.create(question.get(), user.get(), commentForm.getContent()); // 댓글 작성

            return String.format("redirect:/question/detail/%s", c.getQuestionId()); // 앵커를 이용한 리다이렉트
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{id}")
    public String modifyComment(CommentForm commentForm, @PathVariable("id") Integer id, Principal principal) {
        // 코멘트 폼 띄우기
        Optional<Comment> comment = this.commentService.getComment(id);
        if(comment.isPresent()) {
            Comment c = comment.get(); // 코멘트에 대한 정보 가져옴
            if(!c.getAuthor().getUsername().equals(principal.getName())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
            }
            commentForm.setContent(c.getContent()); // 일단 기존에 작성한거 불러온다.
        }
        return "comment_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/modify/{id}")
    public String modifyComment(@Valid CommentForm commentForm, BindingResult bindingResult, Principal principal,
                                @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors()) {
            return "comment_form"; // form 양식을 만족하지 못하면
        }
        Optional<Comment> comment = this.commentService.getComment(id);
        if (comment.isPresent()) {
            Comment c = comment.get();

            if (!c.getAuthor().getUsername().equals(principal.getName())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
            }
            c = this.commentService.modify(c, commentForm.getContent());
            return String.format("redirect:/question/detail/%s", c.getQuestionId());

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String deleteComment(Principal principal, @PathVariable("id") Integer id) {
        Optional<Comment> comment = this.commentService.getComment(id);
        if (comment.isPresent()) {
            Comment c = comment.get();
            if (!c.getAuthor().getUsername().equals(principal.getName())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
            }
            this.commentService.delete(c);
            return String.format("redirect:/question/detail/%s", c.getQuestionId());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
        }
    }

}
