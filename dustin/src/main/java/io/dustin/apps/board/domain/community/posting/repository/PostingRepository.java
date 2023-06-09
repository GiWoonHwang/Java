package io.dustin.apps.board.domain.community.posting.repository;

import io.dustin.apps.board.domain.community.posting.model.Posting;
import io.dustin.apps.board.domain.qna.question.model.Question;
import io.dustin.apps.common.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostingRepository extends BaseRepository<Posting, Long> {
    Page<Posting> findAll(Pageable pageable);

}
