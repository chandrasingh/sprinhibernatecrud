<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@ page isELIgnored="false"%>
</head>
<body>
	<c:if test="${!empty ecList}">
		<table class="data">
			<tr>
				<th>Date</th>
				<th>Time</th>
				<th></th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${ecList}" var="ec">
				<tr>
					<td>${ec.EC_Date}, ${ec.EC_Time}</td>
					<td>${ec.EC_enumerator}</td>
					<td>${ec. EC_Q_1}</td>
					<td><a href="delete/${ec.id}">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>