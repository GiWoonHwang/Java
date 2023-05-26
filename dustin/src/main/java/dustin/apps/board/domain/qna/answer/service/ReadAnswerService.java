package dustin.apps.board.domain.qna.answer.service;

import dustin.apps.board.domain.qna.answer.respository.AnswerRepository;
import dustin.apps.board.domain.qna.model.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static dustin.libs.common.utils.OptionalUtils.getEntity;

@Service
@RequiredArgsConstructor
public class ReadAnswerService {

    private final AnswerRepository answerRepository;

    @Transactional(readOnly = true)
    public Answer getAnswer(Long id) {
        return getEntity(this.answerRepository.findById(id), Answer.class, "answer not fount");
    }

}
