package com.pastry.pojo;

import java.util.Date;

public class ImExpDistribution {
    private Integer id;

    private String shopCode;

    private String warehouseCode;

    private String province;

    private Integer productNum;

    private String expCode;

    private String expName;

    private Date createTime;

    private Date updateTime;

    public ImExpDistribution(Integer id, String shopCode, String warehouseCode, String province, Integer productNum, String expCode, String expName, Date createTime, Date updateTime) {
        this.id = id;
        this.shopCode = shopCode;
        this.warehouseCode = warehouseCode;
        this.province = province;
        this.productNum = productNum;
        this.expCode = expCode;
        this.expName = expName;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ImExpDistribution() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode == null ? null : shopCode.trim();
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode == null ? null : warehouseCode.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public String getExpCode() {
        return expCode;
    }

    public void setExpCode(String expCode) {
        this.expCode = expCode == null ? null : expCode.trim();
    }

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName == null ? null : expName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}