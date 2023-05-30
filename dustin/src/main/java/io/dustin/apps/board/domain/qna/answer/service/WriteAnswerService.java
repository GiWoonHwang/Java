package io.dustin.apps.board.domain.qna.answer.service;

import io.dustin.apps.board.domain.qna.answer.respository.AnswerRepository;
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

    public Answer create(Question question, String content, SiteUser author){

        Answer answer = Answer.builder()
                .content(content)
                .question(question)
                .author(author)
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

    public void vote(Answer answer, SiteUser siteUser) {
        answer.getVoter().add(siteUser);
        this.answerRepository.save(answer);
    }
}
