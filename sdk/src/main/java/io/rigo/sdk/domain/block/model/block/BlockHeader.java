package io.rigo.sdk.domain.block.model.block;

import com.google.gson.annotations.SerializedName;
import io.rigo.sdk.domain.block.model.block.header.HeaderLastBlockId;
import io.rigo.sdk.domain.block.model.block.header.HeaderVersion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class BlockHeader {

    @SerializedName("header")
    private HeaderVersion headerVersion;

    @SerializedName("chain_id")
    private String chainId;

    private String height;

    private String time;

    @SerializedName("last_block_id")
    private HeaderLastBlockId headerLastBlockId;

}
