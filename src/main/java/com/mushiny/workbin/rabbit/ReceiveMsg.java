package com.mushiny.workbin.rabbit;


import com.alibaba.fastjson.JSON;
import com.mushiny.workbin.config.RabbitConfigure;
import com.mushiny.workbin.dto.WorkBinTaskDTO;
import com.mushiny.workbin.entity.IntTransportOrder;
import com.mushiny.workbin.entity.InvUnitLoad;
import com.mushiny.workbin.entity.MdStorageBin;
import com.mushiny.workbin.enums.OrderStatusEnum;
import com.mushiny.workbin.enums.OrderTypeEnum;
import com.mushiny.workbin.netty.LiveChannnelHolder;
import com.mushiny.workbin.service.IntTransportOrderService;
import com.mushiny.workbin.service.InvUnitLoadService;
import com.mushiny.workbin.service.MdStorageBinService;
import io.netty.channel.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description TODO
 * @Package com.mushiny.workbin.rabbit
 * @anthor：wyang
 * @date：2020/9/28
 */
@Component
@Slf4j
public class ReceiveMsg {

    @Autowired
    private IntTransportOrderService transportOrderService;
    @Autowired
    private InvUnitLoadService unitLoadService;
    @Autowired
    private MdStorageBinService storageBinService;

    @RabbitListener(containerFactory = "rabbitListenerContainerFactory", bindings = @QueueBinding(value = @Queue(value = RabbitConfigure.WCS_TASK_STATUS_CHANGE_QUEUE, durable = "true", autoDelete = "true"), exchange = @Exchange(value = RabbitConfigure.WCS_TASK_STATUS_CHANGE_EXCHANGE, type = ExchangeTypes.TOPIC), key = RabbitConfigure.WCS_TASK_STATUS_CHANGE_KEY))
    public void receiveMsgContent(MonitorToteTaskStatusChange msg) {
        if (msg == null) {
            log.info("mq 接收数据为null");
            return;
        }

        IntTransportOrder order = transportOrderService.getByLabelAndBinCode(msg.getToteCode(), msg.getBinCode());

        if (msg.getStepTaskStatus().equalsIgnoreCase("Finished")) {

            InvUnitLoad unitLoad = unitLoadService.getByLabel(order.getUnitLoadLabel());
            unitLoad.setStorageBinId(order.getDestinationBinId());
            unitLoadService.updateById(unitLoad);

            order.setStatus(OrderStatusEnum.COMPLETE.getValue());


            //TODO 判断出入库类型 是否推送给netty
            transportOrderService.updateById(order);

            if (order.getOrderType().equals(OrderTypeEnum.GOODS_OUT.getValue())) {

                MdStorageBin targetBin = storageBinService.getById(order.getDestinationBinId());
                WorkBinTaskDTO dto = new WorkBinTaskDTO();
                dto.setStorageCode(targetBin.getCode());
                dto.setLabel(order.getUnitLoadLabel());

                Map<String, Channel> channelMap = LiveChannnelHolder.getChannelCache();
                for (Map.Entry<String, Channel> entry : channelMap.entrySet()) {
                    entry.getValue().writeAndFlush(JSON.toJSONString(dto));
                }
            }
        }

    }

}
