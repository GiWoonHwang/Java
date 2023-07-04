package io.rigo.sdk.subscriber;

import io.rigo.sdk.subscriber.callback.SubscriberCallback;
import io.rigo.sdk.subscriber.client.NettyClient;
import io.rigo.sdk.subscriber.code.DefaultEventType;

public class Subscriber {

    private NettyClient nettyClient;

    private String query;

    public Subscriber(String websocketUrl) {
        nettyClient = new NettyClient(websocketUrl);
    }

    public void start(DefaultEventType eventType, SubscriberCallback callback) throws InterruptedException {
        this.start(eventType, "", callback);
    }

    public void start(DefaultEventType eventType, String subQuery, SubscriberCallback callback) throws InterruptedException {
        this.query = eventType.getEvent() + subQuery;
        nettyClient.connect(eventType, subQuery, callback);
    }

    public String getQuery() {
        return this.query;
    }

}
