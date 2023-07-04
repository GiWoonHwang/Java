package io.rigo.sdk.subscriber.code;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Websocket default message
 */
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public enum DefaultEventType {
    NEW_BLOCK("tm.event = 'NewBlock'"),
    NEW_BLOCK_HEADER("tm.event = 'NewBlockHeader'"),
    TX("tm.event = 'Tx'");

    @Getter
    private String event;

}
