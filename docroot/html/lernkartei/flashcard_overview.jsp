<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>
<%@page import="de.ki.sbamdc.model.Flashcard"%>
<%@page import="de.ki.sbamdc.service.FlashcardLocalServiceUtil" %>
<%@page import="de.ki.sbamdc.service.CardBoxLocalServiceUtil" %>
<%@page import="lkart.util.Constants" %>

<portlet:actionURL name="toEditMode" var="editMode"></portlet:actionURL>
<portlet:actionURL name="toNewFlashcard" var="newFlashcard"></portlet:actionURL>
<portlet:actionURL name="searchFlashcards" var="searchFlashcards"></portlet:actionURL>
<%
	long userId = themeDisplay.getUserId();
	List<Flashcard>	flashcards = (List<Flashcard>)portletSession.getAttribute("flashcards");
	
%>


<!-- SearchContainer START -->
<portlet:actionURL name="toMainMenu" var="mainMenu"></portlet:actionURL>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="<%=Constants.FLASHCARD_OVERVIEW_JSP%>" />
</liferay-portlet:renderURL>

<h1>Karteikarten</h1>

<aui:form action="<%=searchFlashcards %>" >
    <div class="input-group">
      <input min="3" type="text" class="form-control" placeholder="Suchen nach..." name='<portlet:namespace/>keyword'>
      <span class="input-group-btn">
        <button class="btn btn-default" type="submit">Suchen</button>
      </span>
    </div><!-- /input-group -->
</aui:form>

<liferay-ui:search-container  var="searchContainer" delta="5" emptyResultsMessage="Keine Karteikarten wurden gefunden."
	compactEmptyResultsMessage="Keine Karteikarten gefunden." deltaConfigurable="true"
	iteratorURL="<%=iteratorURL%>">
	
	<liferay-ui:search-container-results>
		<%
			results = flashcards;
			total = flashcards.size();
			searchContainer.setTotal(total);
			searchContainer.setResults(results);
		%>

	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="de.ki.sbamdc.model.Flashcard"
		modelVar="flashcard" keyProperty="id">
		<liferay-ui:search-container-column-jsp path="/html/lernkartei/flashcard_preview_link.jsp" name="Bezeichnung"/>
		<liferay-ui:search-container-column-text name="Lernkartei">
			<%=(CardBoxLocalServiceUtil.fetchCardBox(flashcard.getCardBoxId_fk())!=null)?CardBoxLocalServiceUtil.fetchCardBox(flashcard.getCardBoxId_fk()).getName() : ""%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-jsp path="<%=Constants.ADMIN_ACTION_FLASHCARD %>"></liferay-ui:search-container-column-jsp>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
</liferay-ui:search-container>
<!-- SearchContainer END -->
<p style="text-align:center">
	<a class="btn btn-warning" href=<%=editMode%>>Zurück</a>
	<a class="btn btn-primary" href=<%=newFlashcard%>>Neue Lernkarte</a>
</p>
