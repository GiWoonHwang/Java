package dustin.apps.board.domain.qna.question.service;

import dustin.apps.board.domain.qna.model.Answer;
import dustin.apps.board.domain.qna.model.Question;
import dustin.apps.board.domain.qna.model.SiteUser;
import dustin.apps.board.domain.qna.question.repository.QuestionRepository;
import dustin.libs.common.exception.DataNotFoundException;
import jakarta.persistence.criteria.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static dustin.libs.common.utils.OptionalUtils.getEntity;

@Service
@RequiredArgsConstructor
public class ReadQuestionService {
    // 생성자 방식으로 의존성 주입 됨
    private final QuestionRepository questionRepository;

    @Transactional(readOnly = true)
    public List<Question> getList() {
        return this.questionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Question getQuestion(Long id) {
        return getEntity(questionRepository.findById(id), Question.class, "question not found");
    }

    @Transactional(readOnly = true)
    public Page<Question> getList(int page, String kw) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        Specification<Question> spec = search(kw); // 검색어를 의미하는 매개변수 kw를 getList에 추가하고 kw 값으로 Specification 객체를 생성하여 findAll 메서드 호출시 전달하였다.
        return questionRepository.findAll(spec, pageable);
    }

    private Specification<Question> search(String kw) {
        return new Specification<>() {
            private static final long serialVersionUID = 1L; // 직렬화 및 역직렬화시 그 값을 체크해주는 용도
            @Override
            public Predicate toPredicate(Root<Question> q, CriteriaQuery<?> query, CriteriaBuilder cb) {
                /*
                q - Root, 즉 기준을 의미하는 Question 엔티티의 객체 (질문 제목과 내용을 검색하기 위해 필요)
                u1 - Question 엔티티와 SiteUser 엔티티를 아우터 조인(JoinType.LEFT)하여 만든 SiteUser 엔티티의 객체. Question 엔티티와 SiteUser 엔티티는 author 속성으로 연결되어 있기 때문에 q.join("author")와 같이 조인해야 한다. (질문 작성자를 검색하기 위해 필요)
                a - Question 엔티티와 Answer 엔티티를 아우터 조인하여 만든 Answer 엔티티의 객체. Question 엔티티와 Answer 엔티티는 answerList 속성으로 연결되어 있기 때문에 q.join("answerList")와 같이 조인해야 한다. (답변 내용을 검색하기 위해 필요)
                u2 - 바로 위에서 작성한 a 객체와 다시 한번 SiteUser 엔티티와 아우터 조인하여 만든 SiteUser 엔티티의 객체 (답변 작성자를 검색하기 위해서 필요)
                */
                query.distinct(true);
                Join<Question, SiteUser> u1 = q.join("author", JoinType.LEFT);
                Join<Question, Answer> a = q.join("answerList", JoinType.LEFT);
                Join<Answer, SiteUser> u2 = a.join("author", JoinType.LEFT);
                return cb.or(cb.like(q.get("subject"), "%" + kw + "%"), // 제목
                        cb.like(q.get("content"), "%" + kw + "%"),      // 내용
                        cb.like(u1.get("username"), "%" + kw + "%"),    // 질문 작성자
                        cb.like(a.get("content"), "%" + kw + "%"),      // 답변 내용
                        cb.like(u2.get("username"), "%" + kw + "%"));   // 답변 작성자

            }
        };
    }

}
