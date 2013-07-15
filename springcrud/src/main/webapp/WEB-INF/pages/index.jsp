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
			</tr>
			<c:forEach items="${employees}" var="employee">
				<tr>
					<td>${employee.firstName}</td>
					<td>${employee.lastName}</td>
					<td>${employee.email}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>