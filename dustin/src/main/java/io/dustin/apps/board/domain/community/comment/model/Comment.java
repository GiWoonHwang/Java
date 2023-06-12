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

import java.util.List;
import java.util.Set;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {

    @Builder
    public Comment(Long id, @NotNull String content, YesOrNo isDeleted, @NotNull SiteUser author, @NotNull Posting posting, Comment comment, Long likeCount, List<Comment> replyList, Long clickCount) {
        this.id = id;
        this.content = content;
        this.posting = posting;
        this.comment = comment;
        this.author = author;
        this.isDeleted = isDeleted == null ? YesOrNo.N : isDeleted;
        this.likeCount = likeCount;
        this.replyList = replyList;
        this.clickCount = clickCount;

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

    @Column(name = "like")
    private Long likeCount;

    @ManyToOne
    private Posting posting;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_ID")
    private Comment comment;

    @Column(name = "click")
    private Long clickCount;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "comment", cascade = CascadeType.ALL)
    private List<Comment> replyList;

    public void updateContent(String content) {
        this.content = content;
    }

    public void delete() {
        this.isDeleted = YesOrNo.Y;
    }


}