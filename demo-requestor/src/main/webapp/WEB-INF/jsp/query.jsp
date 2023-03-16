<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				$("#btnSubmit").click(function() {
					if ($("#iOid").val()) 
						$("#form1").submit();
					else
						alert("請輸入欲查詢的OID");
				});
			});
		</script>
	</head>
	<body>
		<div class="container" style="">
			
			<form id="form1" action="" method="POST">
				<div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-success">
                            <div class="panel-heading">
                            	<div class="row">
                            		<div class="col-xs-6">
                            			<i class="fa fa-cog"></i> Query Parameter
                            		</div>
                            		<div class="col-xs-6 text-right">
                            			<a id="btnSubmit" class="btn btn-sm btn-primary" data-loading-text="<i class='fa fa-spinner fa-spin '></i> Processing">QUERY</a>
                            		</div>
                            	</div>                          	
                            </div>
                            <div class="panel-body">
                                <div class="row">
                                	<div class="col-xs-12 form-group">
                                		<div class="">
                                        	<label>3DS Integrator OID</label>
                                        </div>
                                        <div class="input-group">
                                            <input type="text" id="iOid" name="validationIntegratorOid" class="form-control"/>
                                            <span class="input-group-addon"><i class="fa "></i></span>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
			</form>
			
			<form class="">
				<div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-success">
                            <div class="panel-heading"><i class="fa fa-table"></i> Authentication Result</div>
                            <div class="panel-body">
                            	<c:if test="${result.errCode != '4001'}">
									<div class="alert alert-danger" style="word-wrap: break-word;">ERROR: [${result.errCode}] ${result.errMsg}</div>
								</c:if>
								
								<div class="row">
                                	<div class="col-xs-6 form-group">
										<label class="">3DS Integrator OID</label>
										<div class="col-xs-12 input-group">
                                            <form:input path="result.validationIntegratorOid" cssClass="form-control" readonly="true"/>
                                        </div>
									</div>
									<div class="col-xs-6 form-group">
										<label class="">3DS Requestor Order ID</label>
										<div class="col-xs-12 input-group">
                                            <form:input path="result.validationRequestorOrderID" cssClass="form-control" readonly="true"/>
                                        </div>
									</div>
									<div class="col-xs-6 form-group">
										<label class="">3DS Requestor Order Data</label>
										<div class="col-xs-12 input-group">
                                            <form:input path="result.validationRequestorData" cssClass="form-control" readonly="true"/>
                                        </div>
									</div>
									<div class="col-xs-6 form-group">
										<label class="">3DS Requestor ID</label>
										<div class="col-xs-12 input-group">
                                            <form:input path="result.validationRequestorID" cssClass="form-control" readonly="true"/>
                                        </div>
									</div>
									<div class="col-xs-6 form-group">
										<label class="">3DS Server Transaction ID</label>
										<div class="col-xs-12 input-group">
                                            <form:input path="result.validationServerTransID" cssClass="form-control" readonly="true"/>
                                        </div>
									</div>
									<div class="col-xs-6 form-group">
										<label class="">ACS Transaction ID</label>
										<div class="col-xs-12 input-group">
                                            <form:input path="result.acsTransID" cssClass="form-control" readonly="true"/>
                                        </div>
									</div>
									<div class="col-xs-6 form-group">
										<label class="">DS Transaction ID</label>
										<div class="col-xs-12 input-group">
                                            <form:input path="result.dsTransID" cssClass="form-control" readonly="true"/>
                                        </div>
									</div>
									<div class="col-xs-6 form-group">
										<label class="">Transaction Status</label>
										<div class="col-xs-12 input-group">
                                            <form:input path="result.transStatus" cssClass="form-control" readonly="true"/>
                                        </div>
									</div>
									<div class="col-xs-6 form-group">
										<label class="">Transaction Status Reason</label>
										<div class="col-xs-12 input-group">
                                            <form:input path="result.transStatusReason" cssClass="form-control" readonly="true"/>
                                        </div>
									</div>
									<div class="col-xs-6 form-group">
										<label class="">Authentication Value</label>
										<div class="col-xs-12 input-group">
                                            <form:input path="result.authenticationValue" cssClass="form-control" readonly="true"/>
                                        </div>
									</div>
									<div class="col-xs-6 form-group">
										<label class="">ECI</label>
										<div class="col-xs-12 input-group">
                                            <form:input path="result.eci" cssClass="form-control" readonly="true"/>
                                        </div>
									</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
			</form>
		</div>
	</body>
</html>