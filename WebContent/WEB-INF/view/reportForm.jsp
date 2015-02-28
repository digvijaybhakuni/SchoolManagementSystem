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
function validateAndGetReport(){
	 if($.trim($("#reportType").val())==""){
		alert("Please select report type.");
	}else{
		var callingUrl="generateReport.htm?reportType="+$("#reportType").val();
		$.ajax({
			type: 'GET',
			url: callingUrl,
			success:function(result){
		    	$("#contentDivId").html(result);
		    }
		});
	}


}

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
		document.getElementById("feeSubmissionForm").action="homeController/loginProcess";
		document.getElementById("feeSubmissionForm").submit();
	}
}

function printContentDiv(){
	var mywindow = window.open('', 'new div', 'height=500,width=600');
    mywindow.document.write('<html><head><title>SMS</title>');
    mywindow.document.write('<link rel="stylesheet" href="main.css" type="text/css" media="print" />');
    mywindow.document.write('</head><body >');
    mywindow.document.write($("#contentDivId").html());
    mywindow.document.write('</body></html>');
    mywindow.print();
    mywindow.close();
    return true;	
}
</script>

</head>
<body style="background-color: rgb(225, 248, 237);">
	
	<center>
	<div style="font-size: x-large; color: green;">Reports</div>
		<div class="loginDivClass">
				<table cellpadding="5" cellspacing="5">
					<tr>
						<td class="loginTableTd">Select Report:</td>
						<td>
							<select id="reportType">
								<option value="visitor">Visitor</option>
								<option value="teacher">Teacher</option>
								<option value="student">student</option>
								<option value="result">result</option>
							</select>
						</td>
						<td align="right">
						<button onclick="javascript:validateAndGetReport();">Submit</button>
						<button id="printBtn" onclick="javascript:printContentDiv();">Print</button>
						</td>
					</tr>
				</table>
				<div id="contentDivId" style="background-color: white;"></div>
		</div>

	</center>
</body>
</html>