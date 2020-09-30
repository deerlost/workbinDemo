package com.mushiny.workbin.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mushiny.workbin.dao.MdStorageBinMapper;
import com.mushiny.workbin.entity.MdStorageBin;
import com.mushiny.workbin.service.MdStorageBinService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description TODO
 * @Package com.mushiny.workbin.service.impl
 * @anthor：wyang
 * @date：2020/9/27
 */
@Service
public class MdStorageBinServiceImpl extends ServiceImpl<MdStorageBinMapper, MdStorageBin> implements MdStorageBinService {
    @Override
    public MdStorageBin getByCode(String code) {
        return baseMapper.getByCode(code);
    }

    @Override
    public List<MdStorageBin> getAvailableBin() {
        return baseMapper.getAvailableBin();
    }
}
