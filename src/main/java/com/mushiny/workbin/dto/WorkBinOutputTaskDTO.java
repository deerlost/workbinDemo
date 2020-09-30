package com.mushiny.workbin.dto;


import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Package com.mushiny.workbin.dto
 * @anthor：wyang
 * @date：2020/9/28
 */
public class WorkBinOutputTaskDTO {

    private Integer point;

    private List<Long> unitLoadIdList;

    public Integer getPoint() {
        return point;
    }

    public WorkBinOutputTaskDTO setPoint(Integer point) {
        this.point = point;
        return this;
    }

    public List<Long> getUnitLoadIdList() {
        if (unitLoadIdList == null) {
            return new ArrayList<>();
        }
        return unitLoadIdList;
    }

    public WorkBinOutputTaskDTO setUnitLoadIdList(List<Long> unitLoadIdList) {
        this.unitLoadIdList = unitLoadIdList;
        return this;
    }
}
