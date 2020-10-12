package com.mushiny.workbin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mushiny.workbin.entity.IntTransportOrder;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Package com.mushiny.workbin.service
 * @anthor：wyang
 * @date：2020/9/27
 */
public interface IntTransportOrderService extends IService<IntTransportOrder> {

    IntTransportOrder getLastOrder();

    List<IntTransportOrder> getListByCond(Map<String,Object> param);

    void updateByLabel(List<String> labelList);

    IntTransportOrder getByLabelAndBinCode(String label, String binCode);

    int updateStatus(IntTransportOrder order);

}
