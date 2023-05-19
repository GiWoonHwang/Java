package io.rigo.sdk.common.utils;

import static io.rigo.sdk.common.utils.Bytes.fromHex;
import static io.rigo.sdk.common.utils.Bytes.toHex;

public class BytesTest {

    public static void main(String[] args) {
        String hexString = "01020304FF11";
        byte[] byteArray = fromHex(hexString);
        System.out.println(byteArray);
        System.out.println(toHex(byteArray));
    }

}
