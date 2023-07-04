package io.rigo.sdk.domain.transaction.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class EventAttribute {
    private String key;
    private String value;
    private boolean index;
}
