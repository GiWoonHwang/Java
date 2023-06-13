package io.dustin.apps.board.api.usecase.qna.question;

import io.dustin.apps.board.domain.qna.question.model.Question;
import io.dustin.apps.user.domain.model.SiteUser;
import io.dustin.apps.board.domain.qna.question.model.dto.QuestionDto;
import io.dustin.apps.board.domain.qna.question.service.ReadQuestionService;
import io.dustin.apps.board.domain.qna.question.service.WriteQuestionService;
import io.dustin.apps.user.domain.service.ReadUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class WriteQuestionUseCase {

    private final WriteQuestionService writeQuestionService;
    private final ReadQuestionService readQuestionService;
    private final ReadUserService readUserService;

    public QuestionDto execute(Long userId, String subject, String content) {
        SiteUser siteUser = readUserService.getUser(userId);
        Question question = writeQuestionService.create(subject, content, siteUser);
        QuestionDto dto = QuestionDto.from(question);
        return QuestionDto.from(question);

    }

}
