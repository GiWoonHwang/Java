package io.rigo.sdk.common.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static java.time.LocalDateTime.now;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeUtils {

    public static long getNanoSecond(LocalDateTime localDateTime) {
        if (localDateTime == null) {
            localDateTime = now();
        }
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        long epochMilli = instant.toEpochMilli();
        int nanoSeconds = localDateTime.getNano();
        return epochMilli * 1_000_000 + nanoSeconds;
    }

    public static LocalDateTime fromNanoSecond(long nanoSecond) {
        long seconds = nanoSecond / 1_000_000_000L;
        int nanoAdjustment = (int) (nanoSecond % 1_000_000_000L);
        LocalDateTime dateTime = LocalDateTime.of(1970, 1, 1, 0, 0, 0);
        dateTime = dateTime.plusSeconds(seconds).plusNanos(nanoAdjustment);
        return dateTime;
    }
}