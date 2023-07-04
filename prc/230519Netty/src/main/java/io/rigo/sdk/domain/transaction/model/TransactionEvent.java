package io.rigo.sdk.domain.transaction.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class TransactionEvent {
    private String type;
    private List<EventAttribute> attributes;
}
