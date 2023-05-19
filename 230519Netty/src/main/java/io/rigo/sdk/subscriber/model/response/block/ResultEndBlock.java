package io.rigo.sdk.subscriber.model.response.block;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class ResultEndBlock {

    @SerializedName("validator_updates")
    private List<Object> validatorUpdates;

}
