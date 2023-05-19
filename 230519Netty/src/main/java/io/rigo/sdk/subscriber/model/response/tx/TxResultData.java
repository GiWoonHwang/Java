package io.rigo.sdk.subscriber.model.response.tx;

import com.google.gson.annotations.SerializedName;
import io.rigo.sdk.domain.transaction.model.TransactionEvent;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class TxResultData {
    @SerializedName("gas_wanted")
    private String gasWanted;
    @SerializedName("gas_used")
    private String gasUsed;
    private TransactionEvent events;
}
