<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="org.slf4j.Logger"%>
<%@page import="org.slf4j.LoggerFactory"%>
<%
    Logger log = LoggerFactory.getLogger(getClass());
%>
<%
    log.info("JSP index start");
%>
<%
    String root = request.getContextPath();
    // prevent browser cache
	response.setHeader("Cache-Control", "no-store"); // for HTTP 1.1
	response.setHeader("Pragma", "no-cache");        // for HTTP 1.0
	response.setDateHeader("Expires", 0);            // Expired    
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		<title>EMV 3DS Cloud Demo - Requestor website</title>
		
		<link href="${pageContext.request.contextPath}/webjars/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="${pageContext.request.contextPath}/webjars/font-awesome/css/font-awesome.css" rel="stylesheet" media="screen">
        <link href="${pageContext.request.contextPath}/webjars/jquery-ui/jquery-ui.css" rel="stylesheet" type="text/css">
		
		<style type="text/css">
            body {
                background-color: #f7f7f9;
                padding: 20px 0px;
            }
        </style>
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery/jquery.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery-ui/jquery-ui.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$("input[name*='ubotTxnInfo.browserAcceptHeader']").val(null);
				$("input[name*='ubotTxnInfo.browserJavaEnabled']").val(navigator.javaEnabled());
				$("input[name*='ubotTxnInfo.browserLanguage']").val(navigator.language);
				$("input[name*='ubotTxnInfo.browserColorDepth']").val(screen.colorDepth);
				$("input[name*='ubotTxnInfo.browserScreenHeight']").val(screen.height);
				$("input[name*='ubotTxnInfo.browserScreenWidth']").val(screen.width);
				$("input[name*='ubotTxnInfo.browserTZ']").val(new Date().getTimezoneOffset());
				$("input[name*='ubotTxnInfo.browserUserAgent']").val(navigator.userAgent);
				
				$("#btnSubmit").click(function() {
					$("#form1").submit();
				});
				
				$("#btn3DS1").click(function() { auto3DS1(); });
				$("#btn3DS2").click(function() { auto3DS2(); });
				$("#btnVISA_1").click(function() { autoV1(); });
				$("#btnMASTER_1").click(function() { autoM1(); });
				$("#btnJCB_1").click(function() { autoJ1(); });
			});
			
			function auto3DS1() {
				$("#divCondition1").css("display", "");
				$("#divCondition2").css("display", "none");
				$('#iAcctNumber').val(null);
				$('#iCardExpiryDate').val(null);
				$('#iPurchaseDatetime').val(getDatetime("1.0"));
				autoV1();
			}
			function auto3DS2() {
				$("#divCondition1").css("display", "none");
				$("#divCondition2").css("display", "");
				$('#iAcctNumber').val('4023100079998012');
				$('#iCardExpiryDate').val('2810');
				$("#iAcquirerBIN").val("1231234");
				$("#iAcquirerMerchantID").val("8909191");
				$("#iAcquirerMerchantPwd").val(null);
				$('#iPurchaseDatetime').val(getDatetime("2.0"));
			}
			
			function autoV1() {
				$("#iAcquirerBIN").val("429339");
				$("#iAcquirerMerchantID").val("CT8220130021627");
				$("#iAcquirerMerchantPwd").val("CTcb0022");
			}
			function autoM1() {
				$("#iAcquirerBIN").val("522257");
				$("#iAcquirerMerchantID").val("CT8220130021627");
				$("#iAcquirerMerchantPwd").val("CTcb0022");		
			}
			function autoJ1() {
				$("#iAcquirerBIN").val("13130100");
				$("#iAcquirerMerchantID").val("CT8220130021627");
				$("#iAcquirerMerchantPwd").val("CTcb0022");
			}
			
			function getDatetime(ver) {
				var d = new Date();
				var yyyy = d.getFullYear();
				var MM = d.getMonth() < 9 ? ("0" + (d.getMonth())+1) : (d.getMonth()+1);
				var dd = d.getDate() < 10 ? ("0" + d.getDate()) : d.getDate();
				var hh = d.getHours() < 10 ? ("0" + d.getHours()) : d.getHours();
				var mm = d.getMinutes() < 10 ? ("0" + d.getMinutes()) : d.getMinutes();
				var ss = d.getSeconds() < 10 ? ("0" + d.getSeconds()) : d.getSeconds();
				var str = "";
				/*if (ver == "1.0")
					str += yyyy + MM + dd + " " + hh + ":" + mm + ":" + ss;
				else
					str += yyyy + MM + dd + hh + mm + ss;*/
				str += yyyy;
				str	+= MM ;
				str	+= dd ;
				str	+= hh;
				str	+= mm; 
				str	+= ss;
				
				return str;
			}
		</script>
	</head>
	<body>
		<div class="container" style="">
		
            <form:form id="form1" action="./start" modelAttribute="req" method="POST">
                <form:hidden path="ubotTxnInfo.browserAcceptHeader" />
                <form:hidden path="ubotTxnInfo.browserJavaEnabled" />
                <form:hidden path="ubotTxnInfo.browserLanguage" />
                <form:hidden path="ubotTxnInfo.browserColorDepth" />
                <form:hidden path="ubotTxnInfo.browserScreenHeight" />
                <form:hidden path="ubotTxnInfo.browserScreenWidth" />
                <form:hidden path="ubotTxnInfo.browserTZ" />
                <form:hidden path="ubotTxnInfo.browserUserAgent" />
                <form:hidden path="ubotTxnInfo.browserIP" />

				<div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-success">
                            <div class="panel-heading">
                            	<div class="row">
                            		<div class="col-xs-6">
                            			<i class="fa fa-cog"></i> Request Parameter
                            		</div>
                            		<div class="col-xs-6 text-right">
                            			<a id="btnSubmit" class="btn btn-sm btn-primary" data-loading-text="<i class='fa fa-spinner fa-spin '></i> Processing">Pay</a>
                            		</div>
                            	</div>                          	
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                	<div class="col-xs-12 form-group">
                                		<div class="col-xs-12">
                                        	<label>Receiving Authentication Result in Notification</label>
                                        </div>
                                        <div class="col-xs-6">
	                                        <label class="radio-inline">
	                                        	<form:radiobutton path="reqParameter.enableResult" value="Y"/>
	                                        	Receive
											</label>
										</div>
										<div class="col-xs-6">
											<label class="radio-inline">
												<form:radiobutton path="reqParameter.enableResult" value="N"/>
	                                        	Not Receive
											</label>
										</div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                		<div class="col-xs-12">
                                        	<label>Disable Challenge</label>
                                        </div>
                                        <div class="col-xs-6">
	                                        <label class="radio-inline">
	                                        	<form:radiobutton path="reqParameter.disableChallenge" value="Y"/>
	                                        	Disable
											</label>
										</div>
										<div class="col-xs-6">
											<label class="radio-inline">
												<form:radiobutton path="reqParameter.disableChallenge" value="N"/>
	                                        	Enable
											</label>
										</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-success">
                            <div class="panel-heading">
                            	<div class="row">
                            		<div class="col-xs-6">
                            			<i class="fa fa-cog"></i> Auto Fill-in
                            		</div>
                            	</div>                          	
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                	<div class="col-xs-12 form-group">
                                		<div class="col-xs-12">
                                        	<label>3DS Authentication Condition</label>
                                        </div>
                                        <div class="col-xs-12 form-group">
                                        	<button type="button" class="btn btn-primary" id="btn3DS2">3DS 2.0</button>
	                                       	<button type="button" class="btn btn-primary" id="btn3DS1">3DS 1.0</button>
                                        </div>
	                                    <div id="divCondition2">
	                                        <div class="col-xs-12 form-group">
	                                        	<button type="button" class="btn btn-primary" onclick="$('#iAcctNumber').val('4023100079998012')">VISA</button>
		                                       	<button type="button" class="btn btn-primary" onclick="$('#iAcctNumber').val('5521970079998012')">MASTER</button>
		                                       	<button type="button" class="btn btn-primary" onclick="$('#iAcctNumber').val('3565800079998021')">JCB</button>
	                                        </div>
		                                </div>
		                                <div id="divCondition1" style="display: none;">
	                                        <div class="col-xs-12 form-group">
	                                        	<button type="button" class="btn btn-primary" id="btnVISA_1">VISA</button>
		                                       	<button type="button" class="btn btn-primary" id="btnMASTER_1">MASTER</button>
		                                       	<button type="button" class="btn btn-primary" id="btnJCB_1">JCB</button>
	                                        </div>
		                                </div>
	                                </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
				
				<div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-success">
                            <div class="panel-heading"><i class="fa fa-credit-card"></i> Transaction Information</div>
                            <div class="panel-body">
                            	<div class="row">
                            		<div class="col-xs-12 form-group">
                            			<span class="label label-danger">Requested Fields</span>
                            		</div>
                            	</div>
                            	<div class="row">
                            		<div class="col-xs-12 form-group">
                                        <label>Cardholder Account Number</label>
                                        <div class="input-group">
                                            <form:input id="iAcctNumber" path="ubotTxnInfo.acctNumber" cssClass="form-control" maxlength="19"/>
                                            <span class="input-group-addon"><i class="fa fa-credit-card"></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Card/Token Expiry Date</label>
                                        <div class="input-group">
                                            <form:input id="iCardExpiryDate" path="ubotTxnInfo.cardExpiryDate" placeholder="YYMM" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                            		<div class="col-xs-12 form-group">
                                        <label>Proprietary Message Version Number</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.pMessageVersion" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>3DS Requestor Authentication Indicator</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.validationRequestorAuthenticationInd" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>3DS Requestor ID</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.validationRequestorID" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>3DS Requestor Name</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.validationRequestorName" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Acquirer BIN</label>
                                        <div class="input-group">
                                            <form:input id="iAcquirerBIN" path="ubotTxnInfo.acquirerBIN" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Acquirer Merchant ID</label>
                                        <div class="input-group">
                                            <form:input id="iAcquirerMerchantID" path="ubotTxnInfo.acquirerMerchantID" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Acquirer Merchant Password (for 3DS 1.0)</label>
                                        <div class="input-group">
                                            <form:input id="iAcquirerMerchantPwd" path="ubotTxnInfo.acquirerMerchantPwd" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
  
    
                                    <div class="col-xs-12 form-group">
                                        <label>Message Category</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.messageCategory" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Purchase Amount</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.purchaseAmount" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
   

                                    <div class="col-xs-12 form-group">
                                        <label>Purchase Date & Time</label>
                                        <div class="input-group">
                                            <form:input id="iPurchaseDatetime" path="ubotTxnInfo.purchaseDate" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                            	</div>
                            	
                            	
                            	
                            	<div class="row">
                            		<div class="col-xs-12 form-group">
                            			<span class="label label-warning">Optional Fields</span>
                            		</div>
                            	</div>
                                <div class="row">
                                    <div class="col-xs-12 form-group">
                                        <label>3DS Requestor Challenge Indicator</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.validationRequestorChallengeInd" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>3DS Requestor Order ID</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.validationRequestorOrderID" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>3DS Requestor Data</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.validationRequestorData" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Account Type</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.acctType" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Address Match Indicator</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.addrMatch" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Cardholder Account Identifier</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.acctID" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Cardholder Billing Address City</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.billAddrCity" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Cardholder Billing Address Country</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.billAddrCountry" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Cardholder Billing Address Line 1</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.billAddrLine1" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Cardholder Billing Address Line 2</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.billAddrLine2" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Cardholder Billing Address Line 3</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.billAddrLine3" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Cardholder Billing Address Postal Code</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.billAddrPostCode" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Cardholder Billing Address State</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.billAddrState" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Cardholder Email Address</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.email" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Home Phone's Country Code</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.homeCC" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Home Phone's Subscriber</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.homeSubscriber" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Mobile Phone's Country Code</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.mobileCC" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Mobile Phone's Subscriber</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.mobileSubscriber" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
									<div class="col-xs-12 form-group">
                                        <label>Cardholder Name</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.cardholderName" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Cardholder Shipping Address City</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.shipAddrCity" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Cardholder Shipping Address Country</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.shipAddrCountry" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Cardholder Shipping Address Line 1</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.shipAddrLine1" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Cardholder Shipping Address Line 2</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.shipAddrLine2" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Cardholder Shipping Address Line 3</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.shipAddrLine3" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Cardholder Shipping Address State</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.shipAddrPostCode" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Work Phone's Country Code</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.workCC" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Work Phone's Subscriber</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.workSubscriber" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>EMV Payment Token Indicator</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.payTokenInd" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Instalment Payment Data</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.purchaseInstalData" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Recurring Expiry</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.recurringExpiry" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Recurring Frequency</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.recurringFrequency" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Trans Type</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.transType" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>3RI Indicator</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.threeRIInd" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                    <div class="col-xs-12 form-group">
                                        <label>Purchase Description (for 3DS 1.0)</label>
                                        <div class="input-group">
                                            <form:input path="ubotTxnInfo.purchaseDesc" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
				
				<div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-success">
                            <div class="panel-heading"><i class="fa fa-lock"></i> Risk Information</div>
                            <div class="panel-body">
                            	<div class="row">
                            		<div class="col-xs-12 form-group">
                            			<span class="label label-warning">All Optional Fields</span>
                            		</div>
                            	</div>
                                <div class="row">
                                	<div class="col-xs-12 form-group">
                                        <label>Cardholder Account Age Indicator</label>
                                        <div class="input-group">
                                            <form:input path="riskInfo.chAccAgeInd" cssClass="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form:form>

        </div>
	</body>
</html>