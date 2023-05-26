package dustin.apps.board.domain.qna.question.service;

import dustin.apps.board.domain.qna.model.Question;
import dustin.apps.board.domain.qna.model.SiteUser;
import dustin.apps.board.domain.qna.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WriteQuestionService {

    private final QuestionRepository questionRepository;

    public Question create(String subject, String content, SiteUser user) {
        Question q = Question.builder()
                .subject(subject)
                .content(content)
                .author(user)
                .build();
        return questionRepository.save(q);
    }


    public void updateContent(Question question, String subject, String content) {
        question.updateSubject(subject);
        question.updateContent(content);
        questionRepository.save(question);
    }

    @Transactional
    public void delete(Question question){
        question.delete();
    }

    public void vote(Question question, SiteUser siteUser){
        question.getVoter().add(siteUser);
        questionRepository.save(question);
    }
}
