package io.dustin.apps.board.domain.click.model.dto;
import io.dustin.apps.common.code.BoardType;
import lombok.Getter;

@Getter
public class ClickItCommand {
    private Long boardId;
    private Long userId;
    private BoardType boardType;
}
