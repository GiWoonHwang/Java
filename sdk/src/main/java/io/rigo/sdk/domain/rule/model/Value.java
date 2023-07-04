package io.rigo.sdk.domain.rule.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class Value {

    private String version;

    private String maxValidatorCnt;

    private String amountPerPower;

    private String rewardPerPower;

    @SerializedName("lazyRewardBlocks")
    private String lazyRewardBlock;

    @SerializedName("lazyApplyingBlocks")
    private String lazyApplyingBlock;

    private String minTrxFee;

    @SerializedName("minVotingPeriodBlocks")
    private String minVotingPeriodBlock;

    @SerializedName("maxVotingPeriodBlocks")
    private String maxVotingPeriodBlock;

    private String minSelfStakeRatio;

    private String maxUpdatableStakeRatio;

    private String slashRatio;
}
