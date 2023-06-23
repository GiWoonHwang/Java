package io.dustin.apps.board.domain.notice.service;

import io.dustin.apps.board.domain.notice.model.Notice;
import io.dustin.apps.board.domain.notice.model.dto.NoticeDto;
import io.dustin.apps.board.domain.notice.repository.NoticeRepository;
import io.dustin.apps.common.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static io.dustin.apps.common.utils.OptionalUtils.getEntity;

@Service
@RequiredArgsConstructor
public class ReadNoticeService {

    private final NoticeRepository noticeRepository;

    public Notice getNotice(Long id) {
        /** todo
         *  clickCount 한개 증가시키기
         */
        return getEntity(noticeRepository.findById(id), Notice.class, "posting not found");
    }

    @Transactional(readOnly = true)
    public List<NoticeDto> getNotices(Long nextId, int size) {
        return noticeRepository.findNotices(nextId, size);
    }

    @Transactional(readOnly = true)
    public Notice findById(long id) {
        Optional<Notice> optional = this.noticeRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    @Transactional(readOnly = true)
    public Notice findByIdOrThrow(long id) {
        Optional<Notice> optional = this.noticeRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            throw new DataNotFoundException("""
                    id [#1]로 조회된 게시물이 없습니다.""".replace("#1", String.valueOf(id)));
        }
    }


}
