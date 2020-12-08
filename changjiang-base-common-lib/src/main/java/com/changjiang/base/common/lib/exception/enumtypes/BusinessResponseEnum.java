package com.changjiang.base.common.lib.exception.enumtypes;

import com.changjiang.base.common.lib.exception.asserts.BusinessExceptionAssert;
import com.changjiang.base.common.lib.exception.asserts.BusinessExceptionAssert;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author sfy
 * @description 业务异常枚举
 * @date 2020/12/8
 */
@Getter
@AllArgsConstructor
public enum BusinessResponseEnum implements BusinessExceptionAssert {

    /**
     * 操作失败相关枚举
     */
    PARAM_NULL("100000", "参数绑定异常"),
    PARAM_INVALID("100001", "参数校验失败"),
    DATA_INVALID("100002", "数据校验错误"),
    TOKEN_INVALID("100003", "表单失效，请刷新后再重新提交"),
    TOKEN_NULL("100004", "表单提交错误，请刷新后再重新提交"),
    NO_DATA("100005", "数据加载失败"),
    STATUS_ERROR("100006", "操作状态有误，请刷新后再重试"),
    UPLOAD_FAIL("100007", "上传失败"),
    DOWNLOAD_FAIL("100008", "下载失败"),
    IMPORT_FAIL("100009", "导入失败"),
    EXPORT_FAIL("100010", "导出失败"),
    GET_VERIFICATION_CODE_FAI("100011", "验证码获取失败"),

    /**
     * 权限相关枚举
     */
    UN_AUTHORITY("200000", "未授权操作"),
    UN_LOGIN("200001", "未登录"),
    BLACK_ID("200002", "非法操作"),
    USER_INVALID("200003", "用户无效"),

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
