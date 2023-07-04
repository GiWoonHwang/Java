package io.dustin.apps.board.api.qna;

import io.dustin.apps.board.api.usecase.qna.answer.DeleteAnswerUseCase;
import io.dustin.apps.board.api.usecase.qna.answer.ModifyAnswerUseCase;
import io.dustin.apps.board.api.usecase.qna.answer.WriteAnswerUseCase;
import io.dustin.board.domain.qna.answer.model.dto.AnswerDto;
import io.dustin.common.exception.BadRequestParameterException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/answer")
@RequiredArgsConstructor
public class AnswerController {

    private final WriteAnswerUseCase writeAnswerUseCase;
    private final ModifyAnswerUseCase modifyAnswerUseCase;
    private final DeleteAnswerUseCase deleteAnswerUseCase;

    //@PreAuthorize("isAuthenticated()")
    @PostMapping("/questions/{questionId}")
    public AnswerDto createAnswer(@PathVariable("questionId") Long questionId,
                                  @RequestBody @Valid AnswerDto answerDto) {
        if(answerDto.content() == null) {
            throw new BadRequestParameterException("댓글 내용은 필수항목입니다.");
        }
        return writeAnswerUseCase.execute(answerDto.adminId(), questionId, answerDto.content());
    }

    //@PreAuthorize("isAuthenticated()")
    @PatchMapping("/{answerId}")
    public AnswerDto modifyAnswer(@PathVariable("answerId") Long answerId,
                                  @RequestBody @Valid AnswerDto answerDto) {
        if(answerDto.content() == null) {
            throw new BadRequestParameterException("댓글 내용은 필수항목입니다.");
        }
        return modifyAnswerUseCase.execute(answerDto.adminId(), answerId, answerDto.content());
    }

    //@PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{answerId}")
    public AnswerDto deleteAnswer(@PathVariable("answerId") Long answerId,
                                  @RequestBody AnswerDto answerDto) {
        return deleteAnswerUseCase.execute(answerDto.adminId(), answerId);
    }



}
