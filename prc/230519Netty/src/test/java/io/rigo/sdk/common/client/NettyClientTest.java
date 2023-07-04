package io.rigo.sdk.common.client;

import io.rigo.sdk.subscriber.callback.SubscriberCallback;
import io.rigo.sdk.subscriber.client.NettyClient;
import io.rigo.sdk.subscriber.Subscriber;
import io.rigo.sdk.subscriber.code.DefaultEventType;

public class NettyClientTest {

    public static void main(String[] args) {
        //String uri = "ws://192.168.252.51:4000";
        //String uri = "ws://127.0.0.1:26657/websocket";
        String uri = "ws://192.168.252.60:26657/websocket";

        DefaultEventType eventType = DefaultEventType.NEW_BLOCK;

        SubscriberCallback callback = (message) -> {
            System.out.println(message);
        };
        Subscriber client;
        try {
            client = new Subscriber(uri);
            client.start(eventType, callback);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
