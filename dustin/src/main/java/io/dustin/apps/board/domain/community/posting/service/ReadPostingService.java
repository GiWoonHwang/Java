package io.dustin.apps.board.domain.community.posting.service;

import io.dustin.apps.board.domain.community.posting.model.Posting;
import io.dustin.apps.board.domain.community.posting.model.dto.PostingDto;
import io.dustin.apps.board.domain.community.posting.repository.PostingRepository;
import io.dustin.apps.common.exception.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
         *  이거 현재 안써요
         */
        return getEntity(postingRepository.findById(id), Posting.class, "posting not found");
    }



    @Transactional(readOnly = true)
    public List<PostingDto> getPostings(long userId, Long nextId, int size) {
        return postingRepository.findPostings(userId, nextId, size);
    }

    @Transactional(readOnly = true)
    public Posting findById(long id) {
        Optional<Posting> optional = this.postingRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    @Transactional(readOnly = true)
    public Posting findByIdOrThrow(long id) {
        Optional<Posting> optional = this.postingRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            throw new DataNotFoundException("""
                    id [#1]로 조회된 게시물이 없습니다.""".replace("#1", String.valueOf(id)));
        }
    }



}
