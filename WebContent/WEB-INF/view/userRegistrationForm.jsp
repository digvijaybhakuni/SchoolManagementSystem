<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>School Management System</title>
<!-- <script src="WEB-INF/js/jquery-1.11.1.min.js"></script> -->
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<style type="text/css">
.loginDivClass {
	margin-top: 100px;
	border: 1px solid rgb(235, 150, 150);
	width: 800px;
	padding: 2px;
	background-color: rgb(226, 223, 180);
}

.loginTableTd {
	font-size: medium;
	font-weight: bold;
}

</style>
<script type="text/javascript">

function checkPassword(){
	
	if($("#rePassword").val()!=$("#password").val()){
		alert("Password do not match.");
		return false;
	}
}

function validateAndSubmitForm(){
	if($.trim($("#userId").val())==""){
		alert("Please enter UserId.");
		return false;
	}else if($.trim($("#password").val())==""){
		alert("Please enter password.");	
		return false;
	}else if($.trim($("#schoolCode").val())==""){
		alert("Please enter school code.");
		return false;
	}else if($.trim($("#branchCode").val())==""){
		alert("Please enter passing branch code.");
		return false;
	}else if($.trim($("#department").val())==""){
		alert("Please enter marks department.");
		return false;
	}else if($.trim($("#email").val())==""){
		alert("Please enter marks email.");
		return false;
	}else if($.trim($("#rePassword").val())!=$.trim($("#password").val())){
		alert("Password do not match.");
		return false;
	}else{
		document.getElementById("userRegistrationFrom").action="registerUser.htm";
		document.getElementById("userRegistrationFrom").submit();
	}


}

</script>

</head>
<body style="background-color: rgb(225, 248, 237);">
	
	<center>
	<div style="font-size: x-large; color: green;">User Registration Form</div>
		<div class="loginDivClass">
			<form id="userRegistrationFrom" action="" name="userRegistrationFrom" method="Post">
				<table cellpadding="5" cellspacing="5">
					<tr>
						<td class="loginTableTd">UserId:</td>
						<td><input type="text" name="userId" id="userId"></td>
					</tr>
					
					<tr>
						<td class="loginTableTd">Password:</td>
						<td><input type="text" name="password" id="password">
						</td>
					</tr>
					<tr>
						<td class="loginTableTd">Re-Password:</td>
						<td><input type="text" name="rePassowrd" id="rePassword" onblur="checkPassword();">
						</td>
					</tr>
					<tr>
						<td class="loginTableTd">SchoolCode</td>
						<td><input type="text" name="schoolCode" id="schoolCode">
						</td>
					</tr>

					<tr>
						<td class="loginTableTd">Branch Code:</td>
						<td><input type="text" name="branchCode" id="branchCode">
						</td>
					</tr>
					<tr>
						<td class="loginTableTd">DepartMent:</td>
						<td><input type="text" name="department" id="department"></td>
					</tr>
					<tr>
						<td class="loginTableTd">Email:</td>
						<td><input type="text" name="email" id="email"></td>
					</tr>
					<tr>
						<td class="loginTableTd">Role:</td>
						<td>
						<div>
						<input type="checkbox" value="staff" id="" name="role">staff<br/>
						<input type="checkbox" value="frontOffice" id="" name="role">frontOffice<br/>
						<input type="checkbox" value="account" id="" name="role">account<br/>
						<input type="checkbox" value="guard" id="" name="role">guard<br/>
						<input type="checkbox" value="admin" id="" name="role">Admin<br/>
						<input type="checkbox" value="" id="" name="role">staff<br/>
						</div>
						</td>
					</tr>		
					<tr>
						<td colspan="2" align="right">
						<input type="reset" value="Reset">&nbsp;&nbsp;
						<button onclick="javascript:validateAndSubmitForm();">Submit</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</center>
</body>
</html>