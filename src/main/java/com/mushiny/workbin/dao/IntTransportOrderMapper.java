package com.mushiny.workbin.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mushiny.workbin.entity.IntTransportOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface IntTransportOrderMapper extends BaseMapper<IntTransportOrder> {
    IntTransportOrder getLastOrder();

    List<IntTransportOrder> getListByCond(Map<String, Object> param);

    void updateByLabel(List<String> labelList);

    IntTransportOrder getByLabelAndBinCode(String label, String binCode);

    int updateStatus(IntTransportOrder order);

}