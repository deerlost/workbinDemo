package com.mushiny.workbin.netty;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.concurrent.TimeUnit;

/**
 * @Description TODO
 * @ClassName：LiveServer :
 * @Package com.inossem.wms.netty
 * @anthor：wyang
 * @date：2019/11/4
 * @版本：V1.0
 */
public class LiveServer  implements ServletContextListener{

    private static Logger logger = LoggerFactory.getLogger(LiveServer.class);
    private static final int READ_IDEL_TIME_OUT = 10; // 读超时
    private static final int WRITE_IDEL_TIME_OUT = 0;// 写超时
    private static final int ALL_IDEL_TIME_OUT = 0; // 所有超时

    LiveServerHandler liveServerHandler;

    private int port;

    public LiveServer(int port) {
        this.port = port;
    }

   // @PostConstruct
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContextEvent.getServletContext());
        this.liveServerHandler = (LiveServerHandler) applicationContext.getBean("liveServerHandler");
        logger.info("===============netty server start===============");
        ServerBootstrap b = new ServerBootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();
        b.group(group)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 128)
                // 不延迟，直接发送
                .childOption(ChannelOption.TCP_NODELAY, Boolean.TRUE)
                // 保持长连接状态
                .childOption(ChannelOption.SO_KEEPALIVE, Boolean.TRUE)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel ch)
                            throws Exception {
                        logger.info("initChannel ch:" + ch);
                        ch.pipeline()
                                .addLast(new StringDecoder(CharsetUtil.UTF_8))   // 1
                                .addLast(new StringDecoder(CharsetUtil.UTF_8))  // 2
                                .addLast(new IdleStateHandler(READ_IDEL_TIME_OUT, WRITE_IDEL_TIME_OUT, ALL_IDEL_TIME_OUT, TimeUnit.SECONDS))// 3
                                .addLast(liveServerHandler)// 4
                                .addLast(new LengthFieldBasedFrameDecoder(20*1024,0,2));
                    }
                })
                .bind(port)
                .addListener((ChannelFutureListener) future -> {
                    if (future.isSuccess()) {
                        logger.info("netty server start success");
                    } else {
                        logger.info("netty server start failed");
                    }
                });
    }



    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
