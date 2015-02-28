<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${not empty lstSubjectForm }">
<form id="resultSubmissionForm" action="" name="resultFormBean" method="Post">
<table width="100%" cellpadding="5" cellspacing="5">
<c:forEach items="${lstSubjectForm }" var="mstSubjectForm"> 
				<tr>
						<td class="loginTableTd">Roll No:</td>
						<td><input style="width: 30px;" type="text" name="regNo" id="regNo"></td>
						<td class="loginTableTd">Subject Name:</td>
						<td>
						<input type="hidden" name="subjectArr" id="subjectArr" value="${mstSubjectForm.subject }">
						<input type="hidden" name="studentClass" id="studentClass" value="${mstSubjectForm.className }">
						${mstSubjectForm.subject }</td>
						<td class="loginTableTd">Maximum Marks:</td>
						<td><input style="width: 30px;" type="text" name="maxMarks" id="maxMarks">
						</td>
						<td class="loginTableTd">Passing Marks:</td>
						<td><input style="width: 30px;" type="text" name="passingMarks" id="passingMarks">
						</td>
						<td class="loginTableTd">Marks Obtained:</td>
						<td><input style="width: 30px;" type="text" name="marksObtained" id="marksObtained"></td>
						</td>
						<td class="loginTableTd">Status:</td>
						<td><input style="width: 30px;" type="text" name="status" id="status"></td>
					</tr>
 </c:forEach>
 <input type="reset" value="Reset">&nbsp;&nbsp;
<button onclick="javascript:validateAndUploadResult();">Submit</button>

</table>
</form>
</c:if>