package com.changjiang.base.common.lib.exception.responses;

import com.changjiang.base.common.lib.model.BaseData;

/**
 * @author sfy
 * @description 异常响应结果数据
 * @date 2020/12/8
 */
public class ErrorResponse extends BaseData {

    public ErrorResponse(String code, String message){
        super(false, code, message, null);
    }
}
