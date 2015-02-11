<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<h3>Homepage</h3>
	<form method="POST" action="<c:url value="/" />"
		enctype="multipart/form-data">
		CSV file to upload: <input type="file" name="file"><br /> <br />
		<input type="submit" class="btn btn-default" value="Upload">
	</form>
</div>
