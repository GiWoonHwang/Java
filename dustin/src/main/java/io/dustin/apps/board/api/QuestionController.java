package io.dustin.apps.board.api;

import io.dustin.apps.board.api.usecase.question.DeleteQuestionUseCase;
import io.dustin.apps.board.api.usecase.question.ModifyQuestionUseCase;
import io.dustin.apps.board.api.usecase.question.WriteQuestionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/question")
@RequiredArgsConstructor
public class QuestionController {

    private WriteQuestionUseCase writeQuestionService;
    private DeleteQuestionUseCase readQuestionService;
    private ModifyQuestionUseCase modifyQuestionUseCase;

}
