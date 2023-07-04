package io.rigo.sdk.common.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * node에서 응답받는 에러 응답 객체
 * created by basquiat
 */
@Getter
@NoArgsConstructor
@ToString
public class RigoApiError {
    private long code;
    private String message;
    private String data;
}
