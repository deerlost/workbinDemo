package com.mushiny.workbin.business;


import com.mushiny.workbin.entity.InvUnitLoad;
import com.mushiny.workbin.service.InvUnitLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @Description TODO
 * @Package com.mushiny.workbin.business
 * @anthor：wyang
 * @date：2020/9/27
 */
@Component
public class SchedulerBusiness {

    @Autowired
    private InvUnitLoadService unitLoadService;
    @Autowired
    private WcsBusiness wcsBusiness;


    public void callToOutput() {
        List<InvUnitLoad> unitLoadList = unitLoadService.getLabelListOnOutputPod();

        if (CollectionUtils.isEmpty(unitLoadList)) {
            //TODO 向wcs发送指令，搬运料箱出库
        }
    }


    public void updateStorageInfo() {
        try {
            wcsBusiness.queryBinInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
