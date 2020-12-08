package com.changjiang.base.common.lib.enumtypes;

/**
* @Description:  公共枚举
* @Author: sfy
* @Date: 2020/2/27 17:05
*/
public enum CommonEnum {

    NO("0", "否"),
    YES("1", "是"),
    SUCCESS("000001", "操作成功")
    ;

    private String code;
    private String name;

    CommonEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
