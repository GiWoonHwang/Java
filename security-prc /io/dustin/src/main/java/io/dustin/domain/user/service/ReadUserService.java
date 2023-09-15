package io.dustin.domain.user.service;

import io.dustin.domain.user.model.entity.User;
import io.dustin.domain.user.repository.CacheRepository;
import io.dustin.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReadUserService {

    private final UserRepository repository;
    private final CacheRepository cached;

    public User getUser(String id) {
        return repository.findById(id);
    }

    public User getCachedUser(String token) {
        return cached.getCachedUser(token);
    }

}
