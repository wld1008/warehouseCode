package com.pastry.utils;

/**
 * Created by wulidan on 19/5/8.
 */
public enum OrderStatusEnum {

    ENABLE(100, "启用"),
    WAIT_EXP_SURE(200,"等待快递分配"),
    WAIT_EXP_SEND(300,"等待发货"),
    EXP_SEND(400,"已发货"),
    DIS_ENABLE(900, "取消订单"),
    EXP_SIGN(500,"签收");

    private int code;
    private String desc;

    OrderStatusEnum(int code, String desc) {
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
        for (OrderStatusEnum c : OrderStatusEnum.values()) {
            if (c.getCode() == code) {
                return c.getDesc();
            }
        }
        return null;
    }
}
