package io.rigo.sdk.domain.validator.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class PubKey {
    private String type;
    private String value;
}
