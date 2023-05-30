package io.dustin.apps.board.api.usecase.answer;

import io.dustin.apps.board.domain.qna.answer.service.ReadAnswerService;
import io.dustin.apps.board.domain.qna.answer.service.WriteAnswerService;
import io.dustin.apps.board.domain.qna.model.Answer;
import io.dustin.apps.board.domain.qna.model.dto.AnswerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class DeleteAnswerUseCase {

    private final ReadAnswerService readAnswerService;
    private final WriteAnswerService writeAnswerService;

    public AnswerDto execute(Principal principal, Long id) {
        Answer answer = readAnswerService.getAnswer(id);
        if(!answer.getAuthor().getNickName().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제 권한이 없습니다.");
        }
        writeAnswerService.delete(answer);
        return AnswerDto.from(answer);
    }

}
