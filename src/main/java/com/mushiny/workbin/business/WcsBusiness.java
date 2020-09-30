package com.mushiny.workbin.business;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mushiny.workbin.entity.IntTransportOrder;
import com.mushiny.workbin.entity.MdStorageBin;
import com.mushiny.workbin.service.MdStorageBinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description TODO
 * @Package com.mushiny.workbin.business
 * @anthor：wyang
 * @date：2020/9/27
 */
@Component
@Slf4j
public class WcsBusiness {
    @Autowired
    private MdStorageBinService storageBinService;

    private String updateBinUrl;

    private String callToteUrl;

    private String queryBinListUrl;

    private String token;

    private String sectionId;

    public String wcsUpdateBin(String binCode, String label) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("binCode", binCode);
        paramMap.put("toteCode", label);
        String message = null;
        try {
            message = this.getForObject(this.updateBinUrl + "?binCode={binCode}&toteCode={toteCode}", paramMap);

        } catch (Exception e) {
            log.info(" !!!!!!!!!!!!!  修改货位料箱 bin ={},label = {} 失败 ，异常", binCode, label, e);
            throw e;
        }
        return message;

    }

    public String queryBinInfo() throws Exception {
        String message = null;
        try {
            message = this.getForObject(this.queryBinListUrl + "?side=&aisle=&line=&column=&row=&binCode=", new HashMap());

            if (StringUtils.isEmpty(message)) {
                throw new Exception("查询货位信息 失败");
            }
        } catch (Exception e) {
            log.info(" !!!!!!!!!!!!!  查询货位信息 失败 ，异常", e);
            throw e;
        }

        JSONArray array = JSON.parseArray(message);
        for (int i = 0; i < array.size(); i++) {
            JSONObject obj = (JSONObject) array.get(i);
            MdStorageBin bin = storageBinService.getByCode(obj.getString("code"));
            if (ObjectUtils.isEmpty(bin)) {
                //TODO 保存storage信息
                MdStorageBin entity = new MdStorageBin();
                entity.setCode(obj.getString("code"));
                storageBinService.save(entity);
            }

        }

        return message;

    }

    /**
     * 呼叫料箱
     *
     * @param type
     * @param orderList
     * @throws Exception
     */
    public void callLabel(String type, List<IntTransportOrder> orderList) throws Exception {
        JSONArray jsonArray = new JSONArray();

        for (IntTransportOrder order : orderList) {
            JSONObject obj = new JSONObject();
            obj.put("toteAGVTaskActionType", type);
            JSONObject son = new JSONObject();
            son.put("toteCode", order.getUnitLoadLabel());
            son.put("weight", "");
            son.put("toteType", "");
            obj.put("toteInfoDTO", son);
            obj.put("binCode", order.getTargetStorageCode());
            jsonArray.add(obj);
        }

        Map<String, Object> param = new HashMap<>();
        param.put("toteAGVTaskActionDTOS", jsonArray);
        String message = "";

        try {
            message = this.postForObject(this.callToteUrl, param.toString());

            if (StringUtils.isEmpty(message)) {
                log.info(" !!!!!!!!!!!!!  呼叫料箱 类型 ={} ，失败  ,参数label :{}", type, orderList.stream().map(IntTransportOrder::getUnitLoadLabel).collect(Collectors.toList()).toString());
                throw new Exception("呼叫料箱失败");
            }

        } catch (Exception e) {
            log.info(" !!!!!!!!!!!!!  呼叫料箱 类型 ={} ，异常", type, e);
            throw e;
        }


    }

    private String postForObject(String url, String params) {
        log.info("url : {} , 参数是 {]", url, params);

        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.add("Authorization", token);
        headers.add("sectionId", sectionId);

        HttpEntity<String> formEntity = new HttpEntity<>(params, headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url, formEntity, String.class);
    }

    private String getForObject(String url, Map params) {
        log.info("url : {} , 参数是 {]", url, params.toString());
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.add("Authorization", token);
        headers.add("sectionId", sectionId);
        HttpEntity<String> formEntity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, formEntity, String.class, params);
        return result.getBody();
    }
}
