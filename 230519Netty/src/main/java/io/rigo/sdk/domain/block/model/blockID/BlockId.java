package io.rigo.sdk.domain.block.model.blockID;

import com.google.gson.annotations.SerializedName;
import io.rigo.sdk.domain.block.model.common.CommonPart;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class BlockId {

    private String hash;

    @SerializedName("parts")
    private CommonPart blockIdPart;

}
