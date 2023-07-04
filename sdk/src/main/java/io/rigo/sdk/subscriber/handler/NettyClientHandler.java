package io.rigo.sdk.subscriber.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.rigo.sdk.subscriber.callback.SubscriberCallback;
import io.rigo.sdk.subscriber.code.DefaultEventType;
import io.rigo.sdk.subscriber.model.request.JSONRPCRequest;
import io.rigo.sdk.subscriber.model.request.Params;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static io.rigo.sdk.common.utils.JsonUtils.toJson;

@Slf4j
@RequiredArgsConstructor
public class NettyClientHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private final DefaultEventType eventType;
    private final String subQuery;

    private final SubscriberCallback subscriberCallback;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) {
        String receivedMessage = msg.text();
        subscriberCallback.onReceived(receivedMessage);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        log.info("WebSocket client connected");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        log.info("WebSocket client disconnected");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.info("WebSocket client error");
        log.info(cause.getMessage());
        ctx.close();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        super.userEventTriggered(ctx, evt);
        ctx.writeAndFlush(new TextWebSocketFrame(createJSONRPCRequest()));
    }

    private String createJSONRPCRequest() {
        String query = eventType.getEvent() + this.subQuery;
        JSONRPCRequest jsonrpcRequest = JSONRPCRequest.builder()
                                                      .jsonrpc("2.0")
                                                      .id("dontcare")
                                                      .method("subscribe")
                                                      .params(Params.builder().query(query).build())
                                                      .build();
        return toJson(jsonrpcRequest);
    }

}
