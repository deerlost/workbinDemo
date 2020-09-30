package com.mushiny.workbin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mushiny.workbin.entity.MdStorageBin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MdStorageBinMapper extends BaseMapper<MdStorageBin> {
    MdStorageBin getByCode(@Param("code") String code);

    List<MdStorageBin> getAvailableBin();


}