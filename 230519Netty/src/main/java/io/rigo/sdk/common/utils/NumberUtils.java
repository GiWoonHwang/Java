package io.rigo.sdk.common.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NumberUtils {

    public static String numberFromByteString(com.google.protobuf.ByteString byteString) {
        return new BigInteger(byteString.toByteArray()).toString(10);
    }

}
