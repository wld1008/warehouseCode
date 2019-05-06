package com.pastry.pojo;

import java.util.Date;

public class ImProductDO {
    private Integer id;

    private String productCode;

    private String productName;

    private String shopCode;

    private String shopName;

    private String warehouseCode;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    public ImProductDO(Integer id, String productCode, String productName, String shopCode, String shopName, String warehouseCode, Date createTime, Date updateTime, Integer status) {
        this.id = id;
        this.productCode = productCode;
        this.productName = productName;
        this.shopCode = shopCode;
        this.shopName = shopName;
        this.warehouseCode = warehouseCode;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
    }

    public ImProductDO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode == null ? null : shopCode.trim();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode == null ? null : warehouseCode.trim();
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}