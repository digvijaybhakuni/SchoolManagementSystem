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
	if($.trim($("#regNo").val())==""){
		alert("Please enter Registration No.");
		return true;
	}else if($.trim($("#dValue").val())==""){
		alert("Please enter deposit Value.");	
		return true;
	}else if($.trim($("#class").val())==""){
		alert("Please enter class.");
		return true;
	}else{
		document.getElementById("feeSubmissionForm").action="feeSubmit.htm";
		document.getElementById("feeSubmissionForm").submit();
	}


}

</script>

</head>
<body style="background-color: rgb(225, 248, 237);">
	
	<center>
	<div style="font-size: x-large; color: green;">Fee Submission Form</div>
		<div class="loginDivClass">
			<form id="feeSubmissionForm" action="" name="feeFormBeam" method="Post">
				<table cellpadding="5" cellspacing="5">
					<tr>
						<td class="loginTableTd">RegNo:</td>
						<td><input type="text" name="regNo" id="regNo"></td>
					</tr>

					<tr>
						<td class="loginTableTd">Class:</td>
						<td><input type="text" name="studentClass" id="class">
						</td>
					</tr>

					<tr>
						<td class="loginTableTd">Deposited value:</td>
						<td><input type="text" name="feeDaposited" id="dValue">
						</td>
					</tr>
					<tr>
						<td class="loginTableTd">Fine:</td>
						<td><input type="text" name="fine" id="fine"></td>
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