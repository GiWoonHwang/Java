package io.dustin.apps.board.domain.qna.user.repository;

import java.util.Optional;

import io.dustin.apps.board.domain.qna.model.SiteUser;
import io.dustin.apps.common.repository.BaseRepository;

public interface UserRepository extends BaseRepository<SiteUser, Long> {
    Optional<SiteUser> findByUserName(String username);
}
