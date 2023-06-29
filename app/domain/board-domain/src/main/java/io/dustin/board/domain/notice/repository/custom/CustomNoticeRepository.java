package io.dustin.board.domain.notice.repository.custom;


import io.dustin.board.domain.notice.model.dto.NoticeDto;

import java.util.List;

public interface CustomNoticeRepository {

    NoticeDto getNotice(long userId, long noticeId);
    List<NoticeDto> getNoticeList(long userId, Long nextId, int size);
}
