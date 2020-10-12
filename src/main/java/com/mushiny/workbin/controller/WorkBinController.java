package com.mushiny.workbin.controller;


import com.mushiny.workbin.application.WorkBinAppService;
import com.mushiny.workbin.business.WcsBusiness;
import com.mushiny.workbin.dto.WorkBinTaskDTO;
import com.mushiny.workbin.exception.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 入库绑定库位
     *
     * @param record
     * @return
     * @throws Exception
     */
    @PostMapping("/createInput")
    public Result createInput(@RequestBody WorkBinTaskDTO record) throws Exception {
        return new Result().ok(workBinAppService.createTask(1, record));
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
     * 产线呼叫 获取料箱信息
     *
     * @param sku
     * @return
     * @throws Exception
     */
    @GetMapping("/getLabel")
    public Result getLabel(@RequestParam("sku") String sku) throws Exception {
        return new Result<>().ok(workBinAppService.getLabelList(sku));
    }

    /**
     * 产线呼叫 下发出库任务
     *
     * @param record
     * @return
     * @throws Exception
     */
    @PostMapping("/createOutput")
    public Result createOutput(@RequestBody WorkBinTaskDTO record) throws Exception {
        return new Result<>().ok(workBinAppService.createTask(2, record));
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
     *
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/test")
    public Result test() throws Exception {
        return new Result<>().ok(wcsBusiness.queryBinInfo());
    }



}
