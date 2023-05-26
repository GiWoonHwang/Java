package dustin.apps.board.domain.qna.model;

import dustin.libs.common.code.YesOrNo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;
import java.util.Set;

@Getter
@Entity
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Question extends BaseEntity {

    @Builder
    public Question(Long id, @NotNull String subject, @NotNull String content, YesOrNo isDeleted, List<Answer> answerList, @NotNull SiteUser author, Set<SiteUser> voter, List<Comment> commentList) {
        this.id = id;
        this.subject = subject;
        this.content = content;
        this.answerList = answerList;
        this.author = author;
        this.isDeleted = isDeleted == null ? YesOrNo.N : isDeleted;
        this.voter = voter;
        this.commentList = commentList;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_deleted", length = 1)
    private YesOrNo isDeleted;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    @ManyToOne
    private SiteUser author;

    @ManyToMany
    private Set<SiteUser> voter; // 하나의 질문에 여러사람이, 한 사람이 여러질문을, 또 추천은 중복이 불가능하다.

    @OneToMany(mappedBy = "question")
    private List<Comment> commentList;

    public void updateSubject(String subject) {
        this.subject = subject;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public void delete() {
        this.isDeleted = YesOrNo.Y;
    }


}
