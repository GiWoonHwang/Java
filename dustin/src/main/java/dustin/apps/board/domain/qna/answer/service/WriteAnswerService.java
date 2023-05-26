package dustin.apps.board.domain.qna.answer.service;

import dustin.apps.board.domain.qna.answer.respository.AnswerRepository;
import dustin.apps.board.domain.qna.model.Answer;
import dustin.apps.board.domain.qna.model.Question;
import dustin.apps.board.domain.qna.model.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class WriteAnswerService {
    private final AnswerRepository answerRepository;

    public Answer create(Question question, String content, SiteUser author){
        /*
        앵커 : 원하는 위치로 이동
        앵커 기능을 이용하기 위해 return 값을 생성한 답변객체로 설정한다
         */
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

    public void vote(Answer answer, SiteUser siteUser){
        answer.getVoter().add(siteUser);
        this.answerRepository.save(answer);
    }
}
