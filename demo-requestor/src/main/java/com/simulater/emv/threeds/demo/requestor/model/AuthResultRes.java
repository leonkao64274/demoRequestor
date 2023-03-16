package com.demo.req.emv.validation.demo.requestor.model;

import java.io.Serializable;

public class AuthResultRes extends BaseResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String validationIntegratorOid;
	
	private String validationRequestorOrderID;
	
	private String validationRequestorData;
	
	private String validationRequestorID;
	
	private String validationServerTransID;
	
	private String acsTransID;
	
	private String dsTransID;
	
	private String transStatus;
	
	private String transStatusReason;
	
	private String authenticationValue;
	
	private String eci;

	public String getvalidationIntegratorOid() {
		return validationIntegratorOid;
	}

	public void setvalidationIntegratorOid(String validationIntegratorOid) {
		this.validationIntegratorOid = validationIntegratorOid;
	}

	public String getvalidationRequestorOrderID() {
		return validationRequestorOrderID;
	}

	public void setvalidationRequestorOrderID(String validationRequestorOrderID) {
		this.validationRequestorOrderID = validationRequestorOrderID;
	}

	public String getvalidationRequestorData() {
		return validationRequestorData;
	}

	public void setvalidationRequestorData(String validationRequestorData) {
		this.validationRequestorData = validationRequestorData;
	}

	public String getvalidationRequestorID() {
		return validationRequestorID;
	}

	public void setvalidationRequestorID(String validationRequestorID) {
		this.validationRequestorID = validationRequestorID;
	}

	public String getvalidationServerTransID() {
		return validationServerTransID;
	}

	public void setvalidationServerTransID(String validationServerTransID) {
		this.validationServerTransID = validationServerTransID;
	}

	public String getAcsTransID() {
		return acsTransID;
	}

	public void setAcsTransID(String acsTransID) {
		this.acsTransID = acsTransID;
	}

	public String getDsTransID() {
		return dsTransID;
	}

	public void setDsTransID(String dsTransID) {
		this.dsTransID = dsTransID;
	}

	public String getTransStatus() {
		return transStatus;
	}

	public void setTransStatus(String transStatus) {
		this.transStatus = transStatus;
	}

	public String getTransStatusReason() {
		return transStatusReason;
	}

	public void setTransStatusReason(String transStatusReason) {
		this.transStatusReason = transStatusReason;
	}

	public String getAuthenticationValue() {
		return authenticationValue;
	}

	public void setAuthenticationValue(String authenticationValue) {
		this.authenticationValue = authenticationValue;
	}

	public String getEci() {
		return eci;
	}

	public void setEci(String eci) {
		this.eci = eci;
	}
	
}
