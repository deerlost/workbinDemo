package com.mushiny.workbin.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.mushiny.workbin.entity.MdStorageBin;

import java.util.List;

/**
 * @Description TODO
 * @Package com.mushiny.workbin.service
 * @anthor：wyang
 * @date：2020/9/27
 */
public interface MdStorageBinService extends IService<MdStorageBin> {

    MdStorageBin getByCode(String code);

    List<MdStorageBin> getAvailableBin();
}
