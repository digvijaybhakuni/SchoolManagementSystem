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
	 if($.trim($("#class").val())==""){
		alert("Please enter Class.");
		
	}else{
		var callingUrl="resultUploadTable.htm?className="+$("#class").val();
		$.ajax({
			type: 'GET',
			url: callingUrl,
			success:function(result){
		    	$("#resultDetail").html(result);
		    	
		    }
		});
	}


}


function validateAndUploadResult(){
	 if($.trim($("#regNo").val())==""){
		alert("Please enter rollno.");
	}else if($.trim($("#maxMarks").val())==""){
		alert("Please enter maximum marks.");
	}else if($.trim($("#passingMarks").val())==""){
		alert("Please enter passing marks.");
	}else if($.trim($("#marksObtained").val())==""){
		alert("Please enter obtained marks.");
	}else{
		var callingUrl="saveResult.htm";
		var formValue=$("#resultSubmissionForm").serialize();
		$.ajax({
			type: 'POST',
			url: callingUrl,
			data: formValue,
			datatype: 'html',
			success:function(result){
		    	$("#resultDetail").html(result);
		    	
		    }
		});
	}


}
</script>

</head>
<body style="background-color: rgb(225, 248, 237);">
	
	<center>
	<div style="font-size: x-large; color: green;">Result Upload Form</div>
		<div class="loginDivClass">
		<table cellpadding="5" cellspacing="5">
					<tr>
						<td class="loginTableTd">Class:</td>
						<td><input type="text" name="class" id="class">
						</td>
					</tr>		
					<tr>
						<td colspan="2" align="right">
						<button onclick="javascript:validateAndSubmitForm();">Submit</button>
						</td>
					</tr>
				</table>
		<div id="resultDetail" class="loginDivClass">
			
		</div>
	</center>
</body>
</html>