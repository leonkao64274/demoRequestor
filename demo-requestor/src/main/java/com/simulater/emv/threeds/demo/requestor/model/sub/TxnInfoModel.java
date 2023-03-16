package com.demo.req.emv.validation.demo.requestor.model.sub;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.demo.req.emv.validation.demo.requestor.model.MessageExtension;

public class TxnInfoModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("p_messageVersion")
	private String pMessageVersion;
	
	private String validationRequestorAuthenticationInd;
	
	private String validationRequestorChallengeInd;
	
    private String validationRequestorID;
	
    private String validationRequestorName;

    private String validationRequestorURL;
	
	private String validationRequestorOrderID;
	
	private String validationRequestorData;
	
	private String acctType;
	
	private String acquirerBIN;
	
	private String acquirerMerchantID;
	
	private String acquirerMerchantPwd;
	
	private String broadInfo;
	
	private String addrMatch;
	
	private String browserAcceptHeader;
	
	private String browserIP;
	
	private Boolean browserJavaEnabled;
	
	private String browserLanguage;
	
	private String browserColorDepth;
	
	private String browserScreenHeight;
	
	private String browserScreenWidth;
	
	private String browserTZ;
	
	private String browserUserAgent;
	
	private String cardExpiryDate;
	
	private String acctNumber;
	
	private String acctID;
	
	private String billAddrCity;
	
	private String billAddrCountry;
	
	private String billAddrLine1;
	
	private String billAddrLine2;
	
	private String billAddrLine3;
	
	private String billAddrPostCode;
	
	private String billAddrState;
	
	private String email;
	
	private String homeCC;
	
	private String homeSubscriber;
	
	private String mobileCC;
	
	private String mobileSubscriber;
	
	private String cardholderName;
	
	private String shipAddrCity;
	
	private String shipAddrCountry;
	
	private String shipAddrLine1;
	
	private String shipAddrLine2;
	
	private String shipAddrLine3;
	
	private String shipAddrPostCode;
	
	private String workCC;
	
	private String workSubscriber;
	
	private Boolean payTokenInd;
	
	private String purchaseInstalData;
	
	private String mcc;
	
	private String merchantCountryCode;
	
	private String merchantName;
	
	private String messageCategory;
	
	private MessageExtension[] messageExtension;
	
	private String purchaseAmount;
	
	private String purchaseCurrency;
	
	private String purchaseExponent;
	
	private String purchaseDate;
	
	private String purchaseDesc;
	
	private String recurringExpiry;
	
	private String recurringFrequency;
	
	private String transType;
	
//	private String deviceChannel;
	
	private String threeRIInd;
	
	public TxnInfoModel() {
		super();
	}

	public String getpMessageVersion() {
		return pMessageVersion;
	}

	public void setpMessageVersion(String pMessageVersion) {
		this.pMessageVersion = pMessageVersion;
	}

	public String getvalidationRequestorAuthenticationInd() {
		return validationRequestorAuthenticationInd;
	}

	public void setvalidationRequestorAuthenticationInd(String validationRequestorAuthenticationInd) {
		this.validationRequestorAuthenticationInd = validationRequestorAuthenticationInd;
	}

	public String getvalidationRequestorChallengeInd() {
		return validationRequestorChallengeInd;
	}

	public void setvalidationRequestorChallengeInd(String validationRequestorChallengeInd) {
		this.validationRequestorChallengeInd = validationRequestorChallengeInd;
	}

	public String getvalidationRequestorID() {
		return validationRequestorID;
	}

	public void setvalidationRequestorID(String validationRequestorID) {
		this.validationRequestorID = validationRequestorID;
	}

	public String getvalidationRequestorName() {
		return validationRequestorName;
	}

	public void setvalidationRequestorName(String validationRequestorName) {
		this.validationRequestorName = validationRequestorName;
	}

	public String getvalidationRequestorURL() {
		return validationRequestorURL;
	}

	public void setvalidationRequestorURL(String validationRequestorURL) {
		this.validationRequestorURL = validationRequestorURL;
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

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	public String getAcquirerBIN() {
		return acquirerBIN;
	}

	public void setAcquirerBIN(String acquirerBIN) {
		this.acquirerBIN = acquirerBIN;
	}

	public String getAcquirerMerchantID() {
		return acquirerMerchantID;
	}

	public void setAcquirerMerchantID(String acquirerMerchantID) {
		this.acquirerMerchantID = acquirerMerchantID;
	}

	public String getAcquirerMerchantPwd() {
		return acquirerMerchantPwd;
	}

	public void setAcquirerMerchantPwd(String acquirerMerchantPwd) {
		this.acquirerMerchantPwd = acquirerMerchantPwd;
	}

	public String getBroadInfo() {
		return broadInfo;
	}

	public void setBroadInfo(String broadInfo) {
		this.broadInfo = broadInfo;
	}

	public String getAddrMatch() {
		return addrMatch;
	}

	public void setAddrMatch(String addrMatch) {
		this.addrMatch = addrMatch;
	}

	public String getBrowserAcceptHeader() {
		return browserAcceptHeader;
	}

	public void setBrowserAcceptHeader(String browserAcceptHeader) {
		this.browserAcceptHeader = browserAcceptHeader;
	}

	public String getBrowserIP() {
		return browserIP;
	}

	public void setBrowserIP(String browserIP) {
		this.browserIP = browserIP;
	}

	public Boolean getBrowserJavaEnabled() {
		return browserJavaEnabled;
	}

	public void setBrowserJavaEnabled(Boolean browserJavaEnabled) {
		this.browserJavaEnabled = browserJavaEnabled;
	}

	public String getBrowserLanguage() {
		return browserLanguage;
	}

	public void setBrowserLanguage(String browserLanguage) {
		this.browserLanguage = browserLanguage;
	}

	public String getBrowserColorDepth() {
		return browserColorDepth;
	}

	public void setBrowserColorDepth(String browserColorDepth) {
		this.browserColorDepth = browserColorDepth;
	}

	public String getBrowserScreenHeight() {
		return browserScreenHeight;
	}

	public void setBrowserScreenHeight(String browserScreenHeight) {
		this.browserScreenHeight = browserScreenHeight;
	}

	public String getBrowserScreenWidth() {
		return browserScreenWidth;
	}

	public void setBrowserScreenWidth(String browserScreenWidth) {
		this.browserScreenWidth = browserScreenWidth;
	}

	public String getBrowserTZ() {
		return browserTZ;
	}

	public void setBrowserTZ(String browserTZ) {
		this.browserTZ = browserTZ;
	}

	public String getBrowserUserAgent() {
		return browserUserAgent;
	}

	public void setBrowserUserAgent(String browserUserAgent) {
		this.browserUserAgent = browserUserAgent;
	}

	public String getCardExpiryDate() {
		return cardExpiryDate;
	}

	public void setCardExpiryDate(String cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}

	public String getAcctNumber() {
		return acctNumber;
	}

	public void setAcctNumber(String acctNumber) {
		this.acctNumber = acctNumber;
	}

	public String getAcctID() {
		return acctID;
	}

	public void setAcctID(String acctID) {
		this.acctID = acctID;
	}

	public String getBillAddrCity() {
		return billAddrCity;
	}

	public void setBillAddrCity(String billAddrCity) {
		this.billAddrCity = billAddrCity;
	}

	public String getBillAddrCountry() {
		return billAddrCountry;
	}

	public void setBillAddrCountry(String billAddrCountry) {
		this.billAddrCountry = billAddrCountry;
	}

	public String getBillAddrLine1() {
		return billAddrLine1;
	}

	public void setBillAddrLine1(String billAddrLine1) {
		this.billAddrLine1 = billAddrLine1;
	}

	public String getBillAddrLine2() {
		return billAddrLine2;
	}

	public void setBillAddrLine2(String billAddrLine2) {
		this.billAddrLine2 = billAddrLine2;
	}

	public String getBillAddrLine3() {
		return billAddrLine3;
	}

	public void setBillAddrLine3(String billAddrLine3) {
		this.billAddrLine3 = billAddrLine3;
	}

	public String getBillAddrPostCode() {
		return billAddrPostCode;
	}

	public void setBillAddrPostCode(String billAddrPostCode) {
		this.billAddrPostCode = billAddrPostCode;
	}

	public String getBillAddrState() {
		return billAddrState;
	}

	public void setBillAddrState(String billAddrState) {
		this.billAddrState = billAddrState;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomeCC() {
		return homeCC;
	}

	public void setHomeCC(String homeCC) {
		this.homeCC = homeCC;
	}

	public String getHomeSubscriber() {
		return homeSubscriber;
	}

	public void setHomeSubscriber(String homeSubscriber) {
		this.homeSubscriber = homeSubscriber;
	}

	public String getMobileCC() {
		return mobileCC;
	}

	public void setMobileCC(String mobileCC) {
		this.mobileCC = mobileCC;
	}

	public String getMobileSubscriber() {
		return mobileSubscriber;
	}

	public void setMobileSubscriber(String mobileSubscriber) {
		this.mobileSubscriber = mobileSubscriber;
	}

	public String getCardholderName() {
		return cardholderName;
	}

	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}

	public String getShipAddrCity() {
		return shipAddrCity;
	}

	public void setShipAddrCity(String shipAddrCity) {
		this.shipAddrCity = shipAddrCity;
	}

	public String getShipAddrCountry() {
		return shipAddrCountry;
	}

	public void setShipAddrCountry(String shipAddrCountry) {
		this.shipAddrCountry = shipAddrCountry;
	}

	public String getShipAddrLine1() {
		return shipAddrLine1;
	}

	public void setShipAddrLine1(String shipAddrLine1) {
		this.shipAddrLine1 = shipAddrLine1;
	}

	public String getShipAddrLine2() {
		return shipAddrLine2;
	}

	public void setShipAddrLine2(String shipAddrLine2) {
		this.shipAddrLine2 = shipAddrLine2;
	}

	public String getShipAddrLine3() {
		return shipAddrLine3;
	}

	public void setShipAddrLine3(String shipAddrLine3) {
		this.shipAddrLine3 = shipAddrLine3;
	}

	public String getShipAddrPostCode() {
		return shipAddrPostCode;
	}

	public void setShipAddrPostCode(String shipAddrPostCode) {
		this.shipAddrPostCode = shipAddrPostCode;
	}

	public String getWorkCC() {
		return workCC;
	}

	public void setWorkCC(String workCC) {
		this.workCC = workCC;
	}

	public String getWorkSubscriber() {
		return workSubscriber;
	}

	public void setWorkSubscriber(String workSubscriber) {
		this.workSubscriber = workSubscriber;
	}

	public Boolean getPayTokenInd() {
		return payTokenInd;
	}

	public void setPayTokenInd(Boolean payTokenInd) {
		this.payTokenInd = payTokenInd;
	}

	public String getPurchaseInstalData() {
		return purchaseInstalData;
	}

	public void setPurchaseInstalData(String purchaseInstalData) {
		this.purchaseInstalData = purchaseInstalData;
	}

	public String getMcc() {
		return mcc;
	}

	public void setMcc(String mcc) {
		this.mcc = mcc;
	}

	public String getMerchantCountryCode() {
		return merchantCountryCode;
	}

	public void setMerchantCountryCode(String merchantCountryCode) {
		this.merchantCountryCode = merchantCountryCode;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMessageCategory() {
		return messageCategory;
	}

	public void setMessageCategory(String messageCategory) {
		this.messageCategory = messageCategory;
	}

	public MessageExtension[] getMessageExtension() {
		return messageExtension;
	}

	public void setMessageExtension(MessageExtension[] messageExtension) {
		this.messageExtension = messageExtension;
	}

	public String getPurchaseAmount() {
		return purchaseAmount;
	}

	public void setPurchaseAmount(String purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public String getPurchaseCurrency() {
		return purchaseCurrency;
	}

	public void setPurchaseCurrency(String purchaseCurrency) {
		this.purchaseCurrency = purchaseCurrency;
	}

	public String getPurchaseExponent() {
		return purchaseExponent;
	}

	public void setPurchaseExponent(String purchaseExponent) {
		this.purchaseExponent = purchaseExponent;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getPurchaseDesc() {
		return purchaseDesc;
	}

	public void setPurchaseDesc(String purchaseDesc) {
		this.purchaseDesc = purchaseDesc;
	}

	public String getRecurringExpiry() {
		return recurringExpiry;
	}

	public void setRecurringExpiry(String recurringExpiry) {
		this.recurringExpiry = recurringExpiry;
	}

	public String getRecurringFrequency() {
		return recurringFrequency;
	}

	public void setRecurringFrequency(String recurringFrequency) {
		this.recurringFrequency = recurringFrequency;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

//	public String getDeviceChannel() {
//		return deviceChannel;
//	}
//
//	public void setDeviceChannel(String deviceChannel) {
//		this.deviceChannel = deviceChannel;
//	}

	public String getThreeRIInd() {
		return threeRIInd;
	}

	public void setThreeRIInd(String threeRIInd) {
		this.threeRIInd = threeRIInd;
	}
	
}
