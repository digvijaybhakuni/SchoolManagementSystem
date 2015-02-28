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
	if($.trim($("#name").val())==""){
		alert("Please enter visitor's Name.");
		return true;
	}else if($.trim($("#address").val())==""){
		alert("Please enter address.");	
		return true;
	}else{
		document.getElementById("visitorEntryForm").action="addVisitor.htm";
		document.getElementById("visitorEntryForm").submit();
	}
}

</script>

</head>
<body style="background-color: rgb(225, 248, 237);">
	<jsp:include page="header.jsp"></jsp:include>
	<div style="font-size: xx-large; color: green; text-align: center;">Guard</div>
	<center>
	<div style="font-size: x-large; color: green;">Visitor's Entry</div>
		<div class="loginDivClass">
			<form id="visitorEntryForm" action="" name="visitorForm" method="Post">
				<table cellpadding="5" cellspacing="5">
					<tr>
						<td class="loginTableTd">Name:</td>
						<td><input type="text" name="name" id="name"></td>
					</tr>
					
					<tr>
						<td class="loginTableTd">Address:</td>
						<td><textarea name="address" id="address" style="width: 170px; height: 70px; resize:none;" ></textarea>
						</td>
					</tr>
					<tr>
						<td class="loginTableTd">Reason :</td>
						<td><input type="text" name="reason" id="reason">
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