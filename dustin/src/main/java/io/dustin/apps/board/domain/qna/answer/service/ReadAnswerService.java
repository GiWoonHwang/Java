package io.dustin.apps.board.domain.qna.answer.service;

import io.dustin.apps.board.domain.qna.answer.repository.AnswerRepository;
import io.dustin.apps.board.domain.qna.answer.model.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static io.dustin.apps.common.utils.OptionalUtils.getEntity;

@Service
@RequiredArgsConstructor
public class ReadAnswerService {

    private final AnswerRepository answerRepository;

    @Transactional(readOnly = true)
    public Answer getAnswer(Long id) {
        return getEntity(this.answerRepository.findById(id), Answer.class, "answer not found");
    }

}
