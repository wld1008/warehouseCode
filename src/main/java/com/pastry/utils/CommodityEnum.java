package com.pastry.utils;

/**
 * Created by wulidan on 19/5/11.
 */
public enum CommodityEnum {

    ENABLE(100, "准备入库"),
    EXP_SURE(200,"部分入库"),
    EXP_SIGN(500,"入库完成");

    private int code;
    private String desc;

    CommodityEnum(int code, String desc) {
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
        for (CommodityEnum c : CommodityEnum.values()) {
            if (c.getCode() == code) {
                return c.getDesc();
            }
        }
        return null;
    }
}
