package com.mysite.web.answer;

import java.time.LocalDateTime;

import com.mysite.web.question.Question;
import com.mysite.web.user.SiteUser;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

import com.mysite.web.comment.Comment;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @ManyToOne // 답변은 많은 것, 질문은 하나
    private Question question; // 질문 엔티티를 참조하기 위해 추가했다.

    @ManyToOne
    private SiteUser author;

    private LocalDateTime modifyDate;

    @ManyToMany
    Set<SiteUser> voter;

    @OneToMany(mappedBy = "answer")
    private List<Comment> commentList;


























}
