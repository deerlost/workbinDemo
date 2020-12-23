package com.mushiny.workbin.application.impl;


import com.mushiny.workbin.application.WorkBinAppService;
import com.mushiny.workbin.business.WcsBusiness;
import com.mushiny.workbin.dto.InputTaskDTO;
import com.mushiny.workbin.dto.InvUnitLoadDTO;
import com.mushiny.workbin.dto.TransferOrderDTO;
import com.mushiny.workbin.dto.WorkBinTaskDTO;
import com.mushiny.workbin.entity.IntTransportOrder;
import com.mushiny.workbin.entity.InvUnitLoad;
import com.mushiny.workbin.entity.MdStorageBin;
import com.mushiny.workbin.entity.TransferOrder;
import com.mushiny.workbin.enums.OrderStatusEnum;
import com.mushiny.workbin.enums.OrderTypeEnum;
import com.mushiny.workbin.exception.WMSException;
import com.mushiny.workbin.service.IntTransportOrderService;
import com.mushiny.workbin.service.InvUnitLoadService;
import com.mushiny.workbin.service.MdProductService;
import com.mushiny.workbin.service.MdStorageBinService;
import com.mushiny.workbin.service.TransferOrderService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @Description TODO
 * @Package com.mushiny.workbin.application.impl
 * @anthor：wyang
 * @date：2020/9/28
 */
@Service
public class WorkBinAppServiceImpl implements WorkBinAppService {
    private Logger log = LoggerFactory.getLogger(WorkBinAppServiceImpl.class);
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
    @Autowired
    private TransferOrderService transferOrderService;


    private final static String PERFIX = "TO";
    private final static String start = "10000001";


    @Override
    public List<InvUnitLoadDTO> getLabelList(String sku) throws WMSException {
        return unitLoadService.getListBySku(sku);
    }

    @Override
    @Transactional(rollbackFor = WMSException.class)
    public InputTaskDTO createTask(int type , InputTaskDTO dto) throws WMSException {

        for (WorkBinTaskDTO record : dto.getTaskList()) {

            String orderNumber = null;

            IntTransportOrder lastOrder = transportOrderService.getLastOrder();
            if (ObjectUtils.isEmpty(lastOrder)) {
                orderNumber = PERFIX + start;
            } else {
                orderNumber = PERFIX + (Long.valueOf(lastOrder.getOrderNumber().substring(2, 10)) + 1);
            }

            if (ObjectUtils.isEmpty(record)) {
                throw new WMSException("料箱数据为空");
            }
            IntTransportOrder order = new IntTransportOrder();
            order.setOrderNumber(orderNumber);

            InvUnitLoad load = unitLoadService.getByLabel(record.getLabel());
            if (ObjectUtils.isEmpty(load)) {
                InvUnitLoad sourceLabel = unitLoadService.getByLabel("UL-000000320");
                sourceLabel.setLabelId(record.getLabel());
                sourceLabel.setId(null);
                unitLoadService.save(sourceLabel);
                load = sourceLabel;
            }
            order.setUnitLoadLabel(record.getLabel());
            Map<String,Object> param = new HashMap<>();
            IntTransportOrder t = transportOrderService.getByLabelAndBinCode(record.getLabel(),null);
            if(!ObjectUtils.isEmpty(t)){
                order = t;
            }

            if (type == 1) {
                order.setOrderType(OrderTypeEnum.GOODS_IN.getValue());
                MdStorageBin bin = storageBinService.getByCode(record.getStorageCode());
                if (ObjectUtils.isEmpty(bin)) {
                    throw new WMSException("库位信息为空");
                }

                order.setSourceBinId(bin.getId());
                order.setSourceStorageCode(bin.getCode());
           /* MdProduct product = productService.getByCode(record.getProductCode());
            if (ObjectUtils.isEmpty(product)) {
                product = new MdProduct();
                product.setCode(record.getProductCode());
                product.setSku(record.getProductCode());
                product.setName(record.getProductCode());
                productService.save(product);

            }
            load.setProductId(product.getId());*/
                load.setStorageBinId(bin.getId());
                unitLoadService.updateById(load);

                for (TransferOrder transferOrder : record.getOrderList()) {
                    log.debug("transfer order :{}",record.getOrderList().toString());
                    transferOrder.setLabelId(record.getLabel());
                    transferOrderService.insert(transferOrder);
                }


                param.put("binType",20000);
                List<MdStorageBin> availableBin = storageBinService.getAvailableBin(param);
                if (CollectionUtils.isEmpty(availableBin)) {
                    throw new WMSException("无可用的库位");
                }
                order.setDestinationBinId(availableBin.get(0).getId());
                order.setTargetStorageCode(availableBin.get(0).getCode());
                //TODO 调用wcs 修改货位料箱接口
                wcsBusiness.wcsUpdateBin(bin.getCode(),record.getLabel());
            }else{
                order.setOrderType(OrderTypeEnum.GOODS_OUT.getValue());
                order.setSourceBinId(load.getStorageBinId());
                order.setExternalId(record.getPoint());
                //TODO target bin
                param.put("binType",10000);
                List<MdStorageBin> availableBin = storageBinService.getAvailableBin(param);
                /*if (CollectionUtils.isEmpty(availableBin)) {
                    throw new WMSException("无可用的库位");
                }*/
               /* Random random = new Random();
                int pick = random.nextInt(3);
                if (pick > 2) pick = 0;*/
              //  order.setDestinationBinId(availableBin.get(pick).getId());
              //  order.setTargetStorageCode(availableBin.get(pick).getCode());
                transferOrderService.deleteByLabel(Arrays.asList(record.getLabel()));
            }

            order.setStatus(OrderStatusEnum.CREATE.getValue());
            if (!ObjectUtils.isEmpty(t)) {
                transportOrderService.updateById(order);
            } else {
                transportOrderService.save(order);
            }
        }

        return dto;
    }

    @Override
    public WorkBinTaskDTO getTaskForOutput(String label) throws WMSException {

        Map<String,Object> param  = new HashMap<>();
        param.put("status",OrderStatusEnum.COMPLETE.getValue());
        param.put("label",label);
        param.put("orderType",OrderTypeEnum.GOODS_OUT.getValue());

        List<IntTransportOrder> orderList = transportOrderService.getListByCond(param);
        if(CollectionUtils.isEmpty(orderList)){
            throw new WMSException("当前料箱无法出库");
        }

        List<TransferOrderDTO> transferOrderList = transferOrderService.getListByCond(param);


        return new WorkBinTaskDTO().setLabel(orderList.get(0).getUnitLoadLabel())
                    .setPoint(orderList.get(0).getExternalId())
                    .setStorageCode(orderList.get(0).getTargetStorageCode())
                    .setOrderList(transferOrderList);
    }

    @Override
    public int output(String labels) throws WMSException {
        for (String label : labels.split(",")) {
            Map<String,Object> param = new HashMap<>();
            param.put("status",30);
            param.put("label",label);
            param.put("orderType",OrderTypeEnum.GOODS_OUT.getValue());
            List<IntTransportOrder> order = transportOrderService.getListByCond(param);
            //TODO 调用wcs 修改货位料箱接口
            wcsBusiness.wcsUpdateBin(order.get(0).getTargetStorageCode(),"");
        }
        transportOrderService.updateByLabel(Arrays.asList(labels.split(",")));
        unitLoadService.updateByLabel(Arrays.asList(labels.split(",")));
        transferOrderService.deleteByLabel(Arrays.asList(labels.split(",")));
        return 0;
    }

    @Override
    public int input(String labels) throws WMSException {
        Map<String,Object> param = new HashMap<>();
        param.put("labelList",Arrays.asList(labels.split(",")));
        param.put("orderType",OrderTypeEnum.GOODS_IN.getValue());
        param.put("status",OrderStatusEnum.CREATE.getValue());
        List<IntTransportOrder> orderList = transportOrderService.getListByCond(param);

        if(CollectionUtils.isEmpty(orderList)) throw new WMSException("料箱无待执行的任务");
        wcsBusiness.callLabel(orderList);
        return 0;
    }

    @Override
    public List<TransferOrder> getTransferOrderList(Map<String,Object> map) throws WMSException {
        String qrCode = map.get("qrCode").toString();
        List<TransferOrder> result = new ArrayList<>();

        if(!qrCode.startsWith("V5")){
            List<TransferOrder> orderList = transferOrderService.getList(qrCode);
            result.addAll(orderList);
        } else {
            TransferOrder order = new TransferOrder();
            String[] split = qrCode.split("\\[\\]");
            order.setCountryNo("");
            order.setPoNo(split[2]);
            order.setPsize(split[7]);
            order.setStyleNo(split[13]);
            order.setSumQty(Integer.valueOf(split[8]));
            order.setTableNo(split[4]);
            order.setColour(split[24]);
            result.add(order);
        }
        return result;
    }

    @Override
    public List<TransferOrderDTO> getByCond(Map<String,Object> query) throws WMSException {
        List<TransferOrderDTO> result = transferOrderService.getListByCond(query);
        if(CollectionUtils.isEmpty(result)){
            throw new WMSException("结果为空,请重新查询");
        }
        return result;
    }
}
