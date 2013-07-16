<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<%@ page isELIgnored="false"%>
<script type="text/javascript">
var emails = new Array();
<c:if test="${!empty edit}">
var updateEmail = "${edit.email}";
</c:if>


<c:forEach items="${employees}" var="employee"> 
emails.push("${employee.email}");
</c:forEach> 
function validateForm(formName){
	var firstName = document.forms[formName]["firstName"].value;
	var lastName = document.forms[formName]["lastName"].value;
	var email = document.forms[formName]["email"].value;
	var returnValue = true;
	var message = "";
	
	if(firstName == "" || firstName == null){
		returnValue = false;
		message += "First Name cannot be empty! ";
	}
	if(lastName == "" || lastName == null){
		returnValue = false;
		message += "Last Name connot be empty! ";
	}
	if(email == "" || email == null){
		returnValue = false;
		message += "email connot be empty! ";
	}
	if(!checkEmail(email)){
		returnValue = false;
		message += "email is not in correct format! ";
	}
	if(formName == "updateForm"){
		var indexOfmail = emails.indexOf(email);
		if(indexOfmail != -1 && email != updateEmail){
			returnValue = false;
			message += "email id already exists! ";
		}
	}else if(emails.indexOf(email) != -1){
		returnValue = false;
		message += "email id already exists! ";
	}
	if(!returnValue){
		alert(message);
	}
	return returnValue;
}
	
function checkEmail(email) {
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	return filter.test(email);
}
</script>
</head>
<body>
	<c:if test="${!empty message}">
		<h3>${message}</h3>
	</c:if>
	<form method="post" action="create" name="createForm" onsubmit="return validateForm('createForm')">
		<table>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" id="firstName" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" id="lastName" /></td>
			</tr>
			<tr>
				<td>email</td>
				<td><input type="text" name="email" id="email" /></td>
			</tr>
			<tr>
				<td>Manager</td>
				<td>
					<select name="managerID">
						<option value="0">None</option>
						<c:forEach items="${employees}" var="employee">
							<option value="${employee.id}">${employee.firstName} ${employee.lastName}, ${employee.email}</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2">            
					<input type="submit" value="Add" />         
				</td>
			</tr>
		</table>
			 
	</form>
	<c:if test="${!empty employees}">
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>E mail</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${employees}" var="employee">
				<tr>
					<td>${employee.firstName}</td>
					<td>${employee.lastName}</td>
					<td>${employee.email}</td>
					<td><a href="?action=edit&id=${employee.id}">edit</a></td>
					<td><a href="?action=delete&id=${employee.id}">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${!empty edit}">
		<form method="post" action="update" name="updateForm" onsubmit="return validateForm('updateForm')">
			    <input type="hidden" name="userName" id="userName" value="${edit.userName}" /> 
				<input type="hidden" name="id" id="id" value="${edit.id}" />

			<table>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName" id="firstName" value="${edit.firstName}" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName" id="lastName" value="${edit.lastName}" /></td>
				</tr>
				<tr>
					<td>email</td>
					<td><input type="text" name="email" id="email" value="${edit.email}" /></td>
				</tr>
				<tr>
				<td>Manager</td>
				<td>
					<select name="managerID">
						<option value="0">None</option>
						<c:forEach items="${employees}" var="employee">
							<option value="${employee.id}" <c:if test="${edit.managerId == employee.id}">selected="selected"</c:if>>${employee.firstName} ${employee.lastName}, ${employee.email}</option>
						</c:forEach>
					</select>
				</td>
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