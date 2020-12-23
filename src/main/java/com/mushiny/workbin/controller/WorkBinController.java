package com.mushiny.workbin.controller;


import com.mushiny.workbin.annotation.ResponseResult;
import com.mushiny.workbin.application.WorkBinAppService;
import com.mushiny.workbin.business.SchedulerBusiness;
import com.mushiny.workbin.business.WcsBusiness;
import com.mushiny.workbin.dto.InputTaskDTO;
import com.mushiny.workbin.dto.WorkBinTaskDTO;
import com.mushiny.workbin.entity.TransferOrder;
import com.mushiny.workbin.exception.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

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
    @Autowired
    WcsBusiness wcsBusiness;
    @Autowired
    SchedulerBusiness schedulerBusiness;


    /**
     * 入库 扫描条码
     *
     * @param map
     * @return
     * @throws Exception
     */
    @PostMapping("/scan")
    public Result scan(@RequestBody Map<String,Object> map) throws Exception {
        return new Result<>().ok(workBinAppService.getTransferOrderList(map));
    }

    /**
     * 入库绑定库位
     *
     * @param record
     * @return
     * @throws Exception
     */
    @PostMapping("/createInput")
    @ResponseResult
    public WorkBinTaskDTO createInput(@RequestBody WorkBinTaskDTO record) throws Exception {
        InputTaskDTO dto = new InputTaskDTO();
        dto.setTaskList(Arrays.asList(record));
        return workBinAppService.createTask(1, dto).getTaskList().get(0);
    }

    /**
     * 入库 呼叫
     *
     * @param labels
     * @return
     * @throws Exception
     */
    @GetMapping("/input")
    public Result input(@RequestParam("labels") String labels) throws Exception {
        return new Result<>().ok(workBinAppService.input(labels));
    }


    /**
     * 产线呼叫 下发出库任务
     *
     * @param record
     * @return
     * @throws Exception
     */
    @PostMapping("/createOutput")
    public Result createOutput(@RequestBody InputTaskDTO record) throws Exception {
        return new Result<>().ok(workBinAppService.createTask(2, record));
    }

    /**
     * 产线呼叫  查询
     *
     * @param query
     * @return
     * @throws Exception
     */
    @PostMapping("/query")
    public Result query(@RequestBody Map<String,Object> query) throws Exception {
        return new Result<>().ok(workBinAppService.getByCond(query));
    }

    /**
     * 查询出库任务
     *
     * @param label
     * @return
     * @throws Exception
     */
    @GetMapping("/getOutputInfo")
    public Result getInfo(@RequestParam("label") String label) throws Exception {
        return new Result<>().ok(workBinAppService.getTaskForOutput(label));
    }

    /**
     * 出库
     *
     * @param labels
     * @return
     * @throws Exception
     */
    @GetMapping("/output")
    public Result output(@RequestParam("labels") String labels) throws Exception {
        return new Result<>().ok(workBinAppService.output(labels));
    }

    /**
     * @return
     * @throws Exception
     */
    @GetMapping("/test")
    public Result test() throws Exception {
        return new Result<>().ok(wcsBusiness.queryBinInfo());
    }

    /**
     * @return
     * @throws Exception
     */
    @GetMapping("/callOutput")
    public void call() throws Exception {
        schedulerBusiness.callToOutput();
    }


}
