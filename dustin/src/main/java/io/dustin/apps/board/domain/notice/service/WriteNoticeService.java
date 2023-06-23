package io.dustin.apps.board.domain.notice.service;

import io.dustin.apps.board.domain.community.posting.model.Posting;
import io.dustin.apps.board.domain.like.model.LikeCountService;
import io.dustin.apps.board.domain.notice.model.Notice;
import io.dustin.apps.board.domain.notice.repository.NoticeRepository;
import io.dustin.apps.common.exception.DataNotFoundException;
import io.dustin.apps.user.domain.model.SiteUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service("notice")
@RequiredArgsConstructor
public class WriteNoticeService implements LikeCountService {

    private final NoticeRepository noticeRepository;

    public Notice create(Long adminId, String subject, String content) {
        Notice n = Notice.builder()
                .subject(subject)
                .content(content)
                .adminId(adminId)
                .build();
        return noticeRepository.save(n);
    }

    public void updateContent(Notice notice, String subject, String content) {
        notice.updateSubject(subject);
        notice.updateContent(content);
        noticeRepository.save(notice);
    }

    public void delete(Notice notice){
        notice.delete();
    }

    @Override
    public void likeCount(long id) {
        System.out.println("공지 id : [" + id + "] 카운트 하나 올림");
    }

    @Override
    public void likeUnCount(long id) {
        System.out.println("공지 id : [" + id + "] 카운트 하나 내림");
    }


}
