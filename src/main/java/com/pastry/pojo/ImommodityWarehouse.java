package com.pastry.pojo;

import java.util.Date;

public class ImommodityWarehouse {
    private Integer id;

    private String productCode;

    private String warehouseCode;

    private String shopCode;

    private Integer productNum;

    private Date createTime;

    private Date updateTime;

    private Integer operateId;

    public ImommodityWarehouse(Integer id, String productCode, String warehouseCode, String shopCode, Integer productNum, Date createTime, Date updateTime, Integer operateId) {
        this.id = id;
        this.productCode = productCode;
        this.warehouseCode = warehouseCode;
        this.shopCode = shopCode;
        this.productNum = productNum;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.operateId = operateId;
    }

    public ImommodityWarehouse() {
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

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode == null ? null : warehouseCode.trim();
    }

    public String getShopCode() {
        return shopCode;
    }

    public void setShopCode(String shopCode) {
        this.shopCode = shopCode == null ? null : shopCode.trim();
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
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

    public Integer getOperateId() {
        return operateId;
    }

    public void setOperateId(Integer operateId) {
        this.operateId = operateId;
    }
}