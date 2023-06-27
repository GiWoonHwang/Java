package io.dustin.apps.board.domain.community.posting.repository.custom;

import io.dustin.apps.board.domain.community.posting.model.dto.PostingDto;

import java.util.List;

public interface CustomPostingRepository {

    PostingDto getPosting(long userId, long postingId);

    List<PostingDto> getPostingList(long userId, Long nextId, int size);

}
