package io.dustin.apps.board.domain.community.posting.service;

import io.dustin.apps.board.domain.community.posting.model.Posting;
import io.dustin.apps.board.domain.community.posting.model.dto.PostingDto;
import io.dustin.apps.board.domain.community.posting.repository.PostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static io.dustin.apps.common.utils.OptionalUtils.getEntity;

@Service
@RequiredArgsConstructor
public class ReadPostingService {

    private final PostingRepository postingRepository;

    @Transactional(readOnly = true)
    public Posting getPosting(Long id) {
        /** todo
         *  clickCount 한개 증가시키기
         *  게시물에 해당되는 댓글 가져오기
         *  좋아요, 북마크 표시할 수 있는 데이터 넣기
         */
        return getEntity(postingRepository.findById(id), Posting.class, "posting not found");
    }



    @Transactional(readOnly = true)
    public List<PostingDto> getPostings(long userId, Long nextId, int size) {
        return postingRepository.findPostings(userId, nextId, size);
    }


    @Transactional(readOnly = true)
    public Posting findById(Long id){
        /**
         * 굳이 하나 더 만든 이유
         * 좋아요는 게시물을 자세히 보지 않고도(누르지 않고) 증가시킬 수 있기 때문이다 getPosting는 게시물 상세보기로써 조회수가 증가된다.
         */
        return getEntity(postingRepository.findById(id), Posting.class, "posting not found");
    }



}
