package com.mushiny.workbin.controller;


import com.mushiny.workbin.application.WorkBinAppService;
import com.mushiny.workbin.dto.WorkBinTaskDTO;
import com.mushiny.workbin.entity.InvUnitLoad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description TODO
 * @Package com.mushiny.workbin.controller
 * @anthor：wyang
 * @date：2020/9/27
 */
@RestController
public class WorkBinController {

    @Autowired
    private WorkBinAppService workBinAppService;

    /**
     * 入库绑定库位
     *
     * @param record
     * @return
     * @throws Exception
     */
    @PostMapping("/createInput")
    public int createInput(@RequestBody WorkBinTaskDTO record) throws Exception {
        return workBinAppService.createTask(1, record);
    }

    /**
     * 入库 呼叫
     *
     * @param labels
     * @return
     * @throws Exception
     */
    @GetMapping("/input")
    public int input(@RequestParam("labels") String labels) throws Exception {
        return workBinAppService.input(labels);
    }

    /**
     * 产线呼叫 获取料箱信息
     *
     * @param sku
     * @return
     * @throws Exception
     */
    @GetMapping("/getLabel")
    public List<InvUnitLoad> getLabel(@RequestParam("sku") String sku) throws Exception {
        return workBinAppService.getLabelList(sku);
    }

    /**
     * 产线呼叫 下发出库任务
     *
     * @param record
     * @return
     * @throws Exception
     */
    @PostMapping("/createOutput")
    public int createOutput(@RequestBody WorkBinTaskDTO record) throws Exception {
        return workBinAppService.createTask(2, record);
    }

    /**
     * 查询出库任务
     * @param label
     * @return
     * @throws Exception
     */
    @GetMapping("/getOutputInfo")
    public WorkBinTaskDTO getInfo(@RequestParam("label") String label) throws Exception {
        return workBinAppService.getTaskForOutput(label);
    }

    /**
     * 出库
     *
     * @param labels
     * @return
     * @throws Exception
     */
    @GetMapping("/output")
    public int output(@RequestParam("labels") String labels) throws Exception {
        return workBinAppService.output(labels);
    }


}
