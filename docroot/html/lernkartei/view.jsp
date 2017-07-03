<%@ include file="/init.jsp"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:actionURL name="toEditMode" var="zumEditModus"></portlet:actionURL>
<portlet:actionURL name="toLearnMenue" var="lernen"></portlet:actionURL>
<portlet:defineObjects />


<p style="text-align:center">
<a href=<%=lernen %> class="btn btn-primary">Lernen</a> <br>
</p>

<c:if test="<%=permissionChecker.isSignedIn() %>">
<p style="text-align:center">
<a href=<%=zumEditModus %> class="btn btn-warning">Verwalten</a>
</p>
</c:if>
