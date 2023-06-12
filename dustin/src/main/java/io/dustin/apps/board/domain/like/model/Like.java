package io.dustin.apps.board.domain.like.model;

import io.dustin.apps.common.code.BoardType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@Getter
@Entity
@DynamicUpdate
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Like {

    @Builder
    public Like(Long id, @NotNull Long boardId, @NotNull Long userId, @NotNull BoardType boardType){
        this.id =id;
        this.boardId = boardId;
        this.userId = userId;
        this.boardType = boardType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "board_id")
    private Long boardId;

    @Column(name = "user_id")
    private Long userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private BoardType boardType;
}
