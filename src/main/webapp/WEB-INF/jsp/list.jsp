<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url var="newCsvUploadLink" value="${listDepartmentModel.newCsvUploadLink}" />

<div>
	<h3>List</h3>
	<div class="col-xs-12">
        <a href="${newCsvUploadLink}" class="btn btn-sm btn-primary" >
          <span class="fa-stack fa-1x ai-fa-button-style">
            <span class="fa fa-user fa-stack-1x"></span>
            <span class="fa-stack-1x ai-fa-v-dspmnt ai-fa-h-dspmnt-small">+</span>
          </span>Upload New CSV</a>
      <hr />
    </div>
	
    <table id="departments" class="table table-striped table-hover">
      <thead>
        <tr>
          <th>Name</th>
          <th>Avarage</th>
        </tr>
      </thead>
      <tbody>
      	<c:forEach var="department" items="${listDepartmentModel.departments}">
	      	<tr>
	      		<td><c:out value="${department.departmentName}" /></td>
	      		<td><c:out value="${department.avarage}" /></td>
	      	</tr>
      	</c:forEach>
      </tbody>
    </table>
    
</div>
