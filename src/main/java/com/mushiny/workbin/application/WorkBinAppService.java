package com.mushiny.workbin.application;


import com.mushiny.workbin.dto.WorkBinTaskDTO;
import com.mushiny.workbin.entity.InvUnitLoad;
import com.mushiny.workbin.exception.WMSException;

import java.util.List;

/**
 * @Description TODO
 * @Package com.mushiny.workbin.application
 * @anthor：wyang
 * @date：2020/9/27
 */
public interface WorkBinAppService {

    List<InvUnitLoad> getLabelList(String sku) throws WMSException;

    /**
     * 创建任务
     *
     * @param type 1入库 2出库
     * @param record
     * @return
     * @throws WMSException
     */
    WorkBinTaskDTO createTask(int type ,WorkBinTaskDTO record) throws WMSException;

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


}
