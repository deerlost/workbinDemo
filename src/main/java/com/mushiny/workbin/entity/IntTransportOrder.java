package com.mushiny.workbin.entity;

import com.baomidou.mybatisplus.annotation.TableField;

import java.util.Date;

public class IntTransportOrder extends BaseEntity{

    private static final long serialVersionUID = 5996430400586903503L;
    private String orderNumber;

    private Byte orderType;

    private String externalId;

    private String externalNumber;

    private Byte priority;

    private Date startedDate;

    private Date finishedDate;

    private String unitLoadLabel;

    private Long confirmedDestinationId;

    private Long destinationBinId;

    private Long sourceBinId;

    private Long successorId;

    private Long unitLoadId;

    private Long operatorId;

    private Long stationId;


    /*************  扩展字段 ***************/
    @TableField(exist = false)
    private String targetStorageCode;
    @TableField(exist = false)
    private String sourceStorageCode;

    public String getSourceStorageCode() {
        return sourceStorageCode == null ? "" : sourceStorageCode;
    }

    public IntTransportOrder setSourceStorageCode(String sourceStorageCode) {
        this.sourceStorageCode = sourceStorageCode;
        return this;
    }

    public String getTargetStorageCode() {
        return targetStorageCode == null ? "" : targetStorageCode;
    }

    public IntTransportOrder setTargetStorageCode(String targetStorageCode) {
        this.targetStorageCode = targetStorageCode;
        return this;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public Byte getOrderType() {
        return orderType;
    }

    public void setOrderType(Byte orderType) {
        this.orderType = orderType;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId == null ? null : externalId.trim();
    }

    public String getExternalNumber() {
        return externalNumber;
    }

    public void setExternalNumber(String externalNumber) {
        this.externalNumber = externalNumber == null ? null : externalNumber.trim();
    }

    public Byte getPriority() {
        return priority;
    }

    public void setPriority(Byte priority) {
        this.priority = priority;
    }

    public Date getStartedDate() {
        return startedDate;
    }

    public void setStartedDate(Date startedDate) {
        this.startedDate = startedDate;
    }

    public Date getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(Date finishedDate) {
        this.finishedDate = finishedDate;
    }

    public String getUnitLoadLabel() {
        return unitLoadLabel;
    }

    public void setUnitLoadLabel(String unitLoadLabel) {
        this.unitLoadLabel = unitLoadLabel == null ? null : unitLoadLabel.trim();
    }

    public Long getConfirmedDestinationId() {
        return confirmedDestinationId;
    }

    public void setConfirmedDestinationId(Long confirmedDestinationId) {
        this.confirmedDestinationId = confirmedDestinationId;
    }

    public Long getDestinationBinId() {
        return destinationBinId;
    }

    public void setDestinationBinId(Long destinationBinId) {
        this.destinationBinId = destinationBinId;
    }

    public Long getSourceBinId() {
        return sourceBinId;
    }

    public void setSourceBinId(Long sourceBinId) {
        this.sourceBinId = sourceBinId;
    }

    public Long getSuccessorId() {
        return successorId;
    }

    public void setSuccessorId(Long successorId) {
        this.successorId = successorId;
    }

    public Long getUnitLoadId() {
        return unitLoadId;
    }

    public void setUnitLoadId(Long unitLoadId) {
        this.unitLoadId = unitLoadId;
    }

    public Long getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    public Long getStationId() {
        return stationId;
    }

    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }


}