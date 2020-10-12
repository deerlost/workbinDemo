package com.mushiny.workbin.netty;


import com.alibaba.fastjson.JSONObject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description TODO
 * @ClassName：LiveServerHandler :
 * @Package com.inossem.wms.netty
 * @anthor：wyang
 * @date：2019/11/4
 * @版本：V1.0
 */
@Component
@ChannelHandler.Sharable
public class LiveServerHandler extends SimpleChannelInboundHandler<String> {

    private static Logger logger = LoggerFactory.getLogger(LiveServerHandler.class);

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        // Channel失效，从Map中移除
        LiveChannnelHolder.remove(ctx.channel());
        logger.info("{}离线", ctx.channel());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        logger.info("{}上线", ctx.channel());
        super.channelActive(ctx);
    }


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

        String temp = msg.toLowerCase();
        Channel channel = ctx.channel();
        final int hashCode = channel.hashCode();
        Map<String, Channel> channelCache = LiveChannnelHolder.getChannelCache();

        logger.info("channel hashCode:" + hashCode + " msg:" + msg + " cache:" + channelCache.size());

        if (!channelCache.containsKey(temp) && !temp.equals("")) {
            //  logger.info("channelCache.containsKey(hashCode), put key:" + hashCode);
           /* channel.closeFuture().addListener(future -> {
                logger.info("channel close, remove key:" + temp);
                LiveChannnelHolder.remove(temp);
            });*/
            LiveChannnelHolder.add(temp, ctx.channel());
            Channel currentChannel = channelCache.get(temp);
            JSONObject result = new JSONObject();
            result.put("msg","1");
            currentChannel.writeAndFlush(result);
            logger.info("发送信息 ：{}" ,result.toString());
        } else {
            Channel currentChannel = channelCache.get(temp);
            currentChannel.writeAndFlush("msg");
        }

    }


    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        Map<String, Channel> channelCache = LiveChannnelHolder.getChannelCache();
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            String type = "";
            if (event.state() == IdleState.READER_IDLE) {
                type = "read idle";
                Channel channel = ctx.channel();
                JSONObject result = new JSONObject();
                result.put("msg","1");
                channel.writeAndFlush(result);
                channel.close();
                System.out.println("channel 关闭后");
            } else if (event.state() == IdleState.WRITER_IDLE) {
                type = "write idle";
            } else if (event.state() == IdleState.ALL_IDLE) {
                type = "all idle";
                System.out.println("channel 读写空闲, 准备关闭当前channel  , 当前UsersChanel的数量: "+channelCache.keySet().size());
                Channel channel = ctx.channel();
                channel.close();
                System.out.println("channel 关闭后");
            }
            logger.info(ctx.channel().remoteAddress() + "超时类型：" + type);
            ctx.fireChannelRead(type);
            ctx.writeAndFlush(type);
        } else {
            super.userEventTriggered(ctx, evt);
        }

    }
}
