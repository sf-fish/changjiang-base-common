package com.changjiang.base.common.lib.exception.base;

/**
 * @author sfy
 * @description 基础异常信息枚举
 * @date 2020/12/8
 */
public interface BaseResponseEnum {
    /**
     * 操作代码
     */
    String getCode();
    /**
     * 操作信息
     */
    String getMessage();
}
