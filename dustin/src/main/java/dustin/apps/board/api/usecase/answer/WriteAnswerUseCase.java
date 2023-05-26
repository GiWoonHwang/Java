package dustin.apps.board.api.usecase.answer;

import dustin.apps.board.domain.qna.answer.service.ReadAnswerService;
import dustin.apps.board.domain.qna.answer.service.WriteAnswerService;
import dustin.apps.board.domain.qna.model.Answer;
import dustin.apps.board.domain.qna.model.Question;
import dustin.apps.board.domain.qna.model.SiteUser;
import dustin.apps.board.domain.qna.model.dto.AnswerDto;
import dustin.apps.board.domain.qna.question.service.ReadQuestionService;
import dustin.apps.board.domain.qna.user.service.ReadUserService;
import dustin.libs.common.exception.DuplicatedVoteException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class WriteAnswerUseCase {

    private final ReadQuestionService readQuestionService;
    private final ReadUserService readUserService;
    private final ReadAnswerService readAnswerService;
    private final WriteAnswerService writeAnswerService;

    public AnswerDto execute(Principal principal, Long questionId, String content) {
        Question question = readQuestionService.getQuestion(questionId);
        SiteUser siteUser = readUserService.getUser(principal.getName());
        Answer answer = writeAnswerService.create(question, content, siteUser);
        AnswerDto dto = AnswerDto.from(answer);
        return AnswerDto.from(answer);
    }

    public void vote(Principal principal, Long id) {
        Answer answer = readAnswerService.getAnswer(id);
        long checked = answer.getVoter()
                             .stream()
                             .filter(siteUser -> siteUser.getNickName().equals(principal.getName()))
                             .count();
        if(checked > 0) {
            throw new DuplicatedVoteException("이미 추천한 사람입니다.");
        }

        SiteUser siteUser = readUserService.getUser(principal.getName());
        writeAnswerService.vote(answer, siteUser);
    }

}
