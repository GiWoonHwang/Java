package io.rigo.sdk.subscriber.model.response.block;

import io.rigo.sdk.subscriber.model.response.BaseType;
import io.rigo.sdk.subscriber.model.response.Event;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class NewBlock extends BaseType {
    private BlockInfo data;
    private Event events;
}
