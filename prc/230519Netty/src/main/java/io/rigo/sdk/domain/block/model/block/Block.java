package io.rigo.sdk.domain.block.model.block;

import com.google.gson.annotations.SerializedName;
import io.rigo.sdk.domain.block.model.block.lastCommit.LastCommitSignature;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

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
