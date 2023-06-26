package io.dustin.apps.board.api.usecase.community.posting;

import io.dustin.apps.board.domain.community.comment.model.dto.CommentDto;
import io.dustin.apps.board.domain.community.comment.service.ReadCommentService;
import io.dustin.apps.board.domain.community.posting.model.Posting;
import io.dustin.apps.board.domain.community.posting.model.dto.PostingDetailDto;
import io.dustin.apps.board.domain.community.posting.model.dto.PostingDto;
import io.dustin.apps.board.domain.community.posting.service.ReadPostingService;
import io.dustin.apps.board.domain.community.posting.service.WritePostingService;
import io.dustin.apps.board.domain.notice.service.WriteNoticeService;
import io.dustin.apps.common.model.CountByPagingInfo;
import io.dustin.apps.common.model.QueryPage;
import io.dustin.apps.common.model.ResponseWithScroll;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static io.dustin.apps.common.model.ResponseWithScrollSetting.getCountByPagingInfo;
import static java.util.stream.Collectors.groupingBy;

@Service
@RequiredArgsConstructor
public class ReadPostingUseCase {

    private final ReadPostingService readPostingService;
    private final ReadCommentService readCommentService;
    private final WritePostingService writePostingService;

    public ResponseWithScroll<List<PostingDto>> execute(QueryPage queryPage) {
        /**
         * 게시물 리스트 보여줌
         */
        long userId = 1;
        int realSize = queryPage.getSize();
        int querySize = realSize + 1;

        List<PostingDto> result = readPostingService.getPostingList(userId, queryPage.getNextId(), querySize);
        CountByPagingInfo<PostingDto> cbi = getCountByPagingInfo(result, realSize);

        return ResponseWithScroll.from(cbi.result(), cbi.isLast(), cbi.nextId());

    }

    @Transactional
    public PostingDetailDto postingDetail(Long postingId, QueryPage queryPage) {
        /**
         * 게시물 상세조회 했을때 게시물과 댓글을 같이 보여줌
         */
        writePostingService.click(postingId);
        // 1. PostingDetailDto -> 가져온다. -> qeuryDsl에서 가져온다.

        // 2. List<CommentDto>

        long userId = 1;
        int realSize = queryPage.getSize();
        int querySize = realSize + 1;

        List<CommentDto> result = readCommentService.getCommentsByPosting(userId, postingId, querySize, queryPage.getNextId());
        CountByPagingInfo<CommentDto> cbi = getCountByPagingInfo(result, realSize);

        if(result.size() == 1) {
            Long commentId = result.get(0).id();
            if(commentId == null) {
                return PostingDetailDto.from(result.get(0).posting(), ResponseWithScroll.from(Collections.emptyList(), cbi.isLast(), cbi.nextId()));
            }
        }

        ResponseWithScroll<List<CommentDto>> commentList =  ResponseWithScroll.from(cbi.result(), cbi.isLast(), cbi.nextId());
        Map<Posting, List<CommentDto>> map = cbi.result().stream()
                                                         .collect(groupingBy(CommentDto::posting));
        return map.entrySet().stream()
                             .map(Map.Entry::getKey)
                             .map( posting -> PostingDetailDto.from(posting, commentList))
                             .findFirst().orElseThrow();
    }

}
