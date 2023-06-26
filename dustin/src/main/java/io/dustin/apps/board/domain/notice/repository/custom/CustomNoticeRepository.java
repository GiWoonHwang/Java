package io.dustin.apps.board.domain.notice.repository.custom;

import io.dustin.apps.board.domain.notice.model.dto.NoticeDto;

import java.util.List;

public interface CustomNoticeRepository {

    NoticeDto getNotice(long loginId, long noticeId);
    List<NoticeDto> getNoticeList(long loginId, Long nextId, int size);
}
