package com.mysite.web.question;

import java.time.LocalDateTime;
import java.util.List;

import com.mysite.web.answer.Answer;
import com.mysite.web.user.SiteUser;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity // 엔티티라고 명시해 주는 것
public class Question {
    @Id // 기본키 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 수 증가
    private Integer id;

    @Column(length = 200)
    private  String subject;

    @Column(columnDefinition = "TEXT") // 글자 수를 제한하지 않는다.
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) // 질문을 삭제하면 그에 따른 답변도 전부 삭제된다.
    private List<Answer> answerList;

    @ManyToOne
    private SiteUser author;

    private LocalDateTime modifyDate;

}
