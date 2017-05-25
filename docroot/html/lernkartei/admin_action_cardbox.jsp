<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="de.ki.sbamdc.model.CardBox" %>
<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	CardBox cardBox = (CardBox)row.getObject();
	long cardBoxId = cardBox.getPrimaryKey();
%>

<liferay-ui:icon-menu>
	<portlet:actionURL name="toEditCardbox" var="editCardBox">
		<portlet:param name="cardBoxId" value='<%=""+cardBoxId%>'/>
	</portlet:actionURL>
	<liferay-ui:icon image="edit" message="Ändern" url='<%=editCardBox %>'/>
	
	<portlet:actionURL name="deleteCardBox" var="deleteCardBox">
		<portlet:param name="cardBoxId" value='<%=""+cardBoxId %>'/>
	</portlet:actionURL>
	<liferay-ui:icon-delete image="remove" message="Löschen" url='<%=deleteCardBox %>'/>
	
</liferay-ui:icon-menu>