package io.dustin.apps.board.api.qna;

import io.dustin.apps.board.api.usecase.qna.question.DeleteQuestionUseCase;
import io.dustin.apps.board.api.usecase.qna.question.ModifyQuestionUseCase;
import io.dustin.apps.board.api.usecase.qna.question.WriteQuestionUseCase;
import io.dustin.apps.board.domain.community.posting.model.dto.PostingDto;
import io.dustin.apps.board.domain.qna.question.model.dto.QuestionDto;
import io.dustin.apps.board.domain.qna.question.service.ReadQuestionService;
import io.dustin.apps.common.exception.BadRequestParameterException;
import io.dustin.apps.common.validation.QuestionForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/question")
@RequiredArgsConstructor
public class QuestionController {

    private final ReadQuestionService readQuestionService;
    private final WriteQuestionUseCase writeQuestionUseCase;
    private final ModifyQuestionUseCase modifyQuestionUseCase;
    private final DeleteQuestionUseCase deleteQuestionUseCase;

    //@PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    public QuestionDto createQuestion(@RequestBody QuestionDto questionDto) {
        return  writeQuestionUseCase.execute(questionDto.userId(), questionDto.subject(), questionDto.content());
    }

    //@PreAuthorize("isAuthenticated()")
    @PatchMapping("/{questionId}")
    public QuestionDto modifyQuestion(@PathVariable("questionId") Long questionId,
                                      @RequestBody QuestionDto questionDto
                                  ) {
        return modifyQuestionUseCase.execute(questionId, questionDto.userId(), questionDto.subject(), questionDto.content());
    }

    //@PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{questionId}")
    public QuestionDto deleteQuestion(@PathVariable("questionId") Long questionId,
                                      @RequestBody QuestionDto questionDto) {
        return deleteQuestionUseCase.execute(questionId, questionDto.userId());
    }




}
