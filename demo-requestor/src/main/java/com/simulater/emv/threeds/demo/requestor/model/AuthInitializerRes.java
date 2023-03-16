package com.demo.req.emv.validation.demo.requestor.model;

import java.io.Serializable;

public class AuthInitializerRes extends BaseResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String acctNumber;
	
	private String validationIntegratorOid;
	
	private String validationAuthURL;

	public AuthInitializerRes() {
		super();
	}

	public String getAcctNumber() {
		return acctNumber;
	}

	public void setAcctNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}

	public String getvalidationIntegratorOid() {
		return validationIntegratorOid;
	}

	public void setvalidationIntegratorOid(String validationIntegratorOid) {
		this.validationIntegratorOid = validationIntegratorOid;
	}

	public String getvalidationAuthURL() {
		return validationAuthURL;
	}

	public void setvalidationAuthURL(String validationAuthURL) {
		this.validationAuthURL = validationAuthURL;
	}
	
}
