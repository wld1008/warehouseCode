package com.pastry.pojo;

import java.util.Date;

public class ImDeliveryTracking {
    private Integer id;

    private String expressCode;

    private String expressName;

    private String orderCode;

    private String reachProvice;

    private String reachCity;

    private String reachCounty;

    private String reachDetail;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private String desc;

    private String operateTime;

    public ImDeliveryTracking(Integer id, String expressCode, String expressName, String orderCode, String reachProvice, String reachCity, String reachCounty, String reachDetail, Integer status, Date createTime, Date updateTime) {
        this.id = id;
        this.expressCode = expressCode;
        this.expressName = expressName;
        this.orderCode = orderCode;
        this.reachProvice = reachProvice;
        this.reachCity = reachCity;
        this.reachCounty = reachCounty;
        this.reachDetail = reachDetail;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public ImDeliveryTracking() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getExpressCode() {
        return expressCode;
    }

    public void setExpressCode(String expressCode) {
        this.expressCode = expressCode == null ? null : expressCode.trim();
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName == null ? null : expressName.trim();
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode == null ? null : orderCode.trim();
    }

    public String getReachProvice() {
        return reachProvice;
    }

    public void setReachProvice(String reachProvice) {
        this.reachProvice = reachProvice == null ? null : reachProvice.trim();
    }

    public String getReachCity() {
        return reachCity;
    }

    public void setReachCity(String reachCity) {
        this.reachCity = reachCity == null ? null : reachCity.trim();
    }

    public String getReachCounty() {
        return reachCounty;
    }

    public void setReachCounty(String reachCounty) {
        this.reachCounty = reachCounty == null ? null : reachCounty.trim();
    }

    public String getReachDetail() {
        return reachDetail;
    }

    public void setReachDetail(String reachDetail) {
        this.reachDetail = reachDetail == null ? null : reachDetail.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(String operateTime) {
        this.operateTime = operateTime;
    }
}