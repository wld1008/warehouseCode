package com.pastry.utils;

/**
 * Created by wulidan on 19/5/8.
 */
public enum StatusEnum {

    ENABLE(0, "启用"),
    DIS_ABLE(1,"禁用");

    private int code;
    private String desc;

    StatusEnum(int code, String desc) {
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
       for (StatusEnum c : StatusEnum.values()) {
           if (c.getCode() == code) {
               return c.getDesc();
           }
       }
        return null;
     }

}
