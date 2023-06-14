package io.dustin.apps.board.domain.like.service;

import io.dustin.apps.board.domain.like.repository.LikeRepository;
import io.dustin.apps.board.domain.qna.answer.model.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static io.dustin.apps.common.utils.OptionalUtils.getEntity;

@RequiredArgsConstructor
@Service
public class ReadLIkeService {

    private final LikeRepository likeRepository;

    @Transactional(readOnly = true)
    public Answer getAnswer(Long id) {
        return getEntity(this.likeRepository.findById(id), Answer.class, "answer not fount");
    }

}
