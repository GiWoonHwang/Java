package libs.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
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

    /*
    question 속성은 답변 엔티티에서 질문 엔티티를 참조하기 위해 추가했다.
    예를 들어 답변 객체(예:answer)를 통해 질문 객체의 제목을 알고 싶다면 answer.getQuestion().getSubject()처럼 접근할 수 있다. 하지만 이렇게 속성만 추가하면 안되고 질문 엔티티와 연결된 속성이라는 것을 명시적으로 표시해야 한다.
    즉, question 속성에 @ManyToOne 애너테이션을 추가해야 한다.
     */
    @ManyToOne // 답변은 하나의 질문에 여러개가 달릴 수 있는 구조이다.
    private Question question;

    @ManyToOne // 여러개의 질문을 한명의 사용자가 작성할 수 있다
    private SiteUser author;

    private LocalDateTime modifyDate;

    @ManyToMany
    Set<SiteUser> voter;

    @OneToMany(mappedBy = "answer")
    private List<Comment> commentList;

}
