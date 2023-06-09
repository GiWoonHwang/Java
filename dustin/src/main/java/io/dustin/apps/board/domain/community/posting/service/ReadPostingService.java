package io.dustin.apps.board.domain.community.posting.service;

import io.dustin.apps.board.domain.community.posting.model.Posting;
import io.dustin.apps.board.domain.community.posting.repository.PostingRepository;
import io.dustin.apps.board.domain.qna.question.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static io.dustin.apps.common.utils.OptionalUtils.getEntity;

@Service
@RequiredArgsConstructor
public class ReadPostingService {

    private final PostingRepository postingRepository;

    @Transactional(readOnly = true)
    public List<Posting> getList() { return this.postingRepository.findAll(); }

    public Posting getPosting(Long id) {
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
