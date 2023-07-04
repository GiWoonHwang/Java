package io.rigo.sdk.subscriber.model.response.tx;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class TxDataValue {

    @SerializedName("TxResult")
    private TxResult txResult;
}
