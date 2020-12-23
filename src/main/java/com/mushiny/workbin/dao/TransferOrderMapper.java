package com.mushiny.workbin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mushiny.workbin.dto.TransferOrderDTO;
import com.mushiny.workbin.entity.TransferOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TransferOrderMapper extends BaseMapper<TransferOrder> {

    int insertSelective(TransferOrder record);

    List<TransferOrder> getList(@Param("code") String qrCode);

    List<TransferOrderDTO> getListByCond(Map<String,Object> query);

    void deleteByLabel(@Param("labelList") List<String> labelList);
}