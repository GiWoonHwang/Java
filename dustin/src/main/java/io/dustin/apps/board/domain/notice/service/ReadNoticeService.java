package io.dustin.apps.board.domain.notice.service;

import io.dustin.apps.board.domain.notice.model.Notice;
import io.dustin.apps.board.domain.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static io.dustin.apps.common.utils.OptionalUtils.getEntity;

@Service
@RequiredArgsConstructor
public class ReadNoticeService {

    private final NoticeRepository noticeRepository;

    public Notice getPosting(Long id) {
        /** todo
         *  clickCount 한개 증가시키기
         */
        return getEntity(noticeRepository.findById(id), Notice.class, "posting not found");
    }

    @Transactional(readOnly = true)
    public Page<Notice> getList(Pageable pageable) {
//        List<Sort.Order> sorts = new ArrayList<>();
//        sorts.add(Sort.Order.desc("createDate"));
//        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return noticeRepository.findAll(pageable);
    }


}
