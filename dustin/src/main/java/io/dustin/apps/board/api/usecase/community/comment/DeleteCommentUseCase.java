package io.dustin.apps.board.api.usecase.community.comment;

import io.dustin.apps.board.domain.community.comment.service.ReadCommentService;
import io.dustin.apps.board.domain.community.comment.service.WriteCommentService;
import io.dustin.apps.board.domain.community.comment.model.Comment;
import io.dustin.apps.board.domain.community.comment.model.dto.CommentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class DeleteCommentUseCase {

    private final ReadCommentService readCommentService;
    private final WriteCommentService writeCommentService;

    public CommentDto execute(Long userId, Long id) {
        Comment comment = readCommentService.getComment(id);
        if(!comment.getUserId().equals(userId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제 권한이 없습니다.");
        }
        writeCommentService.delete(comment);
        return CommentDto.from(comment);
    }
}
