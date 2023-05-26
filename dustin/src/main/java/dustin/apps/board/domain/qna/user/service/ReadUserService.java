package dustin.apps.board.domain.qna.user.service;

import dustin.apps.board.domain.qna.model.SiteUser;
import dustin.apps.board.domain.qna.user.repository.UserRepository;
import dustin.libs.common.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static dustin.libs.common.utils.OptionalUtils.getEntity;

@RequiredArgsConstructor // 초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성해 줍니다.
@Service
public class ReadUserService {

    private final UserRepository userRepository;

    public SiteUser getUser(String username) { // User 서비스를 통해 SiteUser를 조회한다.
        return getEntity(userRepository.findByUserName(username), SiteUser.class, "site user not found");
    }
}
