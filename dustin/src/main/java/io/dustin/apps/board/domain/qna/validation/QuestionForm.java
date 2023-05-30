package io.dustin.apps.board.domain.qna.validation;

import jakarta.validation.constraints.NotEmpty; // 빈 문자를 허용하지 않는다.
import jakarta.validation.constraints.Size; // 문자 길이를 제한한다.

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {
    @NotEmpty(message = "제목은 필수항목입니다.") // message 속성은 검증이 실패할 경우 표시할 오류 메세지 이다.
    @Size(max=200)
    private String subject;

    @NotEmpty(message = "내용은 필수항목입니다.")
    private String content;

}
