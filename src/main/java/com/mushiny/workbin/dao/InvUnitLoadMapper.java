package com.mushiny.workbin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mushiny.workbin.dto.InvUnitLoadDTO;
import com.mushiny.workbin.entity.InvUnitLoad;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface InvUnitLoadMapper extends BaseMapper<InvUnitLoad> {

    List<InvUnitLoad> getLabelListOnOutputPod();

    List<InvUnitLoadDTO> getListBySku(@Param("sku") String sku);

    InvUnitLoad getByLabel(@Param("label")String label);

    void updateByLabel(@Param("labelList")List<String> labelList);
}