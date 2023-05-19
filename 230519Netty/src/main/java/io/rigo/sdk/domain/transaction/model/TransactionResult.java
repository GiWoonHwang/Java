package io.rigo.sdk.domain.transaction.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class TransactionResult {
    private int code;
    private String data;
    private String log;
    private String info;
    @SerializedName("gas_wanted")
    private String gasWanted;
    @SerializedName("gas_used")
    private String gasUsed;
    private List<TransactionEvent> events;
    @SerializedName("codespace")
    private String codeSpace;
}
