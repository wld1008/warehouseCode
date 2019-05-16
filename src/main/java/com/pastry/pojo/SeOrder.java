package com.pastry.pojo;

import java.util.Date;

public class SeOrder {
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

    private Integer orderStatus;

    private String expressName;

    private String expNumber;

    private Date signInTime;

    private String desc;

    private String productName;

    public SeOrder(Integer id, String orderCode, String productCode, String buyerName, String buyerMobile, Integer productNum, String buyerCity, String buyerProvince, String county, Date createTime, Date updateTime, Integer orderStatus, String expressName, String expNumber, Date signInTime) {
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
        this.orderStatus = orderStatus;
        this.expressName = expressName;
        this.expNumber = expNumber;
        this.signInTime = signInTime;
//        this.desc = desc;
    }

    public SeOrder() {
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

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName == null ? null : expressName.trim();
    }

    public String getExpNumber() {
        return expNumber;
    }

    public void setExpNumber(String expNumber) {
        this.expNumber = expNumber == null ? null : expNumber.trim();
    }

    public Date getSignInTime() {
        return signInTime;
    }

    public void setSignInTime(Date signInTime) {
        this.signInTime = signInTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}