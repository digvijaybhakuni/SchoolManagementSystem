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

function validateAndSubmitForm(){
	if($.trim($("#fName").val())==""){
		alert("Please enter First Name.");
		return false;
	}else if($.trim($("#mobile").val())==""){
		alert("Please enter phone no.");	
		return false;
	}else if($.trim($("#dob").val())==""){
		alert("Please enter Date Of Birth.");
		return false;
	}else if($.trim($("#address").val())==""){
		alert("Please enter address");
		return false;
	}else{
		document.getElementById("studentRegistrationForm").action="saveStudent.htm";
		document.getElementById("studentRegistrationForm").submit();
	}


}

</script>

</head>
<body style="background-color: rgb(225, 248, 237);">
	
	<center>
	<div style="font-size: x-large; color: green;">Admission Form</div>
		<div class="loginDivClass">
			<form id="studentRegistrationForm" action="" name="studentRegFormBean" method="Post">
				<table cellpadding="5" cellspacing="5">
					<tr>
						<td class="loginTableTd">First Name:</td>
						<td><input type="text" name="fName" id="fName"></td>
					</tr>

					<tr>
						<td class="loginTableTd">Last Name:</td>
						<td><input type="text" name="lname" id="lName">
						</td>
					</tr>

					<tr>
						<td class="loginTableTd">Middle Name:</td>
						<td><input type="text" name="mName" id="mName">
						</td>
					</tr>

					<tr>
						<td class="loginTableTd">Date Of Birth</td>
						<td><input type="text" name="dob" id="dob">
						</td>
					</tr>
					<tr>
						<td class="loginTableTd">Gender:</td>
						<td><input type="text" name="sex" id="sex"></td>
					</tr>
					<tr>
						<td class="loginTableTd">address:</td>
						<td><textarea style="width: 200px; height: 100px;" name="address" id="address"></textarea>
						</td>
					</tr>

					<tr>
						<td class="loginTableTd">City:</td>
						<td><input type="text" name="city" id="city">
						</td>
					</tr>

					<tr>
						<td class="loginTableTd">State:</td>
						<td><input type="text" name="state" id="state">
						</td>
					</tr>
					<tr>
						<td class="loginTableTd">Pin:</td>
						<td><input type="text" name="pin" id="pin">
						</td>
					</tr>
					<tr>
						<td class="loginTableTd">Phone:</td>
						<td><input type="text" name="mobile" id="mobile">
						</td>
					</tr>

					<tr>
						<td class="loginTableTd">email Id:</td>
						<td><input type="text" name="email" id="email">
						</td>
					</tr>
					
					<tr>
						<td class="loginTableTd">Blood Group:</td>
						<td><input type="text" name="bloodGroup" id="bloodGroup">
						</td>
					</tr>
					<tr>
						<td class="loginTableTd">Class:</td>
						<td><input type="text" name="studentClass" id="studentClass">
						</td>
					</tr>					
					<tr>
						<td>
						
						</td>
						<td align="right">
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