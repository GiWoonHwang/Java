package io.rigo.sdk.domain.delegatee.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class Delegatee {
    private String key;
    private DelegateeInfo value;
}
