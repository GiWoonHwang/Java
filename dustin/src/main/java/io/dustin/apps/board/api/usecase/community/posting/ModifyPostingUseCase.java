package io.dustin.apps.board.api.usecase.community.posting;

import io.dustin.apps.board.domain.community.comment.model.Comment;
import io.dustin.apps.board.domain.community.comment.model.dto.CommentDto;
import io.dustin.apps.board.domain.community.posting.model.Posting;
import io.dustin.apps.board.domain.community.posting.model.dto.PostingDto;
import io.dustin.apps.board.domain.community.posting.service.ReadPostingService;
import io.dustin.apps.board.domain.community.posting.service.WritePostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ModifyPostingUseCase {

    private final ReadPostingService readPostingService;
    private final WritePostingService writePostingService;

    @Transactional
    public PostingDto execute(Long id, Long userId, String subject, String content) {
        Posting posting = readPostingService.findById(id);
        if (!posting.getUserId().equals(userId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "수정권한이 없습니다.");
        }
        writePostingService.updateContent(posting, subject, content);
        return PostingDto.from(posting);
    }
}
