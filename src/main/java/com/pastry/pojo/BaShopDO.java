package com.pastry.pojo;

import java.util.Date;

public class BaShopDO {
    private Integer id;

    private String shopCode;

    private String shopName;

    private String province;

    private String city;

    private String county;

    private Date createTime;

    private Date updateTime;

    public BaShopDO(Integer id, String shopCode, String shopName, String province, String city, String county, Date createTime, Date updateTime) {
        this.id = id;
        this.shopCode = shopCode;
        this.shopName = shopName;
        this.province = province;
        this.city = city;
        this.county = county;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public BaShopDO() {
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

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
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
}