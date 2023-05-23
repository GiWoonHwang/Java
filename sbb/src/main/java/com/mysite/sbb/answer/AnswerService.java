package com.mysite.sbb.answer;

import com.mysite.sbb.question.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mysite.sbb.user.SiteUser;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository; // repository는 final

    public void create(Question question, String cotent, SiteUser author){
        Answer answer = new Answer();
        answer.setContent(cotent);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        answer.setAuthor(author); // 컨트롤러에서 principal.getName() 으로 얻어온 유저정보 받아온다.
        this.answerRepository.save(answer);
    }
}
