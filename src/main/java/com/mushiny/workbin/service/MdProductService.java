package com.mushiny.workbin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mushiny.workbin.entity.MdProduct;

/**
 * @Description TODO
 * @Package com.mushiny.workbin.service
 * @anthor：wyang
 * @date：2020/9/27
 */
public interface MdProductService extends IService<MdProduct> {

    MdProduct getByCode(String code);
}
