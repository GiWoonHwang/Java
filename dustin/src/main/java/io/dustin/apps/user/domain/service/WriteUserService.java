package io.dustin.apps.user.domain.service;

import io.dustin.apps.user.domain.model.SiteUser;
import io.dustin.apps.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WriteUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String nickName, String email, String password) {
        SiteUser user = SiteUser.builder()
                .nickName(nickName)
                .email(email)
                .password(passwordEncoder.encode(password))
                .build();
        return userRepository.save(user);
    }
}
