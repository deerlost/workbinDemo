package com.mushiny.workbin.websocket;


import com.alibaba.fastjson.JSONObject;
import com.mushiny.workbin.dto.WorkBinTaskDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * @Description TODO
 * @Package com.mushiny.workbin.websocket
 * @anthor：wyang
 * @date：2020/10/13
 */
@RestController
@RequestMapping("/checkcenter")
public class CheckCenterController {

    /**
     * 页面请求
     * @param cid
     * @return
     */
    @GetMapping("/socket/{cid}")
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav=new ModelAndView("/socket");
        mav.addObject("cid", cid);
        return mav;
    }
    /**
     * 推送数据接口
     * @param message
     * @return
     */
    @ResponseBody
    @RequestMapping("/socket/push")
    public String pushToWeb(@RequestParam String message) {
        try {
            WorkBinTaskDTO dto = new WorkBinTaskDTO();
            dto.setStorageCode("1AA001RC01R01MJF");
            dto.setLabel("UL-000000332");
            try {
                WebSocketServer.sendInfo(JSONObject.toJSONString(dto),null);
            } catch (IOException e) {
                e.printStackTrace();
            }
            WebSocketServer.sendInfo(message,null);
        } catch (IOException e) {
            e.printStackTrace();
            return "error:"+"#"+e.getMessage();
        }
        return "success:";
    }
}
