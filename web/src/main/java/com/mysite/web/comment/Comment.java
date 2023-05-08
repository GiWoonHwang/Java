package com.mysite.web.comment;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import com.mysite.web.answer.Answer;
import com.mysite.web.question.Question;
import com.mysite.web.user.SiteUser;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // 댓글 고유 번호

    @ManyToOne
    private SiteUser author; // 댓글 작성자

    @Column(columnDefinition = "TEXT")
    private String content; // 댓글 내용

    private LocalDateTime createDate;

    private LocalDateTime modifyDate; // 댓글 수정일시

    @ManyToOne // 한 사람이 여러개의 댓글을 달수 있고 질문 또는 답변 한개에 여러개의 댓글을 달수 있기 때문에
    private Question question; // 댓글이 달린 질문

    @ManyToOne
    private Answer answer; // 댓글이 달린 답변

    /*
    * getQuestionId 메서드는 댓글을 통해 질문의 id 값을 리턴하는 메서드로 question 속성이 null이 아닌 경우는 질문에 달린 댓글이므로 this.question.getId() 값을 리턴하고
    *  답변에 달린 댓글인 경우 this.answer.getQuestion().getId() 값을 리턴한다.
     * */
    public Integer getQuestionId(){
        Integer result = null;
        if(this.question != null){
            result = this.question.getId();
        }
        else if(this.answer != null){
            result = this.answer.getQuestion().getId();
        }
        return result;
    }
































}
