package io.rigo.sdk.subscriber.model.response.block;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class BlockInfo {
    private String type;
    private BlockValue value;
}
