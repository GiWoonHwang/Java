package io.dustin.apps.board.domain.qna.user.service;

import io.dustin.apps.board.domain.qna.model.SiteUser;
import io.dustin.apps.board.domain.qna.user.UserRole;
import io.dustin.apps.board.domain.qna.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static io.dustin.apps.common.utils.OptionalUtils.getEntity;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SiteUser siteUser = getEntity(userRepository.findByUserName(username), SiteUser.class, "사용자를 찾을 수 없습니다.");
        List<GrantedAuthority> authorities = new ArrayList<>();
        if("admin".equals(username)){
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }
        return new User(siteUser.getNickName(), siteUser.getPassword(), authorities);
    }


}
