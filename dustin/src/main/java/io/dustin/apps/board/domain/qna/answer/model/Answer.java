package io.dustin.apps.board.domain.qna.answer.model;

import java.util.List;
import java.util.Set;

import io.dustin.apps.board.domain.qna.question.model.Question;
import io.dustin.apps.common.code.YesOrNo;
import io.dustin.apps.common.model.BaseEntity;
import io.dustin.apps.user.domain.model.SiteUser;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Answer extends BaseEntity {

    @Builder
    public Answer(Long id, @NotNull String content, YesOrNo isDeleted, @NotNull Long question, @NotNull Long admin) {
        // do something
        this.id = id;
        this.content = content;
        this.question = question;
        this.admin = admin;
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
    @Column
    private Long question;

    /** 작성자 */
    @Column
    private Long admin;


    public void updateContent(String content) {
        this.content = content;
    }

    public void delete() {
        this.isDeleted = YesOrNo.Y;
    }

}
