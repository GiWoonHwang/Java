package io.rigo.sdk.common.utils;

import io.rigo.sdk.proto.TrxPb;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TrxPbUtils {

    @SneakyThrows
    public static TrxPb.TrxProto decodeToTrxProto(byte[] data) {
        return TrxPb.TrxProto.parseFrom(data);
    }

    @SneakyThrows
    public static TrxPb.TrxPayloadUnstakingProto decodeTrxPayloadUnstakingProto(byte[] data) {
        return TrxPb.TrxPayloadUnstakingProto.parseFrom(data);
    }

}
