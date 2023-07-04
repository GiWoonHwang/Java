package io.rigo.sdk.subscriber.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class JSONRPCRequest {
    private String jsonrpc;
    private String id;
    private String method;
    private Params params;
}
