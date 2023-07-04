package io.rigo.sdk.domain.block.model.block.header;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class HeaderVersion {

    private String block;

    private String app;
}
