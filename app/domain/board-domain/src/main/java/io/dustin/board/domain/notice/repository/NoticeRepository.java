package io.dustin.board.domain.notice.repository;


import io.dustin.board.domain.notice.model.Notice;
import io.dustin.board.domain.notice.repository.custom.CustomNoticeRepository;
import io.dustin.common.repository.BaseRepository;

public interface NoticeRepository extends BaseRepository<Notice, Long>, CustomNoticeRepository {
}
