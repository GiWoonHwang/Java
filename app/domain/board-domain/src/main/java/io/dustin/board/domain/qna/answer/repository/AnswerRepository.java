package io.dustin.board.domain.qna.answer.repository;


import io.dustin.board.domain.qna.answer.model.Answer;
import io.dustin.common.repository.BaseRepository;

public interface AnswerRepository extends BaseRepository<Answer, Long> {

    Answer findByQuestionId(Long questionId);
}
