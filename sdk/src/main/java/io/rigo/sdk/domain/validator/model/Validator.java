package io.rigo.sdk.domain.validator.model;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class Validator {
    @SerializedName("block_height")
    private String blockHeight;
    private List<ValidatorInfo> validators;
    private String count;
    private String total;
}
