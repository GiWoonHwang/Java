package io.dustin.board.domain.qna.answer.repository;


import io.dustin.board.common.repository.BaseRepository;
import io.dustin.board.domain.qna.answer.model.Answer;

public interface AnswerRepository extends BaseRepository<Answer, Long> {

    Answer findByQuestionId(Long questionId);
}
