package dustin.apps.board.api.usecase.question;

import dustin.apps.board.domain.qna.model.Question;
import dustin.apps.board.domain.qna.model.SiteUser;
import dustin.apps.board.domain.qna.model.dto.QuestionDto;
import dustin.apps.board.domain.qna.question.service.ReadQuestionService;
import dustin.apps.board.domain.qna.question.service.WriteQuestionService;
import dustin.apps.board.domain.qna.user.service.ReadUserService;
import dustin.libs.common.exception.DuplicatedVoteException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class WriteQuestionUseCase {

    private final WriteQuestionService writeQuestionService;
    private final ReadQuestionService readQuestionService;
    private final ReadUserService readUserService;

    public QuestionDto execute(Principal principal, String subject, String content, SiteUser siteuser) {
        SiteUser siteUser = readUserService.getUser(principal.getName());
        Question question = writeQuestionService.create(subject, content, siteuser);
        QuestionDto dto = QuestionDto.from(question); // 요거랑 리턴값이랑 같은데 두번 쓴 이유는 ?
        return QuestionDto.from(question);

    }

    public void vote(Principal principal, Long id) {
        Question question = readQuestionService.getQuestion(id);
        long checked = question.getVoter()
                .stream()
                .filter(siteUser -> siteUser.getNickName().equals(principal.getName()))
                .count();

        if(checked > 0) {
            throw new DuplicatedVoteException("이미 추천한 사람입니다.");
        }

        SiteUser siteUser = readUserService.getUser(principal.getName());
        writeQuestionService.vote(question, siteUser);
    }




}
