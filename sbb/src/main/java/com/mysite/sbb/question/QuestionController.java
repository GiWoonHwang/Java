package com.mysite.sbb.question;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
public class QuestionController {
    private final QuestionService questionService;


//    @ResponseBody  어노테이션을 지우면 html 파일을 불러온다.
    @GetMapping("/question/list")
    public String list(Model model) {
        /*
        Question 리포지터의 findAll 메서드를 사용하여 질문 목록 데이터인 questionList를 생성하고 Model 객체에 "questionList" 라는 이름으로 값을 저장했다.
        Model 객체는 자바 클래스와 템플릿 간의 연결고리 역할을 한다. Model 객체에 값을 담아두면 템플릿에서 그 값을 사용할 수 있다.
         */
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList); // questionList 라는 이름으로 담아두었다. 템플릿에서 사용할 수 있다.
        return "question_list";
    }

    @GetMapping(value = "/question/detail/{id}")
    /*
    요청 URL http://localhost:8080/question/detail/2의 숫자 2처럼 변하는 id 값을 얻을 때에는 위와 같이 @PathVariable 애너테이션을 사용해야 한다.
    이 때 @GetMapping(value = "/question/detail/{id}") 에서 사용한 id와 @PathVariable("id")의 매개변수 이름이 동일해야 한다.
     */
    public String detail(Model model, @PathVariable("id") Integer id) {
        return "question_detail";
    }


}
