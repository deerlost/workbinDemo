package com.mushiny.workbin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mushiny.workbin.dto.InvUnitLoadDTO;
import com.mushiny.workbin.entity.InvUnitLoad;

import java.util.List;

/**
 * @Description TODO
 * @Package com.mushiny.workbin.service
 * @anthor：wyang
 * @date：2020/9/27
 */
public interface InvUnitLoadService extends IService<InvUnitLoad> {

    List<InvUnitLoad> getLabelListOnOutputPod();

    List<InvUnitLoadDTO> getListBySku(String sku);

    InvUnitLoad getByLabel(String label);

    void updateByLabel(List<String> labelList);

}
