package com.mushiny.workbin.application;


import com.mushiny.workbin.dto.InputTaskDTO;
import com.mushiny.workbin.dto.InvUnitLoadDTO;
import com.mushiny.workbin.dto.TransferOrderDTO;
import com.mushiny.workbin.dto.WorkBinTaskDTO;
import com.mushiny.workbin.entity.TransferOrder;
import com.mushiny.workbin.exception.WMSException;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Package com.mushiny.workbin.application
 * @anthor：wyang
 * @date：2020/9/27
 */
public interface WorkBinAppService {

    List<InvUnitLoadDTO> getLabelList(String sku) throws WMSException;

    /**
     * 创建任务
     *
     * @param type   1入库 2出库
     * @param record
     * @return
     * @throws WMSException
     */
    InputTaskDTO createTask(int type, InputTaskDTO record) throws WMSException;

    /**
     * 获取出库信息
     *
     * @param label
     * @return
     * @throws WMSException
     */
    WorkBinTaskDTO getTaskForOutput(String label) throws WMSException;

    int output(String labels) throws WMSException;

    int input(String labels) throws WMSException;

    List<TransferOrder> getTransferOrderList(Map<String,Object> map) throws WMSException;

    List<TransferOrderDTO> getByCond(Map<String,Object> query) throws WMSException;



}
