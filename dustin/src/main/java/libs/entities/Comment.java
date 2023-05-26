package libs.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comment {
    /*
    만약 질문에 댓글이 작성될 경우에는 question에 값이 저장되고 답변에 댓글이 작성될 경우에는 answer에 값이 저장될 것이다.
    한 사람이 여러개의 댓글을 달수 있고 질문 또는 답변 한개에 여러개의 댓글을 달수 있기 때문에 author, question, answer 속성에는 @ManyToOne 애너테이션을 설정해야 한다.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private SiteUser author;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    @ManyToOne
    private Question question;

    @ManyToOne
    private Answer answer;

    public Integer getQuestionId() {
        /*
        getQuestionId 메서드는 댓글을 통해 질문의 id 값을 리턴하는 메서드로 question 속성이 null이 아닌 경우는 질문에 달린 댓글이므로 this.question.getId() 값을 리턴하고
        답변에 달린 댓글인 경우 this.answer.getQuestion().getId() 값을 리턴한다.
         */
        Integer result = null;
        if(this.question != null) {
            result = this.question.getId();
        }
        if(this.answer != null) {
            result = this.answer.getId();
        }
        return result;
    }
}