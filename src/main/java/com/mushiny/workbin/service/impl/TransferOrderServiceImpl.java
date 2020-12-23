package com.mushiny.workbin.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mushiny.workbin.config.annotation.TargetDataSource;
import com.mushiny.workbin.dao.TransferOrderMapper;
import com.mushiny.workbin.dto.TransferOrderDTO;
import com.mushiny.workbin.entity.TransferOrder;
import com.mushiny.workbin.service.TransferOrderService;
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
public class TransferOrderServiceImpl extends ServiceImpl<TransferOrderMapper, TransferOrder> implements TransferOrderService {
    @Override
    @TargetDataSource(name="secondary")
    public List<TransferOrder> getList(String qrCode) {
        return baseMapper.getList(qrCode);
    }

    @Override
    public List<TransferOrderDTO> getListByCond(Map<String,Object> query) {
        return baseMapper.getListByCond(query);
    }

    @Override
    public void deleteByLabel(List<String> labelList) {

        baseMapper.deleteByLabel(labelList);
    }

    @Override
    public int insert(TransferOrder order) {
        return baseMapper.insertSelective(order);
    }

}
