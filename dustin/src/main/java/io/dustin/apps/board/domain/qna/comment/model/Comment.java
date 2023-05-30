package io.dustin.apps.board.domain.qna.comment.model;

import io.dustin.apps.board.domain.qna.answer.model.Answer;
import io.dustin.apps.board.domain.qna.question.model.Question;
import io.dustin.apps.common.code.YesOrNo;
import io.dustin.apps.common.model.BaseEntity;
import io.dustin.apps.user.domain.model.SiteUser;
import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {

    @Builder
    public Comment(Long id, @NotNull String content, YesOrNo isDeleted, @NotNull SiteUser author, Question question, Answer answer) {
        this.id = id;
        this.content = content;
        this.question = question;
        this.answer = answer;
        this.author = author;
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

    /** 작성자 */
    @ManyToOne
    private SiteUser author;

    @ManyToOne
    private Question question;

    @ManyToOne
    private Answer answer;

    public void updateContent(String content) {
        this.content = content;
    }

    public void delete() {
        this.isDeleted = YesOrNo.Y;
    }

    /** 추후에 삭제될 수도 있음 */
    public Long getQuestionId() {
        Long result = null;
        if(this.question != null) {
            result = this.question.getId();
        }
        if(this.answer != null) {
            result = this.answer.getId();
        }
        return result;
    }
}