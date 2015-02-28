<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div style="font-size: large;"><u>${reportTitle }</u></div>
<c:if test="${not empty lstReport }">
<form id="resultSubmissionForm" action="" name="resultFormBean" method="Post">
<table width="100%" cellpadding="5" cellspacing="5">
<tr>
<th>${col1 }</th>
<th>${col2 }</th>
<th>${col3 }</th>
</tr>
<c:forEach items="${lstReport }" var="reportBean"> 
			<tr>
				<td align="center">${reportBean.col1data }</td>
				<td align="center">${reportBean.col2data }</td>
				<td align="center">${reportBean.col3data }</td>
			</tr>
</c:forEach>
</table>
</form>
</c:if>