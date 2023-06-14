package io.dustin.apps.user.domain.service;

import io.dustin.apps.board.domain.community.posting.model.Posting;
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


    public void updatePassword(SiteUser siteUser, String password) {
        siteUser.updatePassword(password);
        userRepository.save(siteUser);
    }

    public void updateEmail(SiteUser siteUser, String email) {
        siteUser.updateEmail(email);
        userRepository.save(siteUser);
    }

    public void updateNickName(SiteUser siteUser, String nickName) {
        siteUser.updateNickName(nickName);
        userRepository.save(siteUser);
    }

    public void updateProfile(SiteUser siteUser, String profile) {
        siteUser.updateProfile(profile);
        userRepository.save(siteUser);
    }

    public void deleteUser(SiteUser siteUser){
        siteUser.deleteUser();
    }

    public void banedUser(SiteUser siteUser) {
        siteUser.banedUser();
    }

    public void permanentDeleteUser(SiteUser siteUser) {
        userRepository.delete(siteUser);
    }



}
