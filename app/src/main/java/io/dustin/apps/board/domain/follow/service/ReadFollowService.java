package io.dustin.apps.board.domain.follow.service;

import io.dustin.apps.board.domain.follow.model.Follow;
import io.dustin.apps.board.domain.follow.repository.FollowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReadFollowService {

    private final FollowRepository followRepository;

    public List<Follow> getFollowingIdList(Long followerId) {return followRepository.findByFollowerId(followerId);}

    public List<Follow> getFollowerIdList(Long followingId) {return followRepository.findByFollowingId(followingId);}





}
