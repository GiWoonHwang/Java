package dustin.apps.board.domain.qna.comment;

import dustin.apps.board.domain.qna.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
