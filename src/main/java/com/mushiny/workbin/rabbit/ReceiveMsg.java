package com.mushiny.workbin.rabbit;


import com.mushiny.workbin.config.RabbitConfigure;
import com.mushiny.workbin.entity.IntTransportOrder;
import com.mushiny.workbin.entity.InvUnitLoad;
import com.mushiny.workbin.enums.OrderStatusEnum;
import com.mushiny.workbin.service.IntTransportOrderService;
import com.mushiny.workbin.service.InvUnitLoadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    @RabbitListener(containerFactory = "rabbitListenerContainerFactory",
            bindings = @QueueBinding(
                    value = @Queue(value = RabbitConfigure.WCS_TASK_STATUS_CHANGE_QUEUE, durable = "true", autoDelete="true"),
                    exchange = @Exchange(value = RabbitConfigure.WCS_TASK_STATUS_CHANGE_EXCHANGE, type = ExchangeTypes.TOPIC),
                    key=RabbitConfigure.WCS_TASK_STATUS_CHANGE_KEY))
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


        }

    }

}
