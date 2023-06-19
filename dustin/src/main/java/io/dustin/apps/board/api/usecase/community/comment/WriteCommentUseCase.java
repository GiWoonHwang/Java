package io.dustin.apps.board.api.usecase.community.comment;

import io.dustin.apps.board.domain.community.posting.service.ReadPostingService;
import io.dustin.apps.board.domain.community.comment.service.WriteCommentService;
import io.dustin.apps.board.domain.community.comment.model.Comment;
import io.dustin.apps.board.domain.community.comment.model.dto.CommentDto;
import io.dustin.apps.user.domain.service.ReadUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class WriteCommentUseCase {

    private final ReadPostingService readPostingService;
    private final WriteCommentService writeCommentService;

    public CommentDto execute(Long userId, Long postingId, Long reply, String content ) {
        Comment comment = writeCommentService.create(userId, postingId, reply, content);
        CommentDto dto = CommentDto.from(comment);
        return CommentDto.from(comment);
    }
}


