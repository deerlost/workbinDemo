package com.mushiny.workbin.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mushiny.workbin.dao.InvUnitLoadMapper;
import com.mushiny.workbin.entity.InvUnitLoad;
import com.mushiny.workbin.service.InvUnitLoadService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Package com.mushiny.workbin.service.impl
 * @anthor：wyang
 * @date：2020/9/27
 */
@Service
public class InvUnitLoadServiceImpl extends ServiceImpl<InvUnitLoadMapper, InvUnitLoad> implements InvUnitLoadService {
    @Override
    public List<InvUnitLoad> getLabelListOnOutputPod() {
        return baseMapper.getLabelListOnOutputPod();
    }

    @Override
    public List<InvUnitLoad> getListBySku(String sku) {
        return baseMapper.getListBySku(sku);
    }

    @Override
    public InvUnitLoad getByLabel(String label) {
        return baseMapper.getByLabel(label);
    }

    @Override
    public void updateByLabel(List<String> labelList) {
        baseMapper.updateByLabel(labelList);
    }
}
