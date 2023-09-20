package io.dustin.domain.user.service;

import io.dustin.domain.user.model.entity.User;
import io.dustin.domain.user.repository.CacheRepository;
import io.dustin.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WriteUserService {

    private final UserRepository repository;
    private final CacheRepository cached;

    public void signUp(User user) {
        repository.save(user);
    }

    public void cachedUser(String token, User user, Long expiredAt) {
        cached.cachedUser(token, user, expiredAt);
    }

}
