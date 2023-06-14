package io.dustin.apps.board.api.usecase.community.posting;

import io.dustin.apps.board.domain.community.posting.model.Posting;
import io.dustin.apps.board.domain.community.posting.model.dto.PostingDto;
import io.dustin.apps.board.domain.community.posting.service.ReadPostingService;
import io.dustin.apps.board.domain.community.posting.service.WritePostingSerivice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DeletePostingUseCase {

    private final ReadPostingService readPostingService;
    private final WritePostingSerivice writePostingSerivice;


    public PostingDto execute(Long id, Long userId) {
        Posting posting = readPostingService.getPosting(id);
        if(!posting.getAuthor().equals(userId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제 권한이 없습니다.");
        }
        writePostingSerivice.delete(posting);
        return PostingDto.from(posting);
    }


}
