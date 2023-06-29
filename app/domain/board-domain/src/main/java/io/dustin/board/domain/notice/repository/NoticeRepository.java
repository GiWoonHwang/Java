package io.dustin.board.domain.notice.repository;


import io.dustin.board.common.repository.BaseRepository;
import io.dustin.board.domain.notice.model.Notice;
import io.dustin.board.domain.notice.repository.custom.CustomNoticeRepository;

public interface NoticeRepository extends BaseRepository<Notice, Long>, CustomNoticeRepository {
}
