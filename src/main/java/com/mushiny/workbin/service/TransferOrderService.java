package com.mushiny.workbin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mushiny.workbin.dto.TransferOrderDTO;
import com.mushiny.workbin.entity.TransferOrder;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Package com.mushiny.workbin.service
 * @anthor：wyang
 * @date：2020/10/29
 */
public interface TransferOrderService extends IService<TransferOrder> {

    List<TransferOrder> getList(String qrCode);

    List<TransferOrderDTO> getListByCond(Map<String,Object> query);

    void deleteByLabel(List<String> labelList);

    int insert(TransferOrder order);
}
