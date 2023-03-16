

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;




@Controller
public class IndexController {
	
	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private AppProperties appProperties;
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index(Model model) {
		logger.debug("===> index");
		// 設定表單預設值(2.0 VISA)
		AuthInitializerReq req = new AuthInitializerReq();
		ReqParameterModel reqParameter = new ReqParameterModel();
		// 必填
		reqParameter.setEnableResult("N");
		
		UbotTxnInfoModel ubotTxnInfo = new UbotTxnInfoModel();
		// 必填
		ubotTxnInfo.setAcctNumber("4023100079998012");
		ubotTxnInfo.setpMessageVersion("1.0.1");
		ubotTxnInfo.setvalidationRequestorAuthenticationInd("01");
		ubotTxnInfo.setvalidationRequestorID("12128301823081230123");
		ubotTxnInfo.setvalidationRequestorName(" EMV 3DS Demo Site");
		ubotTxnInfo.setAcquirerBIN("1231234");
		ubotTxnInfo.setAcquirerMerchantID("8909191");
		ubotTxnInfo.setCardExpiryDate("2810");
		ubotTxnInfo.setMessageCategory("01");
		ubotTxnInfo.setPurchaseAmount("100");
		ubotTxnInfo.setPurchaseDate(DateTimeUtil.getCurrentDateTime());

		
		RiskInfoModel riskInfo = new RiskInfoModel();
		// 非必填
		riskInfo.setChAccAgeInd("01");
		
		req.setReqParameter(reqParameter);
		req.setUbotTxnInfo(ubotTxnInfo);
		req.setRiskInfo(riskInfo);
		logger.debug("initset ok");
		model.addAttribute("req", req);
		logger.debug("model add ok");
		
		return "index";
	}
	
	@RequestMapping(path = "/start", method = RequestMethod.POST)
	public String start(AuthInitializerReq form, Model model, HttpServletRequest request) {
		logger.debug("===> start");
		form.getReqParameter().setClientMode("2");
		form.getReqParameter().setNotificationURL(this.appProperties.getFinishUrl());
		form.getUbotTxnInfo().setBrowserAcceptHeader(request.getHeader("Accept"));
		
		// HTTP Basic Authentication
		String userInfo = this.appProperties.getRequestorId() + ":" + this.appProperties.getRequestorPwd();
		logger.debug("appProperties.getRequestorId()=[" + appProperties.getRequestorId() + "], appProperties.getRequestorPwd()=[" + appProperties.getRequestorPwd() + "]");
		String base64UserInfo = Base64Utils.encodeToUrlSafeString(userInfo.getBytes());
		
		// 初始化驗證請求
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64UserInfo);
		HttpEntity<AuthInitializerReq> entity = new HttpEntity<AuthInitializerReq>(form, headers);
		AuthInitializerRes res = this.restTemplate.postForObject(
				this.appProperties.getInitializeApi(), 
				entity, 
				AuthInitializerRes.class);
		
		model.addAttribute("validationIntegratorOid", res.getvalidationIntegratorOid());
		model.addAttribute("validationAuthURL", res.getvalidationAuthURL());
		model.addAttribute("errCode", res.getErrCode());
		model.addAttribute("errMsg", res.getErrMsg());
		
		return "start";
	}
	
	@RequestMapping(path = "/finish/test", method = RequestMethod.GET)
	public String testFinish(Model model) {
		logger.debug("===> testFinish");
		AuthResultRes res = new AuthResultRes();
		res.setvalidationIntegratorOid("1");
		res.setvalidationServerTransID("2");
		res.setvalidationRequestorID("000000");
		res.setvalidationRequestorOrderID("O_000000001_I");
		res.setvalidationRequestorData("3DS requestor/merchant Data");
		res.setEci("ECI");
		res.setAuthenticationValue("AUTHENTICATION VALUE");
		res.setTransStatus("00");
		model.addAttribute("result", res);
		
		return "finish";
	}
	
	@RequestMapping(path = "/finish", method = RequestMethod.POST)
	public String finish(AuthResultRes form, Model model) {
		logger.debug("===> finish");
		if ("4001".equals(form.getErrCode()) && form.getEci() == null && form.getAuthenticationValue() == null) {
			// 查詢驗證結果
			AuthResultReq req = new AuthResultReq();
			req.setvalidationIntegratorOid(form.getvalidationIntegratorOid());
			
			// HTTP Basic Authentication
			String userInfo = this.appProperties.getRequestorId() + ":" + this.appProperties.getRequestorPwd();
			String base64UserInfo = Base64Utils.encodeToUrlSafeString(userInfo.getBytes());
			
			// 初始化驗證請求
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Basic " + base64UserInfo);
			HttpEntity<AuthResultReq> entity = new HttpEntity<AuthResultReq>(req, headers);
			AuthResultRes res = this.restTemplate.postForObject(
					this.appProperties.getQueryApi(), 
					entity, 
					AuthResultRes.class);
			model.addAttribute("result", res);
			
		} else {
			logger.debug(form.getErrMsg());
			model.addAttribute("result", form);
		}
		
		return "finish";
	}
	
	@RequestMapping(path = "/query", method = RequestMethod.GET)
	public String query(Model model) {
		logger.debug("===> query");
		AuthResultRes res = new AuthResultRes();
		model.addAttribute("result", res);
		
		return "query";
	}
	
	@RequestMapping(path = "/query", method = RequestMethod.POST)
	public String queryResult(String validationIntegratorOid, Model model) {
		logger.debug("===> queryResult, validationIntegratorOid = " + validationIntegratorOid);
		AuthResultReq req = new AuthResultReq();
		req.setvalidationIntegratorOid(validationIntegratorOid);
		
		// HTTP Basic Authentication
		String userInfo = this.appProperties.getRequestorId() + ":" + this.appProperties.getRequestorPwd();
		String base64UserInfo = Base64Utils.encodeToUrlSafeString(userInfo.getBytes());
				
		// 初始化驗證請求
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64UserInfo);
		HttpEntity<AuthResultReq> entity = new HttpEntity<AuthResultReq>(req, headers);
		AuthResultRes res = this.restTemplate.postForObject(
				this.appProperties.getQueryApi(), 
				entity, 
				AuthResultRes.class);
		model.addAttribute("result", res);
		
		return "query";
	}
	
}
