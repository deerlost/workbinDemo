package com.mushiny.workbin.entity;

import java.math.BigDecimal;
import java.util.Date;

public class MdProduct {
    private Long id;

    private String code;

    private String sku;

    private String name;

    private String description;

    private String pictureName;

    private String pictureUrl;

    private Long brandId;

    private Long productTypeId;

    private Long productGroupId;

    private BigDecimal width;

    private BigDecimal height;

    private BigDecimal depth;

    private BigDecimal volume;

    private BigDecimal weight;

    private Byte adviceMandatory;

    private Byte lotMandatory;

    private Byte bestBeforeMandatory;

    private Byte lotSubstitutionType;

    private Integer restUsageGi;

    private Integer restUsageGo;

    private String bestBeforeType;

    private String bestBeforeUnit;

    private Byte serialNoRecordType;

    private Byte weightRecordType;

    private Integer shelfLife;

    private Integer safetyStock;

    private String tradeGroup;

    private Long defaultPackagingUnitId;

    private Long defaultStorageStrategyId;

    private Long defaultUnitLoadTypeId;

    private Long uomId;

    private Long zoneId;

    private String spuData;

    private Long warehouseId;

    private Long clientId;

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

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName == null ? null : pictureName.trim();
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl == null ? null : pictureUrl.trim();
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public Long getProductGroupId() {
        return productGroupId;
    }

    public void setProductGroupId(Long productGroupId) {
        this.productGroupId = productGroupId;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getDepth() {
        return depth;
    }

    public void setDepth(BigDecimal depth) {
        this.depth = depth;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public Byte getAdviceMandatory() {
        return adviceMandatory;
    }

    public void setAdviceMandatory(Byte adviceMandatory) {
        this.adviceMandatory = adviceMandatory;
    }

    public Byte getLotMandatory() {
        return lotMandatory;
    }

    public void setLotMandatory(Byte lotMandatory) {
        this.lotMandatory = lotMandatory;
    }

    public Byte getBestBeforeMandatory() {
        return bestBeforeMandatory;
    }

    public void setBestBeforeMandatory(Byte bestBeforeMandatory) {
        this.bestBeforeMandatory = bestBeforeMandatory;
    }

    public Byte getLotSubstitutionType() {
        return lotSubstitutionType;
    }

    public void setLotSubstitutionType(Byte lotSubstitutionType) {
        this.lotSubstitutionType = lotSubstitutionType;
    }

    public Integer getRestUsageGi() {
        return restUsageGi;
    }

    public void setRestUsageGi(Integer restUsageGi) {
        this.restUsageGi = restUsageGi;
    }

    public Integer getRestUsageGo() {
        return restUsageGo;
    }

    public void setRestUsageGo(Integer restUsageGo) {
        this.restUsageGo = restUsageGo;
    }

    public String getBestBeforeType() {
        return bestBeforeType;
    }

    public void setBestBeforeType(String bestBeforeType) {
        this.bestBeforeType = bestBeforeType == null ? null : bestBeforeType.trim();
    }

    public String getBestBeforeUnit() {
        return bestBeforeUnit;
    }

    public void setBestBeforeUnit(String bestBeforeUnit) {
        this.bestBeforeUnit = bestBeforeUnit == null ? null : bestBeforeUnit.trim();
    }

    public Byte getSerialNoRecordType() {
        return serialNoRecordType;
    }

    public void setSerialNoRecordType(Byte serialNoRecordType) {
        this.serialNoRecordType = serialNoRecordType;
    }

    public Byte getWeightRecordType() {
        return weightRecordType;
    }

    public void setWeightRecordType(Byte weightRecordType) {
        this.weightRecordType = weightRecordType;
    }

    public Integer getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(Integer shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Integer getSafetyStock() {
        return safetyStock;
    }

    public void setSafetyStock(Integer safetyStock) {
        this.safetyStock = safetyStock;
    }

    public String getTradeGroup() {
        return tradeGroup;
    }

    public void setTradeGroup(String tradeGroup) {
        this.tradeGroup = tradeGroup == null ? null : tradeGroup.trim();
    }

    public Long getDefaultPackagingUnitId() {
        return defaultPackagingUnitId;
    }

    public void setDefaultPackagingUnitId(Long defaultPackagingUnitId) {
        this.defaultPackagingUnitId = defaultPackagingUnitId;
    }

    public Long getDefaultStorageStrategyId() {
        return defaultStorageStrategyId;
    }

    public void setDefaultStorageStrategyId(Long defaultStorageStrategyId) {
        this.defaultStorageStrategyId = defaultStorageStrategyId;
    }

    public Long getDefaultUnitLoadTypeId() {
        return defaultUnitLoadTypeId;
    }

    public void setDefaultUnitLoadTypeId(Long defaultUnitLoadTypeId) {
        this.defaultUnitLoadTypeId = defaultUnitLoadTypeId;
    }

    public Long getUomId() {
        return uomId;
    }

    public void setUomId(Long uomId) {
        this.uomId = uomId;
    }

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zoneId) {
        this.zoneId = zoneId;
    }

    public String getSpuData() {
        return spuData;
    }

    public void setSpuData(String spuData) {
        this.spuData = spuData == null ? null : spuData.trim();
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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