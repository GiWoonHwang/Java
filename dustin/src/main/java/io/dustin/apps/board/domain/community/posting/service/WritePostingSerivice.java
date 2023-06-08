package io.dustin.apps.board.domain.community.posting.service;

import io.dustin.apps.board.domain.community.posting.model.Posting;
import io.dustin.apps.board.domain.community.posting.repository.PostingRepository;
import io.dustin.apps.board.domain.qna.question.model.Question;
import io.dustin.apps.user.domain.model.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WritePostingSerivice {

    private final PostingRepository postingRepository;

    public Posting create(String subject, String content, SiteUser user) {
        Posting q = Posting.builder()
                .subject(subject)
                .content(content)
                .author(user)
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

    public void like(Posting posting, SiteUser siteUser){
        posting.getLike().add(siteUser);
        postingRepository.save(posting);
    }

    public void click(Posting posting, SiteUser siteUser){
        posting.getClickList().add(siteUser);
        postingRepository.save(posting);
    }

}
