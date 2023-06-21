package io.dustin.apps.board.api.usecase.community.posting;

import io.dustin.apps.board.domain.community.posting.model.dto.PostingDto;
import io.dustin.apps.board.domain.community.posting.service.ReadPostingService;
import io.dustin.apps.common.exception.DataNotFoundException;
import io.dustin.apps.common.model.QueryPage;
import io.dustin.apps.common.model.ResponseWithScroll;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadPostingUseCase {

    private final ReadPostingService readPostingService;

    public ResponseWithScroll<List<PostingDto>> execute(QueryPage queryPage) {
        int realSize = queryPage.getSize();
        int querySize = realSize + 1;
        long userId = 1;
        List<PostingDto> result = readPostingService.getPostings(userId, queryPage.getNextId(), querySize);
        List<PostingDto> toClient;
        boolean isLast;
        Long nextId;
        if(result.size() <= realSize) {
            isLast = true;
            nextId = null;
            toClient = result;
        } else {
            isLast = false;
            toClient = result.subList(0, realSize);
            nextId = toClient.stream()
                    .sorted(Comparator.comparing(PostingDto::id))
                    .findFirst().orElseThrow(() -> new DataNotFoundException("데이터에 문제가 있습니다.")).id();
        }
        return ResponseWithScroll.from(toClient, isLast, nextId);

    }

}
