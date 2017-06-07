<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>
<%@page import="de.ki.sbamdc.model.Flashcard"%>
<%@page import="de.ki.sbamdc.service.FlashcardLocalServiceUtil" %>
<%@page import="de.ki.sbamdc.service.CardBoxLocalServiceUtil" %>
<%@page import="lkart.util.Constants" %>

<portlet:actionURL name="toEditMode" var="editMode"></portlet:actionURL>
<portlet:actionURL name="toNewFlashcard" var="newFlashcard"></portlet:actionURL>

<!-- SearchContainer START -->
<%
	List<Flashcard> flashcards = FlashcardLocalServiceUtil.getFlashcards(0,
			FlashcardLocalServiceUtil.getFlashcardsCount());
%>
<portlet:actionURL name="gotoMainMenu" var="mainMenu"></portlet:actionURL>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="<%=Constants.FLASHCARD_OVERVIEW_JSP%>" />
</liferay-portlet:renderURL>

<h1>Karteikarten</h1>
<liferay-ui:search-container  var="searchContainer" delta="5" emptyResultsMessage="Keine Karteikarten wurden gefunden."
	compactEmptyResultsMessage="Keine Karteikarten gefunden." deltaConfigurable="true"
	iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>
		<%
			results = FlashcardLocalServiceUtil.getFlashcards(searchContainer.getStart(),
							searchContainer.getEnd());
					total = FlashcardLocalServiceUtil.getFlashcardsCount();
					searchContainer.setTotal(total);
					searchContainer.setResults(results);
		%>

	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="de.ki.sbamdc.model.Flashcard"
		modelVar="flashcard" keyProperty="id">
		<liferay-ui:search-container-column-jsp path="/html/lernkartei/flashcard_overview_link.jsp" ></liferay-ui:search-container-column-jsp>
		<liferay-ui:search-container-column-text name="Bezeichnung" property="title"/>
		<liferay-ui:search-container-column-text name="Lernkartei">
			<%=CardBoxLocalServiceUtil.fetchCardBox(flashcard.getCardBoxId_fk()).getName() %>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-jsp path="<%=Constants.ADMIN_ACTION_FLASHCARD %>"></liferay-ui:search-container-column-jsp>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
</liferay-ui:search-container>
<!-- SearchContainer END -->


<p>
	<a href=<%=newFlashcard%>>Neue Lernkartei</a>
</p>
<p>
	<a href=<%=editMode%>>Zurück</a>
</p>