<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@ page isELIgnored="false"%>
</head>
<body>
	<c:if test="${!empty employees}">
		<table class="data">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>E mail</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${employees}" var="employee">
				<tr>
					<td>${employee.firstName}</td>
					<td>${employee.lastName}</td>
					<td>${employee.email}</td>
					<td><a href="?action=edit&id=${employee.id}">edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${!empty edit}">
		<form method="post" action="update">
			    <input type="hidden" name="userName" id="userName" value="${edit.userName}" /> 
				<input type="hidden" name="id" id="id" value="${edit.id}" />
				<input type="hidden" name="managerID" id="managerID" value="${edit.managerId}" />

			<table>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName" id="firstName" value="${edit.firstName}" /></td>
				</tr>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="lastName" id="lastName" value="${edit.lastName}" /></td>
				</tr>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="email" id="email" value="${edit.email}" /></td>
				</tr>
				<tr>
					<td colspan="2">            
						<input type="submit" value="Update" />         
					</td>
				</tr>
			</table>
			 
		</form>
	</c:if>
</body>
</html>