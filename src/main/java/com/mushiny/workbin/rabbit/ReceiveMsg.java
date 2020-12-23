package com.mushiny.workbin.rabbit;


import com.alibaba.fastjson.JSONObject;
import com.mushiny.workbin.config.RabbitConfigure;
import com.mushiny.workbin.dto.WorkBinTaskDTO;
import com.mushiny.workbin.entity.IntTransportOrder;
import com.mushiny.workbin.entity.InvUnitLoad;
import com.mushiny.workbin.entity.MdStorageBin;
import com.mushiny.workbin.enums.OrderStatusEnum;
import com.mushiny.workbin.enums.OrderTypeEnum;
import com.mushiny.workbin.service.IntTransportOrderService;
import com.mushiny.workbin.service.InvUnitLoadService;
import com.mushiny.workbin.service.MdStorageBinService;
import com.mushiny.workbin.websocket.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.io.IOException;

/**
 * @Description TODO
 * @Package com.mushiny.workbin.rabbit
 * @anthor：wyang
 * @date：2020/9/28
 */
@Component
public class ReceiveMsg {
    private Logger log = LoggerFactory.getLogger(ReceiveMsg.class);

    @Autowired
    private IntTransportOrderService transportOrderService;
    @Autowired
    private InvUnitLoadService unitLoadService;
    @Autowired
    private MdStorageBinService storageBinService;

    @RabbitListener(containerFactory = "highPerformance",
            bindings = @QueueBinding(value = @Queue(value = RabbitConfigure.WCS_TASK_STATUS_CHANGE_QUEUE,
                    durable = "true", autoDelete = "false"),
                    exchange = @Exchange(value = RabbitConfigure.WCS_TASK_STATUS_CHANGE_EXCHANGE, type = ExchangeTypes.TOPIC),
                    key = RabbitConfigure.WCS_TASK_STATUS_CHANGE_KEY))
    public void receiveMsgContent(Message msg) {
        log.info("msg :{}",msg.toString());

        if (msg == null) {
            log.info("mq 接收数据为null");
            return;
        }

        MonitorToteTaskStatusChange change = MQUtil.toObject(msg.getBody(), MonitorToteTaskStatusChange.class);

        IntTransportOrder order = transportOrderService.getByLabelAndBinCode(change.getToteCode(), change.getBinCode());
        log.info("msg binCode:{} , label:{}, 任务状态：{},order id :{} , orderType :{}",change.getBinCode(),change.getToteCode(),order.getId(),order.getOrderType());

        if (change.getStepTaskStatus().equalsIgnoreCase("Finished") && !ObjectUtils.isEmpty(order)) {

            InvUnitLoad unitLoad = unitLoadService.getByLabel(order.getUnitLoadLabel());
            unitLoad.setStorageBinId(order.getDestinationBinId());
            unitLoadService.updateById(unitLoad);

            order.setStatus(OrderStatusEnum.COMPLETE.getValue());

            //TODO 判断出入库类型 是否推送给netty
            transportOrderService.updateStatus(order);

            if (order.getOrderType().equals(OrderTypeEnum.GOODS_IN.getValue())) {

                MdStorageBin targetBin = storageBinService.getById(order.getDestinationBinId());
                WorkBinTaskDTO dto = new WorkBinTaskDTO();
                dto.setStorageCode(targetBin.getCode());
                dto.setLabel(order.getUnitLoadLabel());

                try {
                    WebSocketServer.sendInfo(JSONObject.toJSONString(dto),null);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
