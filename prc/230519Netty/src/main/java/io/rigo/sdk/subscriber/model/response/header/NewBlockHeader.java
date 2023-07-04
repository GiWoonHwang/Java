package io.rigo.sdk.subscriber.model.response.header;

import io.rigo.sdk.subscriber.model.response.BaseType;
import io.rigo.sdk.subscriber.model.response.Event;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class NewBlockHeader extends BaseType {
    private NewBlockHeaderData data;
    private Event events;
}
