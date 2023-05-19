/*
질문
1. 채널에 대한 정확한 이해
2. 콜백에 대한 정확한 이해
3. 비동기처리 -> 다중쓰레드 ?
4. keppalive 패킷
 */

package io.rigo.sdk.subscriber.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketClientProtocolHandler;
import io.netty.handler.codec.http.websocketx.WebSocketVersion;
import io.rigo.sdk.common.exception.RigoApiException;
import io.rigo.sdk.subscriber.callback.SubscriberCallback;
import io.rigo.sdk.subscriber.code.DefaultEventType;
import io.rigo.sdk.subscriber.handler.NettyClientHandler;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.net.URI;
import java.net.URISyntaxException;

import static io.netty.handler.codec.http.websocketx.WebSocketClientHandshakerFactory.newHandshaker;

// Netty를 사용하여 WebSocket 클라이언트를 구현
@Slf4j
public class NettyClient {
    private final URI uri; // websocket 서버의 uri 저장

    private EventLoopGroup group; // 네티의 이벤트 루프 그룹이다. 클라이언트 채널의 이벤트를 처리
    private Channel channel; // 클라이언트 채널

    public NettyClient(String websocketUrl) { // 서버의 uri를 전달받아 객체를 생성
        try {
            this.uri = new URI(websocketUrl);
        } catch (URISyntaxException e) {
            throw new RigoApiException("웹소켓 Url 정보를 확인하세요.");
        }
    }

    public void connect(DefaultEventType eventType, SubscriberCallback callback) throws InterruptedException {
        this.connect(eventType, "", callback); // 두 번째 connect 메소드를 호출하여 subQuery 매개변수에 빈 문자열 전달.
    }

    public void connect(DefaultEventType eventType, String subQuery, SubscriberCallback callback) throws InterruptedException {
        /*
        이벤트 루프 그룹을 생성하고, webSocket클라이언트의 설정을 구성한 후 서버에 연결한다.
         */
        group = new NioEventLoopGroup();
        WebSocketClientHandshaker handShaker = newHandshaker(uri, WebSocketVersion.V13, null, true, new DefaultHttpHeaders());
        // Bootstrap 설정
        /*
        부트스트랩은 네티로 작성한 네트워크 어플리케이션이 시작할 때 가장 처음 수행되는 부분으로 어플리케이션이 수행할 동작과 환경을 설정한다
        이벤트 루프: 소켓 채널에서 발생한 이벤트를 처리하는 스레드 모델에 대한 구현
        채널전송모드: 블로킹, 논블로킹, epoll 등 ..
        채널파이프라인: 네티채널과 이벤트 핸들러 사이의 연결통로 소켓채널로 수신된 데이터를 처리할 데이터 핸드러를 지정

         */
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                 .channel(NioSocketChannel.class) // 서버 소켓 채널에서 발생한 이벤트만 처리
                 .option(ChannelOption.SO_KEEPALIVE, true) // keepalive는 연결이 활성 상태인지 확인하기 위해 일정 주기로 패킷을 상대방에게 보내는 기능입니다. 이를 통해 연결이 종료되었거나 네트워크 문제로 인해 연결이 끊어진 경우를 감지할 수 있습니다.
                 .option(ChannelOption.TCP_NODELAY, true) // 한번에 모아 보내 해더를 줄인다 ?
                 .handler(new ChannelInitializer<SocketChannel>() {
                     @Override
                     protected void initChannel(@NotNull SocketChannel ch) {
                         /*
                         소켓 채널이 생성될 때 호출되는 메소드로, 채널 파이프라인을 초기화 한다.
                          */
                         ChannelPipeline pipeline = ch.pipeline();
                         pipeline.addLast(new HttpClientCodec())
                                 .addLast(new HttpObjectAggregator(Integer.MAX_VALUE))
                                 .addLast(new WebSocketClientProtocolHandler(handShaker))
                                 .addLast(new NettyClientHandler(eventType, subQuery, callback));
                     }
                 });
        ChannelFuture future = bootstrap.connect(uri.getHost(), uri.getPort());
        channel = future.channel();
        future.sync();
    }

    public void stop() {
        if (channel != null) {
            channel.close();
        }
        if (group != null) {
            group.shutdownGracefully();
        }
    }

}
