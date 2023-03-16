package com.demo.req.emv.validation.demo.requestor.model.sub;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

public class ReqParameterModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotEmpty
	@Pattern(regexp = "^[1-3]$", message = "must be 1,2,3")
	private String clientMode;
	
	@NotEmpty
	@Length(max = 256, message = "must be maximum 256 characters")
	private String notificationURL;
	
	@NotEmpty
	@Pattern(regexp = "(Y|N)", message = "must be Y,N")
	private String enableResult;
	
	@Pattern(regexp = "(Y|N)", message = "must be Y,N")
	private String disableChallenge = "N";
	
	public ReqParameterModel() {
		super();
	}

	public ReqParameterModel(String clientMode, String notificationURL, String enableResult, String disableChallenge) {
		super();
		this.clientMode = clientMode;
		this.notificationURL = notificationURL;
		this.enableResult = enableResult;
		this.disableChallenge = disableChallenge;
	}

	public String getClientMode() {
		return clientMode;
	}

	public void setClientMode(String clientMode) {
		this.clientMode = clientMode;
	}

	public String getNotificationURL() {
		return notificationURL;
	}

	public void setNotificationURL(String notificationURL) {
		this.notificationURL = notificationURL;
	}

	public String getEnableResult() {
		return enableResult;
	}

	public void setEnableResult(String enableResult) {
		this.enableResult = enableResult;
	}
	
	public String getDisableChallenge() {
		return disableChallenge;
	}

	public void setDisableChallenge(String disableChallenge) {
		this.disableChallenge = disableChallenge;
	}
	
}
