package com.mushiny.workbin.application.impl;


import com.mushiny.workbin.application.WorkBinAppService;
import com.mushiny.workbin.business.WcsBusiness;
import com.mushiny.workbin.dto.WorkBinTaskDTO;
import com.mushiny.workbin.entity.IntTransportOrder;
import com.mushiny.workbin.entity.InvUnitLoad;
import com.mushiny.workbin.entity.MdProduct;
import com.mushiny.workbin.entity.MdStorageBin;
import com.mushiny.workbin.enums.ActionTypeEnum;
import com.mushiny.workbin.enums.OrderStatusEnum;
import com.mushiny.workbin.enums.OrderTypeEnum;
import com.mushiny.workbin.service.IntTransportOrderService;
import com.mushiny.workbin.service.InvUnitLoadService;
import com.mushiny.workbin.service.MdProductService;
import com.mushiny.workbin.service.MdStorageBinService;
import org.omg.CORBA.ORB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Package com.mushiny.workbin.application.impl
 * @anthor：wyang
 * @date：2020/9/28
 */
@Service
public class WorkBinAppServiceImpl implements WorkBinAppService {
    @Autowired
    private InvUnitLoadService unitLoadService;
    @Autowired
    private IntTransportOrderService transportOrderService;
    @Autowired
    private MdProductService productService;
    @Autowired
    private MdStorageBinService storageBinService;
    @Autowired
    private WcsBusiness wcsBusiness;


    private final static String PERFIX = "TO";
    private final static long start = 00000001l;


    @Override
    public List<InvUnitLoad> getLabelList(String sku) throws Exception {
        return unitLoadService.getListBySku(sku);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int createTask(int type ,WorkBinTaskDTO record) throws Exception {
        String orderNumber = null;

        IntTransportOrder lastOrder = transportOrderService.getLastOrder();
        if (ObjectUtils.isEmpty(lastOrder)) {
            orderNumber = PERFIX + start;
        } else {
            orderNumber = PERFIX + (Long.valueOf(lastOrder.getOrderNumber().substring(2, 10)) + 1);
        }

        if (ObjectUtils.isEmpty(record)) {
            throw new Exception("料箱数据为空");
        }
        IntTransportOrder order = new IntTransportOrder();
        order.setOrderNumber(orderNumber);

        InvUnitLoad load = unitLoadService.getByLabel(record.getLabel());
        if (ObjectUtils.isEmpty(load)) {
            throw new Exception("料箱信息为空");
        }
        order.setUnitLoadLabel(record.getLabel());

        if (type == 1) {
            order.setOrderType(OrderTypeEnum.GOODS_IN.getValue());
            MdStorageBin bin = storageBinService.getByCode(record.getStorageCode());
            if (ObjectUtils.isEmpty(bin)) {
                throw new Exception("库位信息为空");
            }
            order.setSourceBinId(bin.getId());

            MdProduct product = productService.getByCode(record.getProductCode());
            if (ObjectUtils.isEmpty(product)) {
                throw new Exception("商品信息为空");
            }
            load.setProductId(product.getId());
            load.setStorageBinId(bin.getId());
            unitLoadService.updateById(load);

            List<MdStorageBin> availableBin = storageBinService.getAvailableBin();
            if (CollectionUtils.isEmpty(availableBin)) {
                throw new Exception("无可用的库位");
            }
            order.setDestinationBinId(availableBin.get(0).getId());
            //TODO 调用wcs 修改货位料箱接口
            wcsBusiness.wcsUpdateBin(availableBin.get(0).getCode(),record.getLabel());
        }else{
            order.setOrderType(OrderTypeEnum.GOODS_OUT.getValue());
            order.setSourceBinId(load.getStorageBinId());
        }

        order.setStatus(OrderStatusEnum.CREATE.getValue());
        transportOrderService.save(order);

        return 0;
    }

    @Override
    public WorkBinTaskDTO getTaskForOutput(String label) throws Exception {

        Map<String,Object> param  = new HashMap<>();
        param.put("status",OrderStatusEnum.COMPLETE.getValue());
        param.put("label",label);
        param.put("orderType",OrderTypeEnum.GOODS_OUT.getValue());

        List<IntTransportOrder> orderList = transportOrderService.getListByCond(param);
        if(CollectionUtils.isEmpty(orderList)){
            throw new Exception("当前料箱无法出库");
        }


        return new WorkBinTaskDTO().setLabel(orderList.get(0).getUnitLoadLabel())
                    .setPoint(orderList.get(0).getExternalId())
                    .setStorageCode(orderList.get(0).getTargetStorageCode())
                ;
    }

    @Override
    public int output(List<String> labelList) throws Exception {
        transportOrderService.updateByLabel(labelList);
        unitLoadService.updateByLabel(labelList);
        return 0;
    }

    @Override
    public int input(List<String> labelList) throws Exception {
        Map<String,Object> param = new HashMap<>();
        param.put("labelList",labelList);
        List<IntTransportOrder> orderList = transportOrderService.getListByCond(param);

        wcsBusiness.callLabel(ActionTypeEnum.TOTE_RAKE_PUT.name(), orderList);
        return 0;
    }
}
