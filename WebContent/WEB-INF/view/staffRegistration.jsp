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
		return true;
	}else if($.trim($("#phone").val())==""){
		alert("Please enter phone no.");	
		return true;
	}else if($.trim($("#dob").val())==""){
		alert("Please enter Date Of Birth.");
		return true;
	}else if($.trim($("#address").val())==""){
		alert("Please enter address");
		return true;
	}else{
		var callingUrl="saveStaff.htm";
		var formValue=$("#staffRegistrationForm").serialize();
		$.ajax({
			type: 'POST',
			url: callingUrl,
			data: formValue,
			success:function(result){
		    	$("#resultDetail").html(result);
		    	
		    }
		});
		//document.getElementById("staffRegistrationForm").action=".htm";
		//document.getElementById("staffRegistrationForm").submit();
	}
}

</script>

</head>
<body style="background-color: rgb(225, 248, 237);">
	
	<center>
	<div style="font-size: x-large; color: green;">Staff Registration Form</div>
		<div class="loginDivClass">
			<form id="staffRegistrationForm" action="" name="staffRegFormBean" method="Post">
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
						<td>
						<select  name="sex" id="sex">
						<option value="">Select</option>
						<option value="M">M</option>
						<option value="F">F</option>
						</select>
					</tr>
					<tr>
						<td class="loginTableTd"> Status:</td>
						<td>
						<select  name="maritalStatus" id="maritalStatus">
						<option value="">Select</option>
						<option value="S">Single</option>
						<option value="M">Married</option>
						</select>
						</td>
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
						<td class="loginTableTd">Phone:</td>
						<td><input type="text" name="phone" id="phone">
						</td>
					</tr>
					<tr>
						<td class="loginTableTd">Mobile:</td>
						<td><input type="text" name="mobile" id="mobile">
						</td>
					</tr>
					<tr>
						<td class="loginTableTd">email Id:</td>
						<td><input type="text" name="email" id="email">
						</td>
					</tr>
					<tr>
						<td class="loginTableTd">Nature Of Job:</td>
						<td><input type="text" name="natureOfJob" id="nojob">
						</td>
					</tr>
					<tr>
						<td class="loginTableTd">Specialization:</td>
						<td><input type="text" name="specialization" id="specialization">
						</td>
					</tr>
					
					<tr>
						<td class="loginTableTd">Blood Group:</td>
						<td><input type="text" name="bGroup" id="bGroup">
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