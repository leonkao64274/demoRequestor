package com.demo.req.emv.validation.demo.requestor.model;

public class BaseResponse {

	/**
	 * 錯誤代碼
	 */
	private String errCode;
	
	/**
	 * 錯誤訊息
	 */
	private String errMsg;
	
	public BaseResponse() {
		this.errCode = "4001";
		this.errMsg = "";
	}
	
	public String getErrCode() {
		return errCode;
	}
	
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	
	public String getErrMsg() {
		return errMsg;
	}
	
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
}
