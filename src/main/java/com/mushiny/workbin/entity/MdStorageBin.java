package com.mushiny.workbin.entity;

import java.math.BigDecimal;
import java.util.Date;

public class MdStorageBin {
    private Long id;

    private String code;

    private String name;

    private String shortName;

    private Integer xCoordinate;

    private Integer yCoordinate;

    private Integer zCoordinate;

    private BigDecimal allocation;

    private Integer allocationStatus;

    private String field;

    private Integer fieldIndex;

    private Integer orderIndex;

    private String plcCode;

    private String scanCode;

    private Date stockTakingDate;

    private Long storageBinTypeId;

    private Long capacityId;

    private Long clusterId;

    private Long rackId;

    private Long areaId;

    private Long zoneId;

    private Long sectionId;

    private Boolean onlySingles;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public Integer getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(Integer xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public Integer getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(Integer yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public Integer getzCoordinate() {
        return zCoordinate;
    }

    public void setzCoordinate(Integer zCoordinate) {
        this.zCoordinate = zCoordinate;
    }

    public BigDecimal getAllocation() {
        return allocation;
    }

    public void setAllocation(BigDecimal allocation) {
        this.allocation = allocation;
    }

    public Integer getAllocationStatus() {
        return allocationStatus;
    }

    public void setAllocationStatus(Integer allocationStatus) {
        this.allocationStatus = allocationStatus;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field == null ? null : field.trim();
    }

    public Integer getFieldIndex() {
        return fieldIndex;
    }

    public void setFieldIndex(Integer fieldIndex) {
        this.fieldIndex = fieldIndex;
    }

    public Integer getOrderIndex() {
        return orderIndex;
    }

    public void setOrderIndex(Integer orderIndex) {
        this.orderIndex = orderIndex;
    }

    public String getPlcCode() {
        return plcCode;
    }

    public void setPlcCode(String plcCode) {
        this.plcCode = plcCode == null ? null : plcCode.trim();
    }

    public String getScanCode() {
        return scanCode;
    }

    public void setScanCode(String scanCode) {
        this.scanCode = scanCode == null ? null : scanCode.trim();
    }

    public Date getStockTakingDate() {
        return stockTakingDate;
    }

    public void setStockTakingDate(Date stockTakingDate) {
        this.stockTakingDate = stockTakingDate;
    }

    public Long getStorageBinTypeId() {
        return storageBinTypeId;
    }

    public void setStorageBinTypeId(Long storageBinTypeId) {
        this.storageBinTypeId = storageBinTypeId;
    }

    public Long getCapacityId() {
        return capacityId;
    }

    public void setCapacityId(Long capacityId) {
        this.capacityId = capacityId;
    }

    public Long getClusterId() {
        return clusterId;
    }

    public void setClusterId(Long clusterId) {
        this.clusterId = clusterId;
    }

    public Long getRackId() {
        return rackId;
    }

    public void setRackId(Long rackId) {
        this.rackId = rackId;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public Boolean getOnlySingles() {
        return onlySingles;
    }

    public void setOnlySingles(Boolean onlySingles) {
        this.onlySingles = onlySingles;
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