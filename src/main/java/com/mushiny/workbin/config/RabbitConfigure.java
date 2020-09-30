package com.mushiny.workbin.config;


import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Package com.mushiny.workbin.rabbit
 * @anthor：wyang
 * @date：2020/9/28
 */
@Configuration
public class RabbitConfigure {

    // 队列名称
    public final static String WCS_TASK_STATUS_CHANGE_QUEUE = "wcs-task-status-change-queue";

    public final static String WCS_TASK_STATUS_CHANGE_EXCHANGE = "amq.topic";

    public final static String WCS_TASK_STATUS_CHANGE_KEY = "tote.task.status.change.s";
}
