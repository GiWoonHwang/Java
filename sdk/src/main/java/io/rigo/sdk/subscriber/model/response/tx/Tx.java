package io.rigo.sdk.subscriber.model.response.tx;

import io.rigo.sdk.subscriber.model.response.BaseType;
import io.rigo.sdk.subscriber.model.response.Event;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class Tx extends BaseType {
    private TxData data;
    private Event events;
}
