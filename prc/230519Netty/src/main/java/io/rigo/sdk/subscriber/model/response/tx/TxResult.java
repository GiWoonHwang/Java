package io.rigo.sdk.subscriber.model.response.tx;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class TxResult {
    private String height;
    private String tx;
    private TxResultData result;
}
