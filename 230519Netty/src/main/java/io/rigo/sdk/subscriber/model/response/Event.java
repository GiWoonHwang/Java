package io.rigo.sdk.subscriber.model.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class Event {
    @SerializedName("tx.hash")
    private List<String> hash;

    @SerializedName("tx.height")
    private List<String> height;

    @SerializedName("tx.type")
    private List<String> type;

    @SerializedName("tx.sender")
    private List<String> sender;

    @SerializedName("tx.receiver")
    private List<String> receiver;

    @SerializedName("tx.addrpair")
    private List<String> addressPair;

    @SerializedName("tm.event")
    private List<String> tmEvent;
}
