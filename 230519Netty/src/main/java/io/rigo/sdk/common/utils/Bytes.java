package io.rigo.sdk.common.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Base64;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Bytes {

    public static byte[] b64ToBytes(String base64) {
        byte[] binaryString = Base64.getDecoder().decode(base64);
        return Arrays.copyOf(binaryString, binaryString.length);
    }

    public static byte[] fromHex(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4) + Character.digit(hex.charAt(i+1), 16));
        }
        return data;
    }

    public static String toHex(byte[] bytes){
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b&0xff));
        }
        return sb.toString().toLowerCase();
    }

}
