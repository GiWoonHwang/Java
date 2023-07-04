package io.rigo.sdk.domain.stake.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class StakeAttribute {

    private String owner;
    private String to;
    private String amount;
    private String power;
    private String blockRewardUnit;
    @SerializedName("ReceivedReward")
    private String receivedReward;
    private String txhash;
    private String startHeight;
    private String refundHeight;

}
