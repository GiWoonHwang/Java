package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class MainController {
    /*
    @Controller인 경우에 바디를 자바객체로 받기 위해서는 @ResponseBody 어노테이션을 반드시 명시해주어야한다.
     @ResponseBody 애너테이션을 생략한다면 "index"라는 이름의 템플릿 파일을 찾게 된다.
     */
    @GetMapping("/sbb")
    @ResponseBody
    public String index() {
        return "안녕하세요 환영합니다.";
    }
}
