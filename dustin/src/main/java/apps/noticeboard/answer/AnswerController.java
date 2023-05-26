package apps.noticeboard.answer;
import libs.entities.Question;
import apps.noticeboard.question.QuestionService;
import libs.entities.SiteUser;
import apps.noticeboard.user.UserService;
import libs.entities.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final UserService userService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id,
        @Valid  AnswerForm answerForm, BindingResult bindingResult, Principal principal ){
        /*
        현재 로그인한 사용자에 대한 정보를 알기 위해서는 스프링 시큐리티가 제공하는 Principal를 이용한다.
         */
        Question question = this.questionService.getQuestion(id);
        SiteUser siteUser = this.userService.getUser(principal.getName()); // 로그인한 유저의 정보를 받아서
        if(bindingResult.hasErrors()){
            // question_detail 템플릿은 Question 객체가 필요하므로 model 객체에 Question 객체를 저장한 후에 question_detail 템플릿을 렌더링해야 한다.
            model.addAttribute("question", question);
            return "question_detail";
        }

        // todo: 답변을 저장한다.
        Answer answer = this.answerService.create(question,answerForm.getContent(), siteUser); // 매개변수로 전달
        return String.format("redirect:/question/detail/%s#answer_%s", answer.getQuestion().getId(), answer.getId());
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{id}")
    public String answerModify(AnswerForm answerForm, @PathVariable("id") Integer id, Principal principal) {
        Answer answer = this.answerService.getAnswer(id);
        if(!answer.getAuthor().getUsername().equals(principal.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        answerForm.setContent(answer.getContent());
        return "answer_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/modify/{id}")
    public String answerModify(@Valid AnswerForm answerForm, BindingResult bindingResult,
                               @PathVariable("id") Integer id, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "answer_form";
        }
        Answer answer = this.answerService.getAnswer(id);
        if (!answer.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        this.answerService.modify(answer, answerForm.getContent());
        return String.format("redirect:/question/detail/%s#answer_%s",
                answer.getQuestion().getId(), answer.getId());
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String answerDelete(Principal principal, @PathVariable("id") Integer id) {
        Answer answer = answerService.getAnswer(id);
        if(!answer.getAuthor().getUsername().equals(principal.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
        }
        this.answerService.delete(answer);
        return String.format("redirect:/question/detail/%s", answer.getQuestion().getId());
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/vote/{id}")
    public String answerVote(Principal principal, @PathVariable("id") Integer id){
        Answer answer = answerService.getAnswer(id);
        SiteUser siteUser = userService.getUser(principal.getName());
        this.answerService.vote(answer, siteUser);
        return String.format("redirect:/question/detail/%s#answer_%s",
                answer.getQuestion().getId(), answer.getId());
    }
}
