<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Employee CSV parser</title>
	
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.10.2.min.js" />"></script>
	<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
	<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
	
</head>
<body>
	<div class="container">
		<div class="row" style="border-bottom: 1px solid #ccc; padding: 10px; color: #ffffff">
			<tiles:insertAttribute name="header" />
		</div>
		
		<tiles:insertAttribute name="navigation" />
		
		<div style="margin: 15px">
			<div class="row">			
				<div class="col-md-10 col-md-offset-1">
                  <tiles:insertAttribute name="message"></tiles:insertAttribute>
                  <tiles:insertAttribute name="content" />
				</div>
			</div>
		</div>
		<div class="row" style="background: rgb(18, 103, 155); color: #ffffff !important; margin-top: 15px">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
	
</body>
</html>