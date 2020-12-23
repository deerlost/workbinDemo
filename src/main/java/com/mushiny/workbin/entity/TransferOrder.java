package com.mushiny.workbin.entity;

public class TransferOrder {
    private Long id;

    /**
     * 料箱
     */
    private String labelId;

    /**
     * 订单号
     */
    private String poNo;

    /**
     * 床次
     */
    private String tableNo;

    /**
     * 款号
     */
    private String styleNo;

    /**
     * 尺码
     */
    private String psize;

    /**
     * 数量
     */
    private Integer sumQty;

    /**
     * 国家
     */
    private String countryNo;

    /**
     * 色号
     */
    private String colour;

    public String getLabelId() {
        return labelId == null ? "" : labelId;
    }

    public TransferOrder setLabelId(String labelId) {
        this.labelId = labelId;
        return this;
    }

    public String getPoNo() {
        return poNo == null ? "" : poNo;
    }

    public TransferOrder setPoNo(String poNo) {
        this.poNo = poNo;
        return this;
    }

    public String getTableNo() {
        return tableNo == null ? "" : tableNo;
    }

    public TransferOrder setTableNo(String tableNo) {
        this.tableNo = tableNo;
        return this;
    }

    public String getStyleNo() {
        return styleNo == null ? "" : styleNo;
    }

    public TransferOrder setStyleNo(String styleNo) {
        this.styleNo = styleNo;
        return this;
    }

    public String getPsize() {
        return psize == null ? "" : psize;
    }

    public TransferOrder setPsize(String psize) {
        this.psize = psize;
        return this;
    }

    public Integer getSumQty() {
        return sumQty;
    }

    public TransferOrder setSumQty(Integer sumQty) {
        this.sumQty = sumQty;
        return this;
    }

    public String getCountryNo() {
        return countryNo == null ? "" : countryNo;
    }

    public TransferOrder setCountryNo(String countryNo) {
        this.countryNo = countryNo;
        return this;
    }

    public String getColour() {
        return colour == null ? "" : colour;
    }

    public TransferOrder setColour(String colour) {
        this.colour = colour;
        return this;
    }
}