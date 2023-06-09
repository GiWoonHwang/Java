package io.dustin.apps.board.api.usecase.community.comment;

import io.dustin.apps.board.domain.community.posting.model.Posting;
import io.dustin.apps.board.domain.community.posting.service.ReadPostingService;
import io.dustin.apps.board.domain.community.comment.service.WriteCommentService;
import io.dustin.apps.board.domain.community.comment.model.Comment;
import io.dustin.apps.user.domain.model.SiteUser;
import io.dustin.apps.board.domain.community.comment.model.dto.CommentDto;
import io.dustin.apps.user.domain.service.ReadUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class WriteCommentUseCase {

    private final ReadPostingService readPostingService;
    private final ReadUserService readUserService;
    private final WriteCommentService writeCommentService;

    public CommentDto execute(Principal principal, Long postingId, String content) {
        Posting posting = readPostingService.getPosting(postingId);
        SiteUser siteUser = readUserService.getUser(principal.getName());
        Comment comment = writeCommentService.create(posting, content, siteUser);
        CommentDto dto = CommentDto.from(comment);
        return CommentDto.from(comment);
    }
    }


