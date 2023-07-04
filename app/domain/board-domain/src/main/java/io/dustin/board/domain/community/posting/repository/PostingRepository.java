package io.dustin.board.domain.community.posting.repository;

import io.dustin.board.domain.community.posting.model.Posting;
import io.dustin.board.domain.community.posting.repository.custom.CustomPostingRepository;
import io.dustin.common.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostingRepository extends BaseRepository<Posting, Long>, CustomPostingRepository {
    Page<Posting> findAll(Pageable pageable);

}
