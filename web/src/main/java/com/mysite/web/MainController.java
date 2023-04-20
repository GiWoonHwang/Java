package com.mysite.web;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller // 컨트롤러가 된다
public class MainController {
    @GetMapping("/sbb") // 맵핑을 담당한다.
    @ResponseBody // 요청에 대한 응답을 리턴한다. 생략한다면 index라는 이름의 템플릿 파일을 찾는다.
    public String index() {
        return "안녕하세요 sbb에 오신것을 환영합니다.";
    }
}
