package com.changjiang.base.common.lib.model;

/**
 * <h5>系统方法返回值</h5>
 * @param <T>
 */
public class BaseData<T> {

    private String code;
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 备注
     */
    private String message;
    /**
     * 返回实体
     */
    private T data;

    /**
     * 默认构造函数，success = false， this.message = ""
     */
    public BaseData(){
        this.success = false;
        this.message = "";
    }

    /**
     * 通过是否成功标志位及提示构造
     * @param success
     * @param message
     */
    public BaseData(boolean success, String message){
        this.success = success;
        this.message = message;
    }

    /**
     * 用于成功信息构造
     * @param success 状态码
     * @param message 消息
     * @param data 数据
     */
    public BaseData(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
    public BaseData(boolean success, String code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}