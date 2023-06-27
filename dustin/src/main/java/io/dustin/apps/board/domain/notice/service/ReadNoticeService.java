package io.dustin.apps.board.domain.notice.service;

import io.dustin.apps.board.domain.community.posting.model.Posting;
import io.dustin.apps.board.domain.notice.model.Notice;
import io.dustin.apps.board.domain.notice.model.dto.NoticeDto;
import io.dustin.apps.board.domain.notice.repository.NoticeRepository;
import io.dustin.apps.common.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static io.dustin.apps.common.utils.OptionalUtils.getEntity;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReadNoticeService {

    private final NoticeRepository noticeRepository;

    public NoticeDto getNotice(Long userId, Long noticeId) {
        /** todo
         *  공지사항은 연관관계도 없고, 댓글도 없고 ... 쿼리를 굳이 쓸 필요가 있을까 ?
         *  ㄴ 멍청아 좋아요 유무 판단하려면 쿼리 써야지
         */
        return noticeRepository.getNotice(userId, noticeId);
    }

    @Transactional(readOnly = true)
    public List<NoticeDto> getNoticeList(long userId, Long nextId, int size) {
        return noticeRepository.getNoticeList(userId, nextId, size);
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
