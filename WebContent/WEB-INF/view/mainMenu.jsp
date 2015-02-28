<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<style type="text/css">

.tdformat{
width: 500px;

}

.imgStyle{
width: 200px;
height: 200px;
cursor: pointer;
}
</style>


<div>
<table width="100%" cellpadding="10">
<tr>
<td width="35%" align="center"><a href="${pageContext.request.contextPath}/accountantController/openAccountPanel.htm"><img class="imgStyle" src="<%=request.getContextPath()%>/img/accountant.png" title="Accountant" alt="Accountant"></a></td>
<td width="35%" align="center"><a href="${pageContext.request.contextPath}/frontOfficeController/openFrontOfficePanel.htm"><img class="imgStyle" src="<%=request.getContextPath()%>/img/frontdesk2.jpg" title="FrontOffice" alt="FrontOffice"></a></td>
<td width="30%" align="center"><a href="${pageContext.request.contextPath}/guardController/guardHome.htm"><img class="imgStyle" src="<%=request.getContextPath()%>/img/images.jpg" title="Guard" alt="Guard"></a></td>
</tr>
<tr>
<td width="35%" align="center"><a href="${pageContext.request.contextPath}/teacherController/teacherPanel.htm"><img class="imgStyle" src="<%=request.getContextPath()%>/img/principal.jpg" title="Teacher Staff" alt="Teacher"></a></td>
<td width="35%" align="center"><a  href="${pageContext.request.contextPath}/adminController/openAdminPanel.htm"><img class="imgStyle" src="<%=request.getContextPath()%>/img/admin.jpg" title="Management" alt="Management"></a></td>
<td width="30%" align="center"><a href="${pageContext.request.contextPath}/reportController/reportPanel.htm"><img class="imgStyle" src="<%=request.getContextPath()%>/img/Results.jpg" title="Result & Reports" alt="Result"></a></td>
</tr>
</table>
</div>
