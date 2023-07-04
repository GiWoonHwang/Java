package io.rigo.sdk.subscriber;

import io.rigo.sdk.subscriber.callback.SubscriberCallback;
import io.rigo.sdk.subscriber.client.NettyClient;
import io.rigo.sdk.subscriber.code.DefaultEventType;

/*
NettyClient를 사용하여 WebSocket를 연결을 설정하고 구독을 시작하는 기능을 제공한다.
 */
public class Subscriber {

    private NettyClient nettyClient;

    private String query;

    public Subscriber(String websocketUrl) {
        nettyClient = new NettyClient(websocketUrl); // url을 전달하여 NettyClient를 초기화 한다.
    }

    public void start(DefaultEventType eventType, SubscriberCallback callback) throws InterruptedException {
        this.start(eventType, "", callback);
    }

    public void start(DefaultEventType eventType, String subQuery, SubscriberCallback callback) throws InterruptedException {
        // subQuery를 선택저긍로 받아 이벤트에 대한 추가 정보를 전달한다.
        this.query = eventType.getEvent() + subQuery;
        nettyClient.connect(eventType, subQuery, callback);
    }

    public String getQuery() {
        return this.query;
    }

}
