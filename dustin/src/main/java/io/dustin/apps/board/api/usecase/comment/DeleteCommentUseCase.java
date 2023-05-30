package io.dustin.apps.board.api.usecase.comment;

import io.dustin.apps.board.domain.qna.comment.service.ReadCommentService;
import io.dustin.apps.board.domain.qna.comment.service.WriteCommentService;
import io.dustin.apps.board.domain.qna.model.Answer;
import io.dustin.apps.board.domain.qna.model.Comment;
import io.dustin.apps.board.domain.qna.model.dto.AnswerDto;
import io.dustin.apps.board.domain.qna.model.dto.CommentDto;
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

    public CommentDto execute(Principal principal, Long id) {
        Comment comment = readCommentService.getComment(id);
        if(!comment.getAuthor().getNickName().equals(principal.getName())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "삭제 권한이 없습니다.");
        }
        writeCommentService.delete(comment);
        return CommentDto.from(comment);
    }
}
