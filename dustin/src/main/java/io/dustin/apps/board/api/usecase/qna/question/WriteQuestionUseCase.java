package io.dustin.apps.board.api.usecase.qna.question;

import io.dustin.apps.board.domain.qna.question.model.Question;
import io.dustin.apps.user.domain.model.SiteUser;
import io.dustin.apps.board.domain.qna.question.model.dto.QuestionDto;
import io.dustin.apps.board.domain.qna.question.service.ReadQuestionService;
import io.dustin.apps.board.domain.qna.question.service.WriteQuestionService;
import io.dustin.apps.user.domain.service.ReadUserService;
import io.dustin.apps.common.exception.DuplicatedVoteException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class WriteQuestionUseCase {

    private final WriteQuestionService writeQuestionService;
    private final ReadQuestionService readQuestionService;
    private final ReadUserService readUserService;

    public QuestionDto execute(Principal principal, String subject, String content) {
        SiteUser siteUser = readUserService.getUser(principal.getName());
        Question question = writeQuestionService.create(subject, content, siteUser);
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
