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
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/webjars/jquery/jquery.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function () { 
				if ("${errCode}" == "4001")
					$("#form1").submit();
			});
		</script>
	</head>
	<body>
		<c:choose>
			<c:when test="${errCode == '4001'}">
				<h1>Demo-Requestor will trigger transaction......</h1>
			</c:when>
			<c:otherwise>
				<h1>Demo-Requestor got error when initialize transaction.</h1>
				<div>ERROR: [${errCode}] ${errMsg}</div>
			</c:otherwise>
		</c:choose>
		
		<form name="form1" id="form1" action="${validationAuthURL}" method="post">
            <input type="hidden" name="validationIntegratorOid" value="${validationIntegratorOid}">
        </form>
	</body>
</html>