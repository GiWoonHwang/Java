package io.rigo.sdk.domain.block.model.block.header;

import com.google.gson.annotations.SerializedName;
import io.rigo.sdk.domain.block.model.common.CommonPart;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class HeaderLastBlockId {
    private String hash;

    @SerializedName("parts")
    private CommonPart commonParts;

    @SerializedName("last_commit_hash")
    private String lastCommitHash;

    @SerializedName("data_hash")
    private String dataHash;

    @SerializedName("validators_hash")
    private String validatorsHash;

    @SerializedName("next_validators_hash")
    private String nextValidatorsHash;

    @SerializedName("consensus_hash")
    private String consensusHash;

    @SerializedName("app_hash")
    private String appHash;

    @SerializedName("last_results_hash")
    private String lastResultsHash;

    @SerializedName("evidence_hash")
    private String evidenceHash;

    @SerializedName("proposer_address")
    private String proposerAddress;



}
