package io.rigo.sdk.common.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Base64;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Base64Utils {

    public static byte[] bytesFromBase64(String value) {
        return Base64.getDecoder().decode(value);
    }

    public static String base64FromBytes(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }

}
