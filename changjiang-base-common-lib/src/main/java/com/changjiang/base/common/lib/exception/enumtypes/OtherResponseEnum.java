package com.changjiang.base.common.lib.exception.enumtypes;


import com.changjiang.base.common.lib.exception.base.BaseResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author sfy
 * @description 其他未知异常枚举
 * @date 2020/12/8
 */
@Getter
@AllArgsConstructor
public enum OtherResponseEnum implements BaseResponseEnum {

    SERVER_ERROR("900000", "服务器异常"),
    NETWORK_ERROR("900001", "网络异常"),
    RPC_ERROR("900001", "远程调用异常")
    ;

    /**
     * 返回码
     */
    private String code;
    /**
     * 返回消息
     */
    private String message;
}
