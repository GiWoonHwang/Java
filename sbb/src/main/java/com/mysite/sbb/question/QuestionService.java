package com.mysite.sbb.question;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.time.LocalDateTime;
import com.mysite.sbb.DataNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Sort;
import com.mysite.sbb.user.SiteUser;
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

    public void create(String subject, String content, SiteUser user){
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        q.setAuthor(user);
        this.questionRepository.save(q);
    }

    public Page<Question> getList(int page){
        /*
        정수 타입의 페이지 번호를 입력받아 해당 페이지의 질문목록을 리턴한다
        PageRequest.of(page, 10) = 몇번 페이지에 대한 데이터를 10개씩 보여준다

        게시물을 역순으로 조회하기 위해서는 위와 같이 PageRequest.of 메서드의 세번째 파라미터로 Sort 객체를 전달해야 한다.
        Sort.Order 객체로 구성된 리스트에 Sort.Order 객체를 추가하고 Sort.by(소트리스트)로 소트 객체를 생성할 수 있다.
        작성일시(createDate)를 역순(Desc)으로 조회하려면 Sort.Order.desc("createDate") 같이 작성한다.
         */
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.questionRepository.findAll(pageable);
    }

}
