package io.dustin.apps.board.domain.community.comment.repository.custom;

import io.dustin.apps.board.domain.community.comment.model.dto.CommentDto;

import java.util.List;

public interface CustomCommentRepository {

    List<CommentDto> commentListByPosting(long loginId, long postingId, int size, Long nextId);

    List<CommentDto> replyListByComment(long loginId, long commentId, int size, Long nextId);

}
