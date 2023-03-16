

import java.io.Serializable;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.demo.req.emv.validation.demo.requestor.model.sub.ReqParameterModel;
import com.demo.req.emv.validation.demo.requestor.model.sub.RiskInfoModel;
import com.demo.req.emv.validation.demo.requestor.model.sub.TxnInfoModel;
import com.demo.req.emv.validation.demo.requestor.model.sub.UbotTxnInfoModel;

public class AuthInitializerReq implements Serializable {

	private static final long serialVersionUID = 1L;

	@Valid
	@JsonProperty("reqParameter") 
	private ReqParameterModel reqParameter;
	
	@Valid
	@JsonProperty("txnInfo") 
	private UbotTxnInfoModel ubotTxnInfo;
	
	@Valid
	@JsonProperty("riskInfo") 
	private RiskInfoModel riskInfo;

	public AuthInitializerReq() {
		super();
	}

	public ReqParameterModel getReqParameter() {
		return reqParameter;
	}

	public void setReqParameter(ReqParameterModel reqParameter) {
		this.reqParameter = reqParameter;
	}


	public UbotTxnInfoModel getUbotTxnInfo() {
		return ubotTxnInfo;
	}

	public void setUbotTxnInfo(UbotTxnInfoModel ubotTxnInfo) {
		this.ubotTxnInfo = ubotTxnInfo;
	}

	public RiskInfoModel getRiskInfo() {
		return riskInfo;
	}

	public void setRiskInfo(RiskInfoModel riskInfo) {
		this.riskInfo = riskInfo;
	}
	
}
