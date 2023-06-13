package io.dustin.apps.board.domain.qna.answer.service;

import io.dustin.apps.board.domain.qna.answer.repository.AnswerRepository;
import io.dustin.apps.board.domain.qna.answer.model.Answer;
import io.dustin.apps.board.domain.qna.question.model.Question;
import io.dustin.apps.user.domain.model.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class WriteAnswerService {
    private final AnswerRepository answerRepository;

    public Answer create(Long question, String content, Long admin){

        Answer answer = Answer.builder()
                .content(content)
                .question(question)
                .admin(admin)
                .build();
        this.answerRepository.save(answer);
        return answer;
    }

    @Transactional
    public void updateContent(Answer answer, String content){
        answer.updateContent(content);
    }

    @Transactional
    public void delete(Answer answer){
        answer.delete();
    }

}
