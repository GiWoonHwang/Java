package io.dustin.apps.board.domain.community.posting.repository.custom;

import io.dustin.apps.board.domain.community.posting.model.dto.PostingDto;

import java.util.List;

public interface CustomPostingRepository {

    PostingDto getPosting(long loginId, long postingId);

    List<PostingDto> getPostingList(long loginId, Long nextId, int size);

}
