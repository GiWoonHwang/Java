package apps.noticeboard.answer;

import libs.common.exception.DataNotFoundException;
import libs.entities.Question;
import libs.entities.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import libs.entities.SiteUser;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository; // repository는 final

    public Answer create(Question question, String cotent, SiteUser author){
        /*
        앵커 : 원하는 위치로 이동
        앵커 기능을 이용하기 위해 return 값을 생성한 답변객체로 설정한다
         */
        Answer answer = new Answer();
        answer.setContent(cotent);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        answer.setAuthor(author); // 컨트롤러에서 principal.getName() 으로 얻어온 유저정보 받아온다.
        this.answerRepository.save(answer);
        return answer;
    }

    public Answer getAnswer(Integer id) {
        Optional<Answer> answer = this.answerRepository.findById(id); // id에 해당하는 답변 객체를 가져온다
        if(answer.isPresent()){
            return answer.get();
        } else {
            throw new DataNotFoundException("answer not found");
        }
    }

    public void modify(Answer answer, String content){
        answer.setContent(content);
        answer.setModifyDate(LocalDateTime.now());
        this.answerRepository.save(answer);
    }

    public void delete(Answer answer){
        this.answerRepository.delete(answer);
    }

    public void vote(Answer answer, SiteUser siteUser){
        answer.getVoter().add(siteUser);
        this.answerRepository.save(answer);
    }
}
