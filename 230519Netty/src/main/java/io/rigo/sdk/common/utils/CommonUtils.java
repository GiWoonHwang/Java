package io.rigo.sdk.common.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonUtils {

    public static String validPrefix(String value) {
        if (value.startsWith("0x")) {
            return value;
        }
        return "0x" + value;
    }
}