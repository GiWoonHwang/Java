package libs.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // JPA로 인식한다.
public class Question {
    /*
    Getter: private 변수 값을 가져온다.
    Setter: private 변수 값을 변경한다.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*
    @GeneratedValue 애너테이션을 적용하면 데이터를 저장할 때 해당 속성에 값을 따로 세팅하지 않아도 1씩 자동으로 증가하여 저장된다.
    strategy는 고유번호를 생성하는 옵션으로 GenerationType.IDENTITY는 해당 컬럼만의 독립적인 시퀀스를 생성하여 번호를 증가시킬 때 사용한다.

     strategy 옵션을 생략할 경우에 @GeneratedValue 애너테이션이 지정된 컬럼들이 모두 동일한 시퀀스로 번호를 생성하기 때문에 일정한 순서의 고유번호를 가질수 없게 된다.
     이러한 이유로 보통 GenerationType.IDENTITY를 많이 사용한다.
     */
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT") // 글자수를 제한할 수 없는 경우
    private String content;

    private LocalDateTime createDate;

    /*
    답변과 질문이 N:1의 관계라면 질문과 답변은 1:N의 관계라고 할 수 있다. 이런경우에는 @ManyToOne이 아닌 @OneToMany애너테이션을 사용한다.
    Question 하나에 Answer는 여러개이므로 Question 엔티티에 추가할 답변의 속성은 List 형태로 구성해야 한다.
     */
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    // Answer 엔티티에서 Question 엔티티를 참조한 속성명 question을 mappedBy에 전달해야 한다.
    private List<Answer> answerList;

    @ManyToOne
    private SiteUser author;

    private LocalDateTime modifyDate;

    @ManyToMany
    Set<SiteUser> voter; // 하나의 질문에 여러사람이, 한 사람이 여러질문을, 또 추천은 중복이 불가능하다.

    @OneToMany(mappedBy = "question")
    private List<Comment> commentList;


}
