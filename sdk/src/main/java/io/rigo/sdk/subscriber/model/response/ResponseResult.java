package io.rigo.sdk.subscriber.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ResponseResult<T> {
    private String jsonrpc;
    private String id;
    private T result;
}
