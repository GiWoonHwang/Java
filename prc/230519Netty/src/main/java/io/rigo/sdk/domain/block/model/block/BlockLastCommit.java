package io.rigo.sdk.domain.block.model.block;

import com.google.gson.annotations.SerializedName;
import io.rigo.sdk.domain.block.model.block.lastCommit.LastCommitSignature;
import io.rigo.sdk.domain.block.model.blockID.BlockId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class BlockLastCommit {

    private String height;

    private int round;

    @SerializedName("block_id")
    private BlockId blockId;

    @SerializedName("signatures")
    private LastCommitSignature lastCommitSignature;

}
