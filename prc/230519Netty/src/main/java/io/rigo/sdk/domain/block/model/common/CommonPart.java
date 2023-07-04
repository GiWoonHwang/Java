package io.rigo.sdk.domain.block.model.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString(exclude = "total")
@NoArgsConstructor
public class CommonPart {
    private Integer total;
    private String hash;
}
