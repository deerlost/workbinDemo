package com.mushiny.workbin.dto;


import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Package com.mushiny.workbin.dto
 * @anthor：wyang
 * @date：2020/9/27
 */
public class WorkBinTaskDTO {

    private String point;

    private String label;

    private String storageCode;

    private List<TransferOrderDTO> orderList;


    public List<TransferOrderDTO> getOrderList() {
        if (orderList == null) {
            return new ArrayList<>();
        }
        return orderList;
    }

    public WorkBinTaskDTO setOrderList(List<TransferOrderDTO> orderList) {
        this.orderList = orderList;
        return this;
    }

    public String getLabel() {
        return label == null ? "" : label;
    }

    public WorkBinTaskDTO setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getStorageCode() {
        return storageCode == null ? "" : storageCode;
    }

    public WorkBinTaskDTO setStorageCode(String storageCode) {
        this.storageCode = storageCode;
        return this;
    }

    public String getPoint() {
        return point == null ? "" : point;
    }

    public WorkBinTaskDTO setPoint(String point) {
        this.point = point;
        return this;
    }
}
