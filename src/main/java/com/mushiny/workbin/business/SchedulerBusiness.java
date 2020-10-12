package com.mushiny.workbin.business;


import com.mushiny.workbin.entity.IntTransportOrder;
import com.mushiny.workbin.entity.InvUnitLoad;
import com.mushiny.workbin.enums.OrderStatusEnum;
import com.mushiny.workbin.enums.OrderTypeEnum;
import com.mushiny.workbin.exception.WMSException;
import com.mushiny.workbin.service.IntTransportOrderService;
import com.mushiny.workbin.service.InvUnitLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Package com.mushiny.workbin.business
 * @anthor：wyang
 * @date：2020/9/27
 */
@Component
public class SchedulerBusiness {

    @Autowired
    private InvUnitLoadService unitLoadService;
    @Autowired
    private WcsBusiness wcsBusiness;
    @Autowired
    private IntTransportOrderService transportOrderService;

    //@Scheduled(fixedDelay = 1000 * 10)
    public void callToOutput() {
        List<InvUnitLoad> unitLoadList = unitLoadService.getLabelListOnOutputPod();

        if (CollectionUtils.isEmpty(unitLoadList)) {
            //TODO 向wcs发送指令，搬运料箱出库

            Map<String, Object> param = new HashMap<>();
            param.put("orderType", OrderTypeEnum.GOODS_OUT.getValue());
            param.put("status", OrderStatusEnum.CREATE.getValue());
            List<IntTransportOrder> orderList = transportOrderService.getListByCond(param);

            if (!CollectionUtils.isEmpty(orderList)) {
                wcsBusiness.callLabel(orderList);
            }
        }
    }

    //@Scheduled(cron = "0 0 0/1 * * ?")
    public void updateStorageInfo() {
        try {
            wcsBusiness.queryBinInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
