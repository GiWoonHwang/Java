package io.rigo.sdk.domain.block.model.block;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class BlockData {


    private List<String> txs;
}
