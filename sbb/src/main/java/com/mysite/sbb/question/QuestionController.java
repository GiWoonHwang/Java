package com.mysite.sbb.question;

import java.security.Principal;
import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import com.mysite.sbb.user.SiteUser;
import com.mysite.sbb.user.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import com.mysite.sbb.answer.AnswerForm;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
@RequestMapping("/question") // url prefix
@RequiredArgsConstructor
@Controller
public class QuestionController {
    private final QuestionService questionService;
    private final UserService userService;


//    @ResponseBody  어노테이션을 지우면 html 파일을 불러온다.
    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "page",defaultValue = "0") int page, @RequestParam(value = "kw", defaultValue = "") String kw) { // 스프링부트의 페이징은 첫페이지 번호가 1이 아닌 0이다.
        /*
        Question 리포지터의 findAll 메서드를 사용하여 질문 목록 데이터인 questionList를 생성하고 Model 객체에 "questionList" 라는 이름으로 값을 저장했다.
        Model 객체는 자바 클래스와 템플릿 간의 연결고리 역할을 한다. Model 객체에 값을 담아두면 템플릿에서 그 값을 사용할 수 있다.
         */
        Page<Question> paging = this.questionService.getList(page, kw);
        model.addAttribute("paging", paging);
        model.addAttribute("kw", kw);

        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList); // questionList 라는 이름으로 담아두었다. 템플릿에서 사용할 수 있다.
        return "question_list";
    }

    @GetMapping(value = "/detail/{id}")
    /*
    요청 URL http://localhost:8080/question/detail/2의 숫자 2처럼 변하는 id 값을 얻을 때에는 위와 같이 @PathVariable 애너테이션을 사용해야 한다.
    이 때 @GetMapping(value = "/question/detail/{id}") 에서 사용한 id와 @PathVariable("id")의 매개변수 이름이 동일해야 한다.
     */
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    // Get 요청으로 템플릿을 띄운다.
    @PreAuthorize("isAuthenticated()") // 로그인이 필요한 메서드를 의미함
    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        /*
        템플릿을 위와 같이 수정할 경우 QuestionController의 GetMapping으로 매핑한 메서드도 다음과 같이 변경해야 한다.
        왜냐하면 question_form.html 템플릿은 "질문 등록하기" 버튼을 통해 GET 방식으로 요청되더라도 th:object에 의해 QuestionForm 객체가 필요하기 때문이다.
         */
        return "question_form";
    }

    // 메서드 이름은 같고, 매개변수가 다른 메서드 오버로딩 적용
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult, Principal principal){
        /*
        questionCreate 메서드의 매개변수를 subject, cotent 대신 QuestionForm 객체로 변경했다. subject, content 항목을 지닌 폼이 전송되면
        QuestionForm의 subject, content 속성이 자동으로 바인딩 된다. 이것은 스프링 프레임워크의 바인딩 기능이다.

         QuestionForm 매개변수 앞에 @Valid 애너테이션을 적용했다. @Valid 애너테이션을 적용하면 QuestionForm의 @NotEmpty, @Size 등으로 설정한 검증 기능이 동작한다.
         그리고 이어지는 BindingResult 매개변수는 @Valid 애너테이션으로 인해 검증이 수행된 결과를 의미하는 객체이다.
         */
        if(bindingResult.hasErrors()){ // 검증이 실패하면
            return "question_form"; // 다시 돌아가라
        }
        // todo 질문을 저장한다.
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.questionService.create(questionForm.getSubject(), questionForm.getContent(), siteUser);
        return "redirect:/question/list"; // 질문 저장 후 질문 목록으로 이동

    }

    // 수정 버튼을 누르면 양식을 띄운다.
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/modify/{id}")
    public String questionModify(QuestionForm questionForm, @PathVariable("id") Integer id, Principal principal) {
        Question question = this.questionService.getQuestion(id);
        if(!question.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        questionForm.setSubject(question.getSubject());
        questionForm.setContent(question.getContent());
        return "question_form";
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/modify/{id}")
    public String questionModify(@Valid QuestionForm questionForm, BindingResult bindingResult,
                                 Principal principal, @PathVariable("id") Integer id) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        Question question = this.questionService.getQuestion(id);
        if (!question.getAuthor().getUsername().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        this.questionService.modify(question, questionForm.getSubject(), questionForm.getContent());
        return String.format("redirect:/question/detail/%s", id);
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/delete/{id}")
    public String questionDelete(Principal principal, @PathVariable("id") Integer id){
        Question question = this.questionService.getQuestion(id);
        if(!question.getAuthor().getUsername().equals(principal.getName())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제권한이 없습니다.");
        }
        this.questionService.delete(question);
        return "redirect:/";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/vote/{id}")
    public String questionVote(Principal principal, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.questionService.vote(question,siteUser);
        return String.format("redirect:/question/detail/%s", id);
    }




}
