package 추후삭제.user.repository;

import java.util.Optional;

import io.dustin.apps.user.domain.model.SiteUser;
import io.dustin.apps.common.repository.BaseRepository;

public interface UserRepository extends BaseRepository<SiteUser, Long> {
    Optional<SiteUser> findBynickName(String username);
}
