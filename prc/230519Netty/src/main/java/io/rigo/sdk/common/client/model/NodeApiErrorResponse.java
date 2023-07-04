package io.rigo.sdk.common.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * node와 통신할 때 에러발생시 대응되는 에러 응답 객체
 * created by basquiat
 */
@Getter
@NoArgsConstructor
@ToString
public class NodeApiErrorResponse {
    private String jsonrpc;
    private Long id;
    private RigoApiError error;
}
