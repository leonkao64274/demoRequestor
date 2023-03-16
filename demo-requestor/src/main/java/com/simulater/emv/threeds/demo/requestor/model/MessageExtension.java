package com.demo.req.emv.validation.demo.requestor.model;

import java.io.Serializable;

public class MessageExtension implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	
    private String name;
	
	private Boolean criticalityIndicator;
	
    private Object data;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getCriticalityIndicator() {
		return criticalityIndicator;
	}

	public void setCriticalityIndicator(Boolean criticalityIndicator) {
		this.criticalityIndicator = criticalityIndicator;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
    
}
