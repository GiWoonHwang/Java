package dustin.apps.board.domain.qna.user.repository;

import java.util.Optional;

import dustin.apps.board.domain.qna.model.SiteUser;
import dustin.libs.common.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends BaseRepository<SiteUser, Long> {
    Optional<SiteUser> findByUserName(String username);
}
