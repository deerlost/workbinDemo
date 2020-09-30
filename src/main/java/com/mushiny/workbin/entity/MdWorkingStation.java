package com.mushiny.workbin.entity;

import java.util.Date;

public class MdWorkingStation {
    private Long id;

    private String code;

    private String name;

    private String usages;

    private Integer usagesType;

    private String chooseType;

    private Integer xCoordinate;

    private Integer yCoordinate;

    private String entryPoint;

    private Integer xEntryPoint;

    private Integer yEntryPoint;

    private String exitPoint;

    private Integer xExitPoint;

    private Integer yExitPoint;

    private Integer stopPoint;

    private Long workingStationGroupId;

    private String wcsWorkstationId;

    private Integer orientation;

    private String currentUsage;

    private Long sectionId;

    private Long zoneId;

    private Long operatorId;

    private Integer minPods;

    private Integer maxPods;

    private Integer perPickTime;

    private Integer maxWork;

    private Boolean stopAllocatePod;

    private Boolean stopAllocateOrder;

    private Boolean allowManualRelease;

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

    public String getUsages() {
        return usages;
    }

    public void setUsages(String usages) {
        this.usages = usages == null ? null : usages.trim();
    }

    public Integer getUsagesType() {
        return usagesType;
    }

    public void setUsagesType(Integer usagesType) {
        this.usagesType = usagesType;
    }

    public String getChooseType() {
        return chooseType;
    }

    public void setChooseType(String chooseType) {
        this.chooseType = chooseType == null ? null : chooseType.trim();
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

    public String getEntryPoint() {
        return entryPoint;
    }

    public void setEntryPoint(String entryPoint) {
        this.entryPoint = entryPoint == null ? null : entryPoint.trim();
    }

    public Integer getxEntryPoint() {
        return xEntryPoint;
    }

    public void setxEntryPoint(Integer xEntryPoint) {
        this.xEntryPoint = xEntryPoint;
    }

    public Integer getyEntryPoint() {
        return yEntryPoint;
    }

    public void setyEntryPoint(Integer yEntryPoint) {
        this.yEntryPoint = yEntryPoint;
    }

    public String getExitPoint() {
        return exitPoint;
    }

    public void setExitPoint(String exitPoint) {
        this.exitPoint = exitPoint == null ? null : exitPoint.trim();
    }

    public Integer getxExitPoint() {
        return xExitPoint;
    }

    public void setxExitPoint(Integer xExitPoint) {
        this.xExitPoint = xExitPoint;
    }

    public Integer getyExitPoint() {
        return yExitPoint;
    }

    public void setyExitPoint(Integer yExitPoint) {
        this.yExitPoint = yExitPoint;
    }

    public Integer getStopPoint() {
        return stopPoint;
    }

    public void setStopPoint(Integer stopPoint) {
        this.stopPoint = stopPoint;
    }

    public Long getWorkingStationGroupId() {
        return workingStationGroupId;
    }

    public void setWorkingStationGroupId(Long workingStationGroupId) {
        this.workingStationGroupId = workingStationGroupId;
    }

    public String getWcsWorkstationId() {
        return wcsWorkstationId;
    }

    public void setWcsWorkstationId(String wcsWorkstationId) {
        this.wcsWorkstationId = wcsWorkstationId == null ? null : wcsWorkstationId.trim();
    }

    public Integer getOrientation() {
        return orientation;
    }

    public void setOrientation(Integer orientation) {
        this.orientation = orientation;
    }

    public String getCurrentUsage() {
        return currentUsage;
    }

    public void setCurrentUsage(String currentUsage) {
        this.currentUsage = currentUsage == null ? null : currentUsage.trim();
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getMinPods() {
        return minPods;
    }

    public void setMinPods(Integer minPods) {
        this.minPods = minPods;
    }

    public Integer getMaxPods() {
        return maxPods;
    }

    public void setMaxPods(Integer maxPods) {
        this.maxPods = maxPods;
    }

    public Integer getPerPickTime() {
        return perPickTime;
    }

    public void setPerPickTime(Integer perPickTime) {
        this.perPickTime = perPickTime;
    }

    public Integer getMaxWork() {
        return maxWork;
    }

    public void setMaxWork(Integer maxWork) {
        this.maxWork = maxWork;
    }

    public Boolean getStopAllocatePod() {
        return stopAllocatePod;
    }

    public void setStopAllocatePod(Boolean stopAllocatePod) {
        this.stopAllocatePod = stopAllocatePod;
    }

    public Boolean getStopAllocateOrder() {
        return stopAllocateOrder;
    }

    public void setStopAllocateOrder(Boolean stopAllocateOrder) {
        this.stopAllocateOrder = stopAllocateOrder;
    }

    public Boolean getAllowManualRelease() {
        return allowManualRelease;
    }

    public void setAllowManualRelease(Boolean allowManualRelease) {
        this.allowManualRelease = allowManualRelease;
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