package com.pastry.utils;

/**
 * Created by wulidan on 19/5/17.
 */
public enum ExpCodeEnum {
    ST("申通快递","shentong"),
    EMS("ems", "ems"),
    SF("顺丰快递","shunfeng"),
    YT("圆通快递","yuantong"),


    ZT("中通快递","zhongtong"),
    YD("韵达快递", "yunda"),
    TT("天天快递","tiantian"),
    HT("汇通快递","huitongkuaidi"),
    DB("德邦物流","debangwuliu"),
    ZJS("宅急送","zhaijisong");

    private String code;
    private String desc;

    ExpCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    // 普通方法
    public static String getDesc(String code) {
        for (DeliveryEnum c : DeliveryEnum.values()) {
            if (code.equals(c.getCode())) {
                return c.getDesc();
            }
        }
        return null;
    }
}
