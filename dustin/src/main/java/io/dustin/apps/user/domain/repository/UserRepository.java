package io.dustin.apps.user.domain.repository;

import io.dustin.apps.common.repository.BaseRepository;
import io.dustin.apps.user.domain.model.SiteUser;
import io.dustin.apps.user.domain.repository.custom.CustomUserRepository;

import java.util.Optional;

public interface UserRepository extends BaseRepository<SiteUser, Long>, CustomUserRepository {
    Optional<SiteUser> findByNickName(String username);

    Optional<SiteUser> findById(Long userId);

}
