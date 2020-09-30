package com.mushiny.workbin.netty;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletContextListener;

/**
 * @Description TODO
 * @ClassName：WmsNettyConfig :
 * @Package com.inossem.wms.netty
 * @anthor：wyang
 * @date：2019/11/4
 * @版本：V1.0
 */
//ty@Configuration
public class WmsNettyConfig {


    @Value("${netty.port}")
    private int port;

    @Bean
    public ServletListenerRegistrationBean<ServletContextListener> getServletListenerRegistrationBean() {
        System.out.println("初始化 Listener=================");
       // ServletListenerRegistrationBean<ServletContextListener> bean = new ServletListenerRegistrationBean<ServletContextListener>(new LiveServer(port));
        return null;
    }

}
