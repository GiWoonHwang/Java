package io.dustin.apps.board.domain.qna.question.repository.custom;

import io.dustin.apps.board.domain.community.posting.model.dto.PostingDto;
import io.dustin.apps.board.domain.qna.question.model.dto.QuestionDto;

import java.util.List;

public interface CustomQuestionRepository {

    QuestionDto getQuestion(long loginId, long questionId);

    List<QuestionDto> getQuestionList(long loginId, Long nextId, int size);
}
