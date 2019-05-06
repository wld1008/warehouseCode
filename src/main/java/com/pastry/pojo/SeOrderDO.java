package com.pastry.pojo;

import java.util.Date;

public class SeOrderDO {
    private Integer id;

    private String orderCode;

    private String productCode;

    private String buyerName;

    private String buyerMobile;

    private Integer productNum;

    private String buyerCity;

    private String buyerProvince;

    private String county;

    private Date createTime;

    private Date updateTime;

    public SeOrderDO(Integer id, String orderCode, String productCode, String buyerName, String buyerMobile, Integer productNum, String buyerCity, String buyerProvince, String county, Date createTime, Date updateTime) {
        this.id = id;
        this.orderCode = orderCode;
        this.productCode = productCode;
        this.buyerName = buyerName;
        this.buyerMobile = buyerMobile;
        this.productNum = productNum;
        this.buyerCity = buyerCity;
        this.buyerProvince = buyerProvince;
        this.county = county;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public SeOrderDO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName == null ? null : buyerName.trim();
    }

    public String getBuyerMobile() {
        return buyerMobile;
    }

    public void setBuyerMobile(String buyerMobile) {
        this.buyerMobile = buyerMobile == null ? null : buyerMobile.trim();
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public String getBuyerCity() {
        return buyerCity;
    }

    public void setBuyerCity(String buyerCity) {
        this.buyerCity = buyerCity == null ? null : buyerCity.trim();
    }

    public String getBuyerProvince() {
        return buyerProvince;
    }

    public void setBuyerProvince(String buyerProvince) {
        this.buyerProvince = buyerProvince == null ? null : buyerProvince.trim();
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