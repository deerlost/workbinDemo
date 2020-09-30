package com.mushiny.workbin.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mushiny.workbin.dao.MdProductMapper;
import com.mushiny.workbin.entity.MdProduct;
import com.mushiny.workbin.service.MdProductService;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Package com.mushiny.workbin.service.impl
 * @anthor：wyang
 * @date：2020/9/27
 */
@Service
public class MdProductServiceImpl extends ServiceImpl<MdProductMapper, MdProduct> implements MdProductService {
    @Override
    public MdProduct getByCode(String code) {
        return baseMapper.getByCode(code);
    }
}
