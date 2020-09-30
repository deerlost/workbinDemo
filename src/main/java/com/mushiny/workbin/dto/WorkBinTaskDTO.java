package com.mushiny.workbin.dto;



/**
 * @Description TODO
 * @Package com.mushiny.workbin.dto
 * @anthor：wyang
 * @date：2020/9/27
 */
public class WorkBinTaskDTO {

    private String point;

    private String productCode;

    private String label;

    private String storageCode;

    public String getProductCode() {
        return productCode == null ? "" : productCode;
    }

    public WorkBinTaskDTO setProductCode(String productCode) {
        this.productCode = productCode;
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
