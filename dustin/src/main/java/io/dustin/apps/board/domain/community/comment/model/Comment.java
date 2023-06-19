package io.dustin.apps.board.domain.community.comment.model;

import io.dustin.apps.board.domain.community.posting.model.Posting;
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
import org.hibernate.annotations.ColumnDefault;

import java.util.List;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {

    @Builder
    public Comment(Long id, @NotNull String content, YesOrNo isDeleted,@NotNull Long userId, @NotNull Long posting,
                   Long likeCount, Long reply, Long clickCount) {
        this.id = id;
        this.content = content;
        this.posting = posting;
        this.userId = userId;
        this.isDeleted = isDeleted == null ? YesOrNo.N : isDeleted;
        this.likeCount = likeCount;
        this.reply = reply == null ? null : reply;
        this.clickCount = clickCount;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "is_deleted")
    private YesOrNo isDeleted;


    /** 작성자 */
    private Long userId;

    @Column(columnDefinition = "bigint default 0")
    private Long likeCount;

    @Column(columnDefinition = "bigint default 0")
    private Long clickCount;

    private Long posting;

    private Long reply;

    public void updateContent(String content) {
        this.content = content;
    }

    public void delete() {
        this.isDeleted = YesOrNo.Y;
    }

    public void countUp(Long likeCount ) {this.likeCount = likeCount;}

    public void countDown(Long likeCount ) {this.likeCount = likeCount;}


}