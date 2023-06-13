package io.dustin.apps.user.domain.service;

import io.dustin.apps.common.code.BoardType;
import io.dustin.apps.user.domain.model.SiteUser;
import io.dustin.apps.user.domain.model.dto.LikeItUser;
import io.dustin.apps.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static io.dustin.apps.common.utils.OptionalUtils.getEntity;

@RequiredArgsConstructor // 초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자를 생성해 줍니다.
@Service
public class ReadUserService {

    private final UserRepository userRepository;

    public SiteUser getUser(Long userId) { // User 서비스를 통해 SiteUser를 조회한다.
        return getEntity(userRepository.findById(userId), SiteUser.class, "site user not found");
    }

    public List<LikeItUser> likeItUsers(Long boardId, BoardType boardType, Pageable pageable) {
        return userRepository.findAllLikeItUser(boardId, boardType, pageable);
    }
}
