package com.mushiny.workbin.business;


import com.mushiny.workbin.entity.IntTransportOrder;
import com.mushiny.workbin.entity.InvUnitLoad;
import com.mushiny.workbin.entity.MdStorageBin;
import com.mushiny.workbin.enums.OrderStatusEnum;
import com.mushiny.workbin.enums.OrderTypeEnum;
import com.mushiny.workbin.service.IntTransportOrderService;
import com.mushiny.workbin.service.InvUnitLoadService;
import com.mushiny.workbin.service.MdStorageBinService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Package com.mushiny.workbin.business
 * @anthor：wyang
 * @date：2020/9/27
 */
@Component
public class SchedulerBusiness {
    private Logger log = LoggerFactory.getLogger(SchedulerBusiness.class);
    @Autowired
    private InvUnitLoadService unitLoadService;
    @Autowired
    private WcsBusiness wcsBusiness;
    @Autowired
    private IntTransportOrderService transportOrderService;
    @Autowired
    private MdStorageBinService storageBinService;


   // @Scheduled(fixedDelay = 1000 * 10)
    public void callToOutput() {
        List<InvUnitLoad> unitLoadList = unitLoadService.getLabelListOnOutputPod();

        log.info("定时查询出库库位状态，unitLoadList : {}", unitLoadList.toString());
        if (CollectionUtils.isEmpty(unitLoadList)) {
            //TODO 向wcs发送指令，搬运料箱出库

            Map<String, Object> param = new HashMap<>();
            param.put("orderType", OrderTypeEnum.GOODS_OUT.getValue());
            param.put("status", OrderStatusEnum.CREATE.getValue());
            List<IntTransportOrder> orderList = transportOrderService.getListByCond(param);

            if (!CollectionUtils.isEmpty(orderList)) {
                log.info("向wcs发送指令，搬运料箱出库");
                List<IntTransportOrder> callList = new ArrayList<>();
                param.put("binType", 10000);
                List<MdStorageBin> availableBin = storageBinService.getAvailableBin(param);
                int aSize = availableBin.size();
                int oSize = orderList.size()-1;
                for (int i = 0; i < aSize && oSize >= 0; i++) {
                    IntTransportOrder order = orderList.get(i);
                    order.setDestinationBinId(availableBin.get(i).getId());
                    order.setTargetStorageCode(availableBin.get(i).getCode());
                    order.setStatus(OrderStatusEnum.PROCESS.getValue());
                    transportOrderService.updateById(order);
                    callList.add(order);
                    oSize--;
                }
                wcsBusiness.callLabel(callList);
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
