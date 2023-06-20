package io.dustin.apps.board.domain.community.posting.service;

import io.dustin.apps.board.domain.community.comment.model.Comment;
import io.dustin.apps.board.domain.like.model.LikeCountService;
import io.dustin.apps.board.domain.community.posting.model.Posting;
import io.dustin.apps.board.domain.community.posting.repository.PostingRepository;
import io.dustin.apps.common.exception.DataNotFoundException;
import io.dustin.apps.user.domain.model.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("posting")
@RequiredArgsConstructor
public class WritePostingService implements LikeCountService {

    private final PostingRepository postingRepository;

    public Posting create(Long userId, String subject, String content) {
        Posting q = Posting.builder()
                .userId(userId)
                .subject(subject)
                .content(content)
                .build();
        return postingRepository.save(q);
    }


    public void updateContent(Posting posting, String subject, String content) {
        posting.updateSubject(subject);
        posting.updateContent(content);
        postingRepository.save(posting);
    }

    @Transactional
    public void delete(Posting posting){
        posting.delete();
    }

    public void click(Posting posting, SiteUser siteUser){
        //posting.getClickList().add(siteUser);
        postingRepository.save(posting);
    }

    @Override
    public void likeCount(long id) { System.out.println("게시물 id : [" + id + "] 카운트 하나 올림");
        Posting posting = this.findByIdOrThrow(id);
        Long LikeCount = posting.getLikeCount() + 1;
        posting.countUp(LikeCount);
    }

    @Override
    public void likeUnCount(long id) {
        System.out.println("게시물 id : [" + id + "] 코멘트 카운트 하나 내림");
        Posting posting = this.findByIdOrThrow(id);
        Long LikeCount = posting.getLikeCount() - 1;
        posting.countUp(LikeCount);
    }

    public Posting findById(long id) {
        Optional<Posting> optional = this.postingRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

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
