package io.dustin.apps.board.domain.community.posting.repository.custom;

import io.dustin.apps.board.domain.community.posting.model.dto.PostingDto;

import java.util.List;

public interface CustomPostingRepository {

    List<PostingDto> getPostingList(long loginId, Long nextId, int size);

}
