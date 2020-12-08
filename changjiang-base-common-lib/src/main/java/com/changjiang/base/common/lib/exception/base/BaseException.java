package com.changjiang.base.common.lib.exception.base;

import lombok.Getter;
import lombok.ToString;

/**
 * @author sfy
 * @description 基础异常类
 * @date 2020/12/7
 */
@Getter
@ToString
public class BaseException extends RuntimeException {

    private BaseResponseEnum responseEnum;
    private Object[] args;
    private String message;
    private Throwable cause;

    public BaseException(BaseResponseEnum responseEnum){
        this.responseEnum = responseEnum;
    }

    public BaseException(BaseResponseEnum responseEnum, Object[] args, String message){
        this.responseEnum = responseEnum;
        this.args = args;
        this.message = message;
    }

    public BaseException(
            BaseResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        this.responseEnum = responseEnum;
        this.args = args;
        this.message = message;
        this.cause = cause;
    }
}

