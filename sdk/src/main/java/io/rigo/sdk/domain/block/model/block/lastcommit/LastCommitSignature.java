package io.rigo.sdk.domain.block.model.block.lastcommit;


import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class LastCommitSignature {

    @SerializedName("block_id_flag")
    private int blockIdFlag;

    @SerializedName("validator_address")
    private String validatorAddress;

    private String timestamp;

    private String signature;


}
