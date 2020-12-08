package com.changjiang.base.common.lib.exception.exceptions;

import com.changjiang.base.common.lib.exception.base.BaseException;
import com.changjiang.base.common.lib.exception.base.BaseResponseEnum;

/**
 * @author sfy
 * @description 业务异常
 * @date 2020/12/8
 */
public class BusinessException extends BaseException {

    private static final long serialVersionUID = 1L;

    public BusinessException(BaseResponseEnum responseEnum, Object[] args, String message) {
        super(responseEnum, args, message);
    }

    public BusinessException(
            BaseResponseEnum responseEnum, Object[] args, String message, Throwable cause) {
        super(responseEnum, args, message, cause);
    }
}
