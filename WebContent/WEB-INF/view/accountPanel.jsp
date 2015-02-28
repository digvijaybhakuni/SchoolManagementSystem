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

function openThisForm(val){
	var callingUrl="";
	if(val=='fee'){
		callingUrl="feeSubmissionForm.htm";
	}else if(val=='salary'){
		callingUrl="salaryForm.htm";
	}else if(val=='expense'){
		callingUrl="expenseForm.htm";
	}else if(val=='report'){
		callingUrl="reportForm.htm";
	}
	
	$.ajax({
		type: 'GET',
		url: callingUrl,
		success:function(result){
	    	$("#contentDiv").html(result);
	    	
	    }});

}

</script>
<style type="text/css">
.tdFormat{
font-size: medium;
}

</style>
</head>
<body style="background-color: rgb(225, 248, 237);">
	<jsp:include page="header.jsp"></jsp:include>
	<div style="font-size: xx-large; color: green; text-align: center;">Account Panel</div>
	<center>
	<div style="border: 1px solid gray; width: 1025px;">
	<table width="100%">
	<tr>
	<td class="tdFormat" style="background-color: silver; cursor: pointer;" width="20%" onclick="openThisForm('fee')">Submit Fee</td>
	<td  class="tdFormat" style="background-color: silver; cursor: pointer;" width="20%" onclick="openThisForm('report')">Fee Report</td>
	<td class="tdFormat" style="background-color: silver; cursor: pointer;" width="20%" onclick="openThisForm('salary')">Staff Salary</td>
	<td class="tdFormat" style="background-color: silver; cursor: pointer;" width="20%" onclick="openThisForm('expense')">Other Expenses</td>
	</tr>
	</table>
	</div>
	<div id="contentDiv">
	<jsp:include page="feeSubmissionForm.jsp"></jsp:include>
	</div>
	</center>
</body>
</html>