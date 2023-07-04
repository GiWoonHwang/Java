package io.rigo.sdk.subscriber.model.response.header;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class NewBlockHeaderData {
    private String type;
    private NewHeader value;
}
