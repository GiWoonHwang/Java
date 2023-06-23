package io.dustin.apps.board.domain.notice.repository.custom;

import io.dustin.apps.board.domain.notice.model.dto.NoticeDto;

import java.util.List;

public interface CustomNoticeRepository {

    List<NoticeDto> findNotices(Long nextId, int size);
}
