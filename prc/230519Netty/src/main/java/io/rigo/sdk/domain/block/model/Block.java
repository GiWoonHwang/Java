package io.rigo.sdk.domain.block.model;

import com.google.gson.annotations.SerializedName;
import io.rigo.sdk.domain.block.model.blockID.BlockId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class Block {

    @SerializedName("block_id")
    private BlockId blockId;

    @SerializedName("block")
    private Block block;
}
