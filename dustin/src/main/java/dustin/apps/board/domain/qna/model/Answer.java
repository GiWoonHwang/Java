package dustin.apps.board.domain.qna.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import dustin.libs.common.code.YesOrNo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import static java.time.LocalDateTime.now;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Answer extends BaseEntity {

    @Builder
    public Answer(Long id, @NotNull String content, YesOrNo isDeleted, @NotNull Question question, @NotNull SiteUser author, Set<SiteUser> voter, List<Comment> commentList) {
        // do something
        this.id = id;
        this.content = content;
        this.question = question;
        this.author = author;
        this.voter = voter;
        this.commentList = commentList;
        this.isDeleted = isDeleted == null ? YesOrNo.N : isDeleted;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_deleted", length = 1)
    private YesOrNo isDeleted;

    /** 질문 엔티티 */
    @ManyToOne
    private Question question;

    /** 작성자 */
    @ManyToOne
    private SiteUser author;

    /** 추천 유저 */
    @ManyToMany
    private Set<SiteUser> voter;

    @OneToMany(mappedBy = "answer")
    private List<Comment> commentList;

    public void updateContent(String content) {
        this.content = content;
    }

    public void delete() {
        this.isDeleted = YesOrNo.Y;
    }

}
