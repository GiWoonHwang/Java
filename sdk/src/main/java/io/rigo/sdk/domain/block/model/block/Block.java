package io.rigo.sdk.domain.block.model.block;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class Block {

    @SerializedName("header")
    private BlockHeader blockHeader;

    @SerializedName("data")
    private BlockData blockData;

    @SerializedName("evidence")
    private BlockEvidence blockEvidence;

    @SerializedName("last_commit")
    private BlockLastCommit blockLastCommit;


}
