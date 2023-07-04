package io.rigo.sdk.common.utils;

import java.time.LocalDateTime;

import static io.rigo.sdk.common.utils.TimeUtils.fromNanoSecond;
import static java.time.LocalDateTime.now;

public class TimeUtilsTest {

    public static void main(String[] args) {
        LocalDateTime now = now();
        long nanoSeconds = 1683003388739000000L;
        System.out.println("nanoSeconds: " + nanoSeconds);
        LocalDateTime dateTime = fromNanoSecond(nanoSeconds);
        System.out.println("Converted LocalDateTime: " + dateTime);
    }

}
