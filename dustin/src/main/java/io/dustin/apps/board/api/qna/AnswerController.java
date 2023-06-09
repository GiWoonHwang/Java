package io.dustin.apps.board.api.qna;

import io.dustin.apps.board.api.usecase.qna.answer.DeleteAnswerUseCase;
import io.dustin.apps.board.api.usecase.qna.answer.ModifyAnswerUseCase;
import io.dustin.apps.board.api.usecase.qna.answer.WriteAnswerUseCase;
import io.dustin.apps.common.validation.AnswerForm;
import io.dustin.apps.board.domain.qna.answer.model.dto.AnswerDto;
import io.dustin.apps.common.exception.BadRequestParameterException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/v1/answer")
@RequiredArgsConstructor
public class AnswerController {

    private final WriteAnswerUseCase writeAnswerUseCase;
    private final ModifyAnswerUseCase modifyAnswerUseCase;
    private final DeleteAnswerUseCase deleteAnswerUseCase;

    //@PreAuthorize("isAuthenticated()")
    @PostMapping("/questions/{questionId}")
    public AnswerDto createAnswer(@Valid AnswerForm answerForm, BindingResult bindingResult,
                                  @PathVariable("questionId") Long questionId,
                                  Principal principal) {
        if(bindingResult.hasErrors()) {
            throw new BadRequestParameterException("내용은 필수항목입니다.");
        }
        return writeAnswerUseCase.execute(principal, questionId, answerForm.getContent());
    }

    //@PreAuthorize("isAuthenticated()")
    @PatchMapping("/{id}")
    public AnswerDto modifyAnswer(@Valid AnswerForm answerForm, BindingResult bindingResult,
                               @PathVariable("id") Long id,
                               Principal principal) {
        if(bindingResult.hasErrors()) {
            throw new BadRequestParameterException("내용은 필수항목입니다.");
        }
        return modifyAnswerUseCase.execute(principal, id, answerForm.getContent());
    }

    //@PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{id}")
    public AnswerDto deleteAnswer(@PathVariable("id") Long id,
                                  Principal principal) {
        return deleteAnswerUseCase.execute(principal, id);
    }

    //@PreAuthorize("isAuthenticated()")
    @GetMapping("/vote/{id}")
    public ResponseEntity<String> answerVote(Principal principal, @PathVariable("id") Long id) {
        writeAnswerUseCase.vote(principal, id);
        return ResponseEntity.ok().body("success");
    }

}
