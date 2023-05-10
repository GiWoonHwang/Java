package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
public class QuestionController {
    private final QuestionRepository questionRepository;


//    @ResponseBody  어노테이션을 지우면 html 파일을 불러온다.
    @GetMapping("/question/list")
    public String list(Model model) {
        /*
        Question 리포지터의 findAll 메서드를 사용하여 질문 목록 데이터인 questionList를 생성하고 Model 객체에 "questionList" 라는 이름으로 값을 저장했다.
        Model 객체는 자바 클래스와 템플릿 간의 연결고리 역할을 한다. Model 객체에 값을 담아두면 템플릿에서 그 값을 사용할 수 있다.
         */
        List<Question> questionList = this.questionRepository.findAll();
        model.addAttribute("questionList", questionList); // questionList 라는 이름으로 담아두었다. 템플릿에서 사용할 수 있다.
        return "question_list";
    }
}
