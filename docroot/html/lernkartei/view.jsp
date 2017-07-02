<%@ include file="/init.jsp"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:actionURL name="toEditMode" var="zumEditModus"></portlet:actionURL>
<portlet:actionURL name="toLearnMenue" var="lernen"></portlet:actionURL>
<portlet:defineObjects />

<%
long groupId = scopeGroupId;
String name = portletDisplay.getRootPortletId();
String primKey = portletDisplay.getResourcePK();
String actionId = "EDIT_CONTENT";
%>


<p style="text-align:center">
<a href=<%=lernen %> class="btn btn-primary" >Lernen</a> <br>
</p>

<c:if test="<%=permissionChecker.hasPermission(groupId, name, primKey, actionId) %>">
<p style="text-align:center">
<a href=<%=zumEditModus %> class="btn btn-warning">Verwalten</a>
</p>
</c:if>
