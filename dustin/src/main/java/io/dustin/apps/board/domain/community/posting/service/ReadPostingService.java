package io.dustin.apps.board.domain.community.posting.service;

import io.dustin.apps.board.domain.community.posting.model.Posting;
import io.dustin.apps.board.domain.community.posting.repository.PostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import static io.dustin.apps.common.utils.OptionalUtils.getEntity;

@Service
@RequiredArgsConstructor
public class ReadPostingService {

    private final PostingRepository postingRepository;

    public Posting getPosting(Long id) {
        /** todo
         *  clickCount 한개 증가시키기
         */
        return getEntity(postingRepository.findById(id), Posting.class, "posting not found");
    }

    @Transactional(readOnly = true)
    public Page<Posting> getList(Pageable pageable) {
//        List<Sort.Order> sorts = new ArrayList<>();
//        sorts.add(Sort.Order.desc("createDate"));
//        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return postingRepository.findAll(pageable);
    }




}