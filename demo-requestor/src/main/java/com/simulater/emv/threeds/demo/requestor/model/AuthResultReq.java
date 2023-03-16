package com.demo.req.emv.validation.demo.requestor.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class AuthResultReq implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotEmpty
	private String validationIntegratorOid;

	public String getvalidationIntegratorOid() {
		return validationIntegratorOid;
	}

	public void setvalidationIntegratorOid(String validationIntegratorOid) {
		this.validationIntegratorOid = validationIntegratorOid;
	}
	
}
