package com.pastry.pojo;

import java.util.Date;

public class ImInventory {
    private Integer id;

    private String productCode;

    private Integer productNum;

    private Integer productLockNum;

    private String shopCode;

    private String warehouseCode;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private String productName;
    private String shopName;
    private String warehouseName;

    public ImInventory(Integer id, String productCode, Integer productNum, Integer productLockNum, String shopCode, String warehouseCode, Date createTime, Date updateTime, Integer status) {
        this.id = id;
        this.productCode = productCode;
        this.productNum = productNum;
        this.productLockNum = productLockNum;
        this.shopCode = shopCode;
        this.warehouseCode = warehouseCode;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
    }

    public ImInventory() {
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

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public Integer getProductLockNum() {
        return productLockNum;
    }

    public void setProductLockNum(Integer productLockNum) {
        this.productLockNum = productLockNum;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }
}