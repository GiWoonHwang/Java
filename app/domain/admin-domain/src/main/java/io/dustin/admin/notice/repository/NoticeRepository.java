package io.dustin.admin.notice.repository;


import io.dustin.admin.notice.repository.custom.CustomNoticeRepository;
import io.dustin.admin.notice.model.Notice;
import io.dustin.common.repository.BaseRepository;

public interface NoticeRepository extends BaseRepository<Notice, Long>, CustomNoticeRepository {
}
