package com.mushiny.workbin.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mushiny.workbin.dao.IntTransportOrderMapper;
import com.mushiny.workbin.entity.IntTransportOrder;
import com.mushiny.workbin.service.IntTransportOrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Package com.mushiny.workbin.service.impl
 * @anthor：wyang
 * @date：2020/9/27
 */
@Service
public class IntTransportOrderServiceImpl extends ServiceImpl<IntTransportOrderMapper, IntTransportOrder> implements IntTransportOrderService {
    @Override
    public IntTransportOrder getLastOrder() {
        return baseMapper.getLastOrder();
    }

    @Override
    public List<IntTransportOrder> getListByCond(Map<String, Object> param) {
        return baseMapper.getListByCond(param);
    }

    @Override
    public void updateByLabel(List<String> labelList) {
        baseMapper.updateByLabel(labelList);
    }

    @Override
    public IntTransportOrder getByLabelAndBinCode(String label, String binCode) {
        return baseMapper.getByLabelAndBinCode(label,binCode);
    }

    @Override
    public int updateStatus(IntTransportOrder order) {
        return baseMapper.updateStatus(order);
    }
}
