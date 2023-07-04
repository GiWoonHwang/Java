package io.rigo.sdk.subscriber.model.response.block;

import com.google.gson.annotations.SerializedName;
import io.rigo.sdk.domain.block.model.block.Block;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class BlockValue {
    private Block block;
    @SerializedName("result_begin_block")
    private ResultBeginBlock resultBeginBlock;
    @SerializedName("result_end_block")
    private ResultEndBlock resultEndBlock;

}
