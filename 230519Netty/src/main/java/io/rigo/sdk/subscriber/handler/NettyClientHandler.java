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
/*
채널의 활성화 및 비활설화, 예외 처리 등을 담당한다.
WebSocket 연결에서 발생하는 이벤트를 처리하고, 수신된 메시지를 subscriberCallback을 통해 외부로 전달한다.
NettyClient에서 사용되는 채널 파이프라인에 추가되어 동작한다.
 */
@Slf4j
@RequiredArgsConstructor
public class NettyClientHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    private final DefaultEventType eventType;
    private final String subQuery;

    private final SubscriberCallback subscriberCallback;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) {
        /*
        WebSocket 프레임을 수신하면 해당 메서드가 호출된다. 프레임 내용을 TextWebSocketFrame을 호출하여 수신된 메세지를 처리한다.
         */
        String receivedMessage = msg.text();
        subscriberCallback.onReceived(receivedMessage);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        /*
        채널이 활성화 되었을 때 호출
         */
        super.channelActive(ctx);
        log.info("WebSocket client connected");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        /*
        채널이 비활성화 되었을 때
         */
        log.info("WebSocket client disconnected");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.info("WebSocket client error");
        ctx.close();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        /*
        사용자 정의 이벤트가 트리거 될 때 호출,
        TextWebSocketFrame을 생성하고 채널로 전송하여 JSON-RPC 요청을 수행
        생성된 JSON-RPC 요청은 이벤트 유형 및 subQuery 정보를 바탕으로 구성됩니다.
         */
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
