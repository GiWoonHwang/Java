package io.rigo.sdk.domain.transaction.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class Transaction {
    private String hash;
    private String height;
    private long index;
    @SerializedName("tx_result")
    private TransactionResult transactionResult;
    private String tx;
}
