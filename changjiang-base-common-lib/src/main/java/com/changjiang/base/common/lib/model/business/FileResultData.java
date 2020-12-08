package com.changjiang.base.common.lib.model.business;

import com.changjiang.base.common.lib.model.BaseData;

/**
 * @author sfy
 * @description 文件操作返回情况实体
 * @date 2019/5/29 11:09
 */
@SuppressWarnings("all")
public class FileResultData<T> extends BaseData {

    public FileResultData(){
        super();
    }
    public FileResultData(boolean success, String msg){
        super(success, msg);
    }

    /**
     * 返回文件上传的路径
     */
    private String filePath;
    /**
     * 返回文件名称
     */
    private String fileName;
    
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}