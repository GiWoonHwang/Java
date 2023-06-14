package io.dustin.apps.user.domain.repository.custom;

import io.dustin.apps.common.code.BoardType;
import io.dustin.apps.user.domain.model.dto.LikeItUserDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomUserRepository {

    List<LikeItUserDto> findAllLikeItUser(Long boardId, BoardType boardType, Pageable pageable);

    List<LikeItUserDto> findAllLikeItUserNoOffeset(Long boardId, BoardType boardType, Pageable pageable);

}
