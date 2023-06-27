package io.dustin.apps.board.domain.qna.answer.service;

import io.dustin.apps.board.domain.community.posting.model.dto.PostingDto;
import io.dustin.apps.board.domain.notice.model.Notice;
import io.dustin.apps.board.domain.qna.answer.model.dto.AnswerDto;
import io.dustin.apps.board.domain.qna.answer.repository.AnswerRepository;
import io.dustin.apps.board.domain.qna.answer.model.Answer;
import io.dustin.apps.common.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static io.dustin.apps.common.utils.OptionalUtils.getEntity;

@Service
@RequiredArgsConstructor
public class ReadAnswerService {

    private final AnswerRepository answerRepository;

    @Transactional(readOnly = true)
    public AnswerDto getAnswer(Long id) {
        return this.answerRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<AnswerDto> getAnswerList(long userId, Long nextId, int size) {
        return answerRepository.getPostingList(userId, nextId, size);
    }


    @Transactional(readOnly = true)
    public Answer findById(long id) {
        Optional<Answer> optional = this.answerRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    @Transactional(readOnly = true)
    public Answer findByIdOrThrow(long id) {
        Optional<Answer> optional = this.answerRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            throw new DataNotFoundException("""
                    id [#1]로 조회된 게시물이 없습니다.""".replace("#1", String.valueOf(id)));
        }
    }

}
