package com.demo.req.emv.validation.demo.requestor.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {

	@Value("${3ds.integrator.api.initialize-auth}")
	private String initializeApi;
	
	@Value("${3ds.integrator.api.query-authResult}")
	private String queryApi;
	
	@Value("${app.url.result}")
	private String finishUrl;
	
	@Value("${app.url.index}")
	private String indexUrl;
	
	@Value("${app.requestor.id}")
	private String requestorId;
	
	@Value("${app.requestor.pwd}")
	private String requestorPwd;

	public String getInitializeApi() {
		return initializeApi;
	}

	public void setInitializeApi(String initializeApi) {
		this.initializeApi = initializeApi;
	}

	public String getQueryApi() {
		return queryApi;
	}

	public void setQueryApi(String queryApi) {
		this.queryApi = queryApi;
	}

	public String getFinishUrl() {
		return finishUrl;
	}

	public void setFinishUrl(String finishUrl) {
		this.finishUrl = finishUrl;
	}

	public String getIndexUrl() {
		return indexUrl;
	}

	public void setIndexUrl(String indexUrl) {
		this.indexUrl = indexUrl;
	}

	public String getRequestorId() {
		return requestorId;
	}

	public void setRequestorId(String requestorId) {
		this.requestorId = requestorId;
	}

	public String getRequestorPwd() {
		return requestorPwd;
	}

	public void setRequestorPwd(String requestorPwd) {
		this.requestorPwd = requestorPwd;
	}
	
}
