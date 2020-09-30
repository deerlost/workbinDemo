package com.mushiny.workbin.entity;

import java.math.BigDecimal;
import java.util.Date;

public class InvUnitLoad {
    private Long id;

    private String labelId;

    private String externalId;

    private Byte opened;

    private BigDecimal weight;

    private BigDecimal weightCalculated;

    private BigDecimal weightMeasure;

    private Date stocktakingDate;

    private Long unitLoadTypeId;

    private Byte carrier;

    private Long carrierUnitLoadId;

    private Long productId;

    private Long storageBinId;

    private Long clientId;

    private Long warehouseId;

    private String remark;

    private Integer status;

    private Integer entityLock;

    private Byte delFlag;

    private Integer version;

    private Long creator;

    private Date createDate;

    private Long updater;

    private Date updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabelId() {
        return labelId;
    }

    public void setLabelId(String labelId) {
        this.labelId = labelId == null ? null : labelId.trim();
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId == null ? null : externalId.trim();
    }

    public Byte getOpened() {
        return opened;
    }

    public void setOpened(Byte opened) {
        this.opened = opened;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getWeightCalculated() {
        return weightCalculated;
    }

    public void setWeightCalculated(BigDecimal weightCalculated) {
        this.weightCalculated = weightCalculated;
    }

    public BigDecimal getWeightMeasure() {
        return weightMeasure;
    }

    public void setWeightMeasure(BigDecimal weightMeasure) {
        this.weightMeasure = weightMeasure;
    }

    public Date getStocktakingDate() {
        return stocktakingDate;
    }

    public void setStocktakingDate(Date stocktakingDate) {
        this.stocktakingDate = stocktakingDate;
    }

    public Long getUnitLoadTypeId() {
        return unitLoadTypeId;
    }

    public void setUnitLoadTypeId(Long unitLoadTypeId) {
        this.unitLoadTypeId = unitLoadTypeId;
    }

    public Byte getCarrier() {
        return carrier;
    }

    public void setCarrier(Byte carrier) {
        this.carrier = carrier;
    }

    public Long getCarrierUnitLoadId() {
        return carrierUnitLoadId;
    }

    public void setCarrierUnitLoadId(Long carrierUnitLoadId) {
        this.carrierUnitLoadId = carrierUnitLoadId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getStorageBinId() {
        return storageBinId;
    }

    public void setStorageBinId(Long storageBinId) {
        this.storageBinId = storageBinId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getEntityLock() {
        return entityLock;
    }

    public void setEntityLock(Integer entityLock) {
        this.entityLock = entityLock;
    }

    public Byte getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getUpdater() {
        return updater;
    }

    public void setUpdater(Long updater) {
        this.updater = updater;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}