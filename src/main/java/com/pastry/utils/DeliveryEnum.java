package com.pastry.utils;

/**
 * Created by wulidan on 19/5/11.
 */
public enum DeliveryEnum {

    DELIVERY(100,"已发货"),
    TOOK(200, "已揽件"),
    TRANSPORT(300,"运输中"),
    SEND(400,"入库完成"),
    SIGN(500,"已签收");

    private int code;
    private String desc;

    DeliveryEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    // 普通方法
    public static String getDesc(int code) {
        for (DeliveryEnum c : DeliveryEnum.values()) {
            if (c.getCode() == code) {
                return c.getDesc();
            }
        }
        return null;
    }
}
