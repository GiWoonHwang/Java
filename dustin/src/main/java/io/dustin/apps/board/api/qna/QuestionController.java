package io.dustin.apps.board.api.qna;

import io.dustin.apps.board.api.usecase.qna.question.DeleteQuestionUseCase;
import io.dustin.apps.board.api.usecase.qna.question.ModifyQuestionUseCase;
import io.dustin.apps.board.api.usecase.qna.question.WriteQuestionUseCase;
import io.dustin.apps.board.domain.qna.question.model.dto.QuestionDto;
import io.dustin.apps.common.exception.BadRequestParameterException;
import io.dustin.apps.common.validation.QuestionForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/v1/question")
@RequiredArgsConstructor
public class QuestionController {

    private WriteQuestionUseCase writeQuestionService;
    private ModifyQuestionUseCase modifyQuestionUseCase;
    private DeleteQuestionUseCase deleteQuestionUseCase;

    //@PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    public QuestionDto createQuestion(@Valid QuestionForm questionForm, BindingResult bindingResult, @RequestBody Long userID) {
        if(bindingResult.hasErrors()) {
            throw new BadRequestParameterException("내용은 필수항목입니다.");
        }
        return  writeQuestionService.execute(userID, questionForm.getSubject(), questionForm.getContent());
    }

    //@PreAuthorize("isAuthenticated()")
    @PatchMapping("/{id}")
    public QuestionDto modifyQuestion(@Valid QuestionForm questionForm, BindingResult bindingResult,
                                  @PathVariable("id") Long id,
                                  @RequestBody Long userID) {
        if(bindingResult.hasErrors()) {
            throw new BadRequestParameterException("내용은 필수항목입니다.");
        }
        return modifyQuestionUseCase.execute(userID, id, questionForm.getSubject(), questionForm.getContent());
    }

    //@PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{id}")
    public QuestionDto deleteQuestion(@PathVariable("id") Long id,
                                      @RequestBody Long userID) {
        return deleteQuestionUseCase.execute(userID, id);
    }




}
