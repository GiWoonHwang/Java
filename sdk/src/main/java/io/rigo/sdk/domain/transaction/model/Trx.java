package io.rigo.sdk.domain.transaction.model;

import lombok.*;

@Getter
@Builder
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
public class Trx {
    private String hash;
    private int version;
    private long time;
    private long nonce;
    private String from;
    private String to;
    private String amount;
    private String gas;
    private int type;
    private Object payload;
    private String sig;
}
