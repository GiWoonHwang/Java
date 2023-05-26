package dustin.apps.board.domain.qna.answer.respository;

import dustin.apps.board.domain.qna.model.Answer;
import dustin.libs.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends BaseRepository<Answer, Long> {
}
