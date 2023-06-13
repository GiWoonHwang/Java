package io.dustin.apps.user.domain.repository;

import java.util.List;
import java.util.Optional;

import io.dustin.apps.user.domain.model.SiteUser;
import io.dustin.apps.common.repository.BaseRepository;
import io.dustin.apps.user.domain.repository.custom.CustomUserRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends BaseRepository<SiteUser, Long>, CustomUserRepository {
    Optional<SiteUser> findByNickName(String username);

    Optional<SiteUser> findById(Long userId);

}
