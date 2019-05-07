package com.pastry.pojo;

import java.util.Date;

public class BaWarehouse {
    private Integer id;

    private String warehouseCode;

    private String warehouseName;

    private String province;

    private String city;

    private String county;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    public BaWarehouse(Integer id, String warehouseCode, String warehouseName, String province, String city, String county, Date createTime, Date updateTime, Integer status) {
        this.id = id;
        this.warehouseCode = warehouseCode;
        this.warehouseName = warehouseName;
        this.province = province;
        this.city = city;
        this.county = county;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
    }

    public BaWarehouse() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode == null ? null : warehouseCode.trim();
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName == null ? null : warehouseName.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
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