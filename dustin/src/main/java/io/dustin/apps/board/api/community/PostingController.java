package io.dustin.apps.board.api.community;


import io.dustin.apps.board.api.usecase.community.posting.DeletePostingUseCase;
import io.dustin.apps.board.api.usecase.community.posting.ModifyPostingUseCase;
import io.dustin.apps.board.api.usecase.community.posting.ReadPostingUseCase;
import io.dustin.apps.board.api.usecase.community.posting.WritePostingUseCase;
import io.dustin.apps.board.domain.community.posting.model.dto.PostingDto;
import io.dustin.apps.common.model.QueryPage;
import io.dustin.apps.common.model.ResponseWithScroll;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/posting")
@RequiredArgsConstructor
public class PostingController {

    private final ReadPostingUseCase readPostingUseCase;
    private final WritePostingUseCase writePostingUseCase;
    private final ModifyPostingUseCase modifyPostingUseCase;
    private final DeletePostingUseCase deletePostingUseCase;

    @GetMapping("/all")
    public ResponseWithScroll allPostings(QueryPage queryPage) {
        return readPostingUseCase.execute(queryPage);
    }

    @PostMapping("/create")
    public PostingDto createPosting(@RequestBody PostingDto postingDto) {
        /** req 데이터 검증로직 추가 필요 */
        return writePostingUseCase.execute(postingDto.userId(), postingDto.subject(), postingDto.content());
    }

    //@PreAuthorize("isAuthenticated()")
    @PatchMapping("/{id}")
    public PostingDto modifyPosting(@PathVariable("id") Long id,
                                    @RequestBody PostingDto postingDto) {
        /** req 데이터 검증로직 추가 필요 */
        return modifyPostingUseCase.execute(id, postingDto.userId(), postingDto.subject(), postingDto.content());
    }

    //@PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{id}")
    public PostingDto deletePosting(@PathVariable("id") Long id,
                                    @RequestBody PostingDto postingDto) {
        /** req 데이터 검증로직 추가 필요 */
        return deletePostingUseCase.execute(id, postingDto.userId());
    }

}
