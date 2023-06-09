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
@RequestMapping("/v1/comment")
@RequiredArgsConstructor
public class CommentController {

    private final WriteCommentUseCase writeCommentUseCase;
    private final ModifyCommentUseCase modifyCommentUseCase;
    private final DeleteCommentUseCase deleteCommentUseCase;

    //@PreAuthorize("isAuthenticated()")
    @PostMapping("/questions/{questionId}")
    public CommentDto createComment(@Valid CommentForm commentForm, BindingResult bindingResult,
                                    @PathVariable("questionId") Long questionId,
                                    Principal principal) {
        if(bindingResult.hasErrors()) {
            throw new BadRequestParameterException("내용은 필수항목입니다.");
        }
        return writeCommentUseCase.execute(principal, questionId, commentForm.getContent());
    }

    //@PreAuthorize("isAuthenticated()")
    @PatchMapping("/{id}")
    public CommentDto modifyAnswer(@Valid CommentForm commentForm, BindingResult bindingResult,
                                  @PathVariable("id") Long id,
                                  Principal principal) {
        if(bindingResult.hasErrors()) {
            throw new BadRequestParameterException("내용은 필수항목입니다.");
        }
        return modifyCommentUseCase.execute(principal, id, commentForm.getContent());
    }

    //@PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{id}")
    public CommentDto deleteAnswer(@PathVariable("id") Long id,
                                  Principal principal) {
        return deleteCommentUseCase.execute(principal, id);
    }

}
