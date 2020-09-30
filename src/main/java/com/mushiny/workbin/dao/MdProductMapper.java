package com.mushiny.workbin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mushiny.workbin.entity.MdProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MdProductMapper  extends BaseMapper<MdProduct> {

    MdProduct getByCode(@Param("code") String code);
}