package apps.noticeboard.user;

import libs.entities.SiteUser;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
import libs.common.exception.DataNotFoundException;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // 초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성해 줍니다.
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public SiteUser create(String name, String email, String password) {
        SiteUser user = new SiteUser();
        user.setUsername(name);
        user.setEmail(email);

//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // 직접 객체를 생성하는 것보다는 빈(bean)으로 등록해서 사용하는 것이 좋다.
        user.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(user);

        return user;
    }

    public SiteUser getUser(String username) { // User 서비스를 통해 SiteUser를 조회한다.
        Optional<SiteUser> siteUser = this.userRepository.findByusername(username);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new DataNotFoundException("siteuser not found");
        }
    }
}
