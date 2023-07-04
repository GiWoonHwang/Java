package io.rigo.sdk.domain.stake.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class Stake {
    private String key;
    private List<StakeAttribute> value;
}
