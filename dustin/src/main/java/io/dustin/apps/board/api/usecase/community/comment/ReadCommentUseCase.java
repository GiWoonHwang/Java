package io.dustin.apps.board.api.usecase.community.comment;

import io.dustin.apps.board.domain.community.comment.model.dto.CommentDto;
import io.dustin.apps.board.domain.community.comment.service.ReadCommentService;
import io.dustin.apps.board.domain.community.posting.model.dto.PostingDto;
import io.dustin.apps.common.exception.DataNotFoundException;
import io.dustin.apps.common.model.QueryPage;
import io.dustin.apps.common.model.ResponseWithScroll;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadCommentUseCase {

    private final ReadCommentService readCommentService;

    public ResponseWithScroll<List<CommentDto>> execute(Long postingId, QueryPage queryPage) {
        /**
         * 게시물에 대한 순수 댓글 리스트만 보여줌
         */
        int realSize = queryPage.getSize();
        int querySize = realSize + 1;
        long userId = 1;
        List<CommentDto> result = readCommentService.getCommentsByPosting(userId, postingId, querySize, queryPage.getNextId());
        List<CommentDto> toClient;
        boolean isLast;
        Long nextId;
        if (result.size() <= realSize) {
            isLast = true;
            nextId = null;
            toClient = result;
        } else {
            isLast = false;
            toClient = result.subList(0, realSize);
            nextId = toClient.stream()
                    .sorted(Comparator.comparing(CommentDto::id))
                    .findFirst().orElseThrow(() -> new DataNotFoundException("데이터에 문제가 있습니다.")).id();
        }
        return ResponseWithScroll.from(toClient, isLast, nextId);
    }
}