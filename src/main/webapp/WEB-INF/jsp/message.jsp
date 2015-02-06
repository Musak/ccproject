<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:if test="${not empty message}">
  <div class="alert alert-success">${message}</div>
</c:if>
<c:if test="${not empty errorMessage}">
  <div class="alert alert-danger">${errorMessage}</div>
</c:if>