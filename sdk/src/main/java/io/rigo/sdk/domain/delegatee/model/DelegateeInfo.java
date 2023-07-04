package io.rigo.sdk.domain.delegatee.model;

import io.rigo.sdk.domain.stake.model.StakeAttribute;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class DelegateeInfo {
    private String address;
    private String pubKey;
    private String selfAmount;
    private String selfPower;
    private String totalAmount;
    private String totalPower;
    private String rewardAmount;
    private List<StakeAttribute> stakes;
}
