package io.dustin.apps.board.api.community;

import io.dustin.apps.board.api.usecase.community.comment.DeleteCommentUseCase;
import io.dustin.apps.board.api.usecase.community.comment.ModifyCommentUseCase;
import io.dustin.apps.board.api.usecase.community.comment.WriteCommentUseCase;
import io.dustin.apps.board.domain.community.comment.model.dto.CommentDto;
import io.dustin.apps.common.exception.BadRequestParameterException;
import io.dustin.apps.common.validation.CommentForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentController {

    private final WriteCommentUseCase writeCommentUseCase;
    private final ModifyCommentUseCase modifyCommentUseCase;
    private final DeleteCommentUseCase deleteCommentUseCase;

    //@PreAuthorize("isAuthenticated()")
    @PostMapping("/posting/{postingId}")
    public CommentDto createComment(@PathVariable("postingId") Long postingId,
                                    @RequestBody CommentDto commentDto) {
        if(commentDto.content() == null) {
            throw new BadRequestParameterException("댓글 내용은 필수항목입니다.");
        }
        /**
         * 해당 게시물에 댓글 수 증가로직 추가
         */
        return writeCommentUseCase.execute(commentDto.userId(), postingId, commentDto.replyId(), commentDto.content());
    }

    //@PreAuthorize("isAuthenticated()")
    @PatchMapping("/{id}")
    public CommentDto modifyComment(@PathVariable("id") Long id,
                                    @RequestBody CommentDto commentDto) {

        if(commentDto.content() == null) {
            throw new BadRequestParameterException("댓글 내용은 필수항목입니다.");
        }

        return modifyCommentUseCase.execute(commentDto.userId(), id, commentDto.content());
    }

    //@PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{id}")
    public CommentDto deleteComment(@PathVariable("id") Long id,
                                   @RequestBody CommentDto commentDto) {
        /**
         * 해당 게시물에 댓글 수 감소로직 추가
         */

        return deleteCommentUseCase.execute(commentDto.userId(), commentDto.postingId() ,id);
    }
}
