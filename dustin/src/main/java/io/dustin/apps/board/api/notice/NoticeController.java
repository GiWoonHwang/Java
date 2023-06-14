package io.dustin.apps.board.api.notice;

import io.dustin.apps.board.api.usecase.notice.DeleteNoticeUseCase;
import io.dustin.apps.board.api.usecase.notice.ModifyNoticeUseCase;
import io.dustin.apps.board.api.usecase.notice.WriteNoticeUseCase;
import io.dustin.apps.board.domain.community.posting.model.dto.PostingDto;
import io.dustin.apps.board.domain.notice.model.dto.NoticeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/notice")
@RequiredArgsConstructor
public class NoticeController {

    private final WriteNoticeUseCase writeNoticeUseCase;
    private final ModifyNoticeUseCase modifyNoticeUseCase;
    private final DeleteNoticeUseCase deleteNoticeUseCase;

    @PostMapping("/create")
    public NoticeDto createPosting(@RequestBody NoticeDto noticeDto) {
        /** req 데이터 검증로직 추가 필요 */
        return writeNoticeUseCase.execute(noticeDto.adminId(), noticeDto.subject(), noticeDto.content());
    }

    //@PreAuthorize("isAuthenticated()")
    @PatchMapping("/{id}")
    public NoticeDto modifyPosting(@PathVariable("id") Long id,
                                    @RequestBody NoticeDto noticeDto) {
        /** req 데이터 검증로직 추가 필요 */
        return modifyNoticeUseCase.execute(noticeDto.id(), noticeDto.adminId(), noticeDto.subject(), noticeDto.content());
    }

    //@PreAuthorize("isAuthenticated()")
    @DeleteMapping("/{id}")
    public NoticeDto deletePosting(@PathVariable("id") Long id,
                                    @RequestBody NoticeDto noticeDto) {
        /** req 데이터 검증로직 추가 필요 */
        return deleteNoticeUseCase.execute(noticeDto.id(), noticeDto.adminId());
    }
}
