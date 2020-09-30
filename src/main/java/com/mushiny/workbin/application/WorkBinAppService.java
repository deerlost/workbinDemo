package com.mushiny.workbin.application;


import com.mushiny.workbin.dto.WorkBinTaskDTO;
import com.mushiny.workbin.entity.InvUnitLoad;

import java.util.List;

/**
 * @Description TODO
 * @Package com.mushiny.workbin.application
 * @anthor：wyang
 * @date：2020/9/27
 */
public interface WorkBinAppService {

    List<InvUnitLoad> getLabelList(String sku) throws Exception;

    /**
     * 创建任务
     *
     * @param type 1入库 2出库
     * @param record
     * @return
     * @throws Exception
     */
    int createTask(int type ,WorkBinTaskDTO record) throws Exception;

    /**
     * 获取出库信息
     *
     * @param label
     * @return
     * @throws Exception
     */
    WorkBinTaskDTO getTaskForOutput(String label) throws Exception;

    int output(List<String> labelList) throws Exception;

    int input(List<String> labelList) throws Exception;


}
