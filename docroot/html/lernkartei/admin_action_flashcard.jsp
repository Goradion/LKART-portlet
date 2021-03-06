<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="de.ki.sbamdc.model.Flashcard" %>
<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Flashcard flashcard = (Flashcard)row.getObject();
	String flashcardTitle = flashcard.getTitle();
	long flashcardId = flashcard.getPrimaryKey();
%>

<liferay-ui:icon-menu message="Aktionen">
	<portlet:actionURL name="toEditFlashcard" var="editFlashcard">
		<portlet:param name="fcId" value='<%=""+flashcardId%>'/>
	</portlet:actionURL>
	<liferay-ui:icon image="edit" message="Edit" url='<%=editFlashcard %>'/>
	
	<portlet:actionURL name="deleteFlashcard" var="deleteFlashcard">
		<portlet:param name="fcId" value='<%=""+flashcardId %>'/>
	</portlet:actionURL>
	<liferay-ui:icon-delete image="remove" url='<%=deleteFlashcard %>'/>
	
	
</liferay-ui:icon-menu>