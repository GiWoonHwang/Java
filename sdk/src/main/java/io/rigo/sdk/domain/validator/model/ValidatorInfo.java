package io.rigo.sdk.domain.validator.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class ValidatorInfo {
    private String address;

    @SerializedName("pub_key")
    private PubKey pubKey;

    @SerializedName("voting_power")
    private String votingPower;

    @SerializedName("proposer_priority")
    private String proposerPriority;
}
