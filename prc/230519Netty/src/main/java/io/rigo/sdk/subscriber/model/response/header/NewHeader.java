package io.rigo.sdk.subscriber.model.response.header;

import com.google.gson.annotations.SerializedName;
import io.rigo.sdk.subscriber.model.response.block.ResultBeginBlock;
import io.rigo.sdk.subscriber.model.response.block.ResultEndBlock;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class NewHeader {
    private Header header;

    @SerializedName("num_txs")
    private String numberTxs;

    @SerializedName("result_begin_block")
    private ResultBeginBlock resultBeginBlock;
    @SerializedName("result_end_block")
    private ResultEndBlock resultEndBlock;
}
