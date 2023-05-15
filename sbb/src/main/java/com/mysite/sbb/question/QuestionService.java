package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.time.LocalDateTime;
import com.mysite.sbb.DataNotFoundException;
@RequiredArgsConstructor
@Service
public class QuestionService {
    // 생성자 방식으로 의존성 주입 됨
    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id){
        /*
         리포지터리로 얻은 Question 객체는 Optional 객체이기 때문에 위와 같이 isPresent 메서드로 해당 데이터가 존재하는지 검사하는 로직이 필요하다.
         */
        Optional<Question> question = this.questionRepository.findById(id);
        if(question.isPresent()){ // null이 아니라면
            return question.get(); // id에 해당하는 데이터를 가져온다.
        }
        else{
            throw new DataNotFoundException("question not found");
        }
    }

    public void create(String subject, String content){
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q);
    }

}
