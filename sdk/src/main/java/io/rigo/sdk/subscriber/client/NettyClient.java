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
import java.util.concurrent.TimeUnit;

import static io.netty.handler.codec.http.websocketx.WebSocketClientHandshakerFactory.newHandshaker;

@Slf4j
public class NettyClient {
    private final URI uri;

    private EventLoopGroup group;
    private Channel channel;

    public NettyClient(String websocketUrl) {
        try {
            this.uri = new URI(websocketUrl);
        } catch (URISyntaxException e) {
            throw new RigoApiException("웹소켓 Url 정보를 확인하세요.");
        }
    }

    public void connect(DefaultEventType eventType, SubscriberCallback callback) throws InterruptedException {
        this.connect(eventType, "", callback);
    }

    public void connect(DefaultEventType eventType, String subQuery, SubscriberCallback callback) throws InterruptedException {
        group = new NioEventLoopGroup();
        WebSocketClientHandshaker handShaker = newHandshaker(uri, WebSocketVersion.V13, null, true, new DefaultHttpHeaders());
        // Bootstrap 설정
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                 .channel(NioSocketChannel.class)
                 .option(ChannelOption.SO_KEEPALIVE, true)
                 .option(ChannelOption.TCP_NODELAY, true)
                 .handler(new ChannelInitializer<SocketChannel>() {
                     @Override
                     protected void initChannel(@NotNull SocketChannel ch) {
                         ChannelPipeline pipeline = ch.pipeline();
                         pipeline.addLast(new HttpClientCodec())
                                 .addLast(new HttpObjectAggregator(Integer.MAX_VALUE))
                                 .addLast(new WebSocketClientProtocolHandler(handShaker))
                                 .addLast(new NettyClientHandler(eventType, subQuery, callback));
                     }
                 });
        connect(bootstrap);
    }

    private void connect(Bootstrap bootstrap) throws InterruptedException {
        ChannelFuture future = bootstrap.connect(uri.getHost(), uri.getPort());
        future.addListener((ChannelFutureListener) f -> {
            if (f.isSuccess()) {
                log.info("Connected to server");
            } else {
                log.info("Failed to connect to server, Retrying in 5 seconds...");
                f.channel().eventLoop().schedule(() -> {
                    try {
                        connect(bootstrap);
                    } catch (InterruptedException e) {
                        log.info("interrupt error message : " + e.getMessage());
                        Thread.currentThread().interrupt();
                    }
                }, 1, TimeUnit.SECONDS);
            }
        });
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
