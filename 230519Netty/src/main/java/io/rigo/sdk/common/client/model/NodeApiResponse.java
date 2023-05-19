package io.rigo.sdk.common.client.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * node와 통신할 때 성공시 응답받는 객체
 * created by basquiat
 */
@Getter
@NoArgsConstructor
@ToString
public class NodeApiResponse<T> {
    private String jsonrpc;
    private Long id;
    private T result;
}
