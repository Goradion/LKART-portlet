<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>
<%@page import="de.ki.sbamdc.model.CardBox" %>
<%@page import="de.ki.sbamdc.service.CardBoxLocalServiceUtil" %>
<%@page import="lkart.util.Constants" %>


<portlet:actionURL name="toEditMode" var="editMode"></portlet:actionURL>
<portlet:actionURL name="toNewCardBox" var="newCardBox"></portlet:actionURL>


<!-- SearchContainer START -->
<%
// 	List<CardBox> cardboxes = CardBoxLocalServiceUtil.getCardBoxs(0,
// 			CardBoxLocalServiceUtil.getCardBoxsCount());
%>
<portlet:actionURL name="toMainMenu" var="mainMenu"></portlet:actionURL>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="<%=Constants.CARDBOX_OVERVIEW_JSP%>" />
</liferay-portlet:renderURL>

<h1>Lernkarteien</h1>

<liferay-ui:search-container var="searchContainer" delta="5" emptyResultsMessage="Keine Lernkarteien wurden gefunden."
	compactEmptyResultsMessage="Keine Lernkartei" deltaConfigurable="true"
	iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results>
		<%
			results = CardBoxLocalServiceUtil.getCardBoxesOfUser(themeDisplay.getUserId(), searchContainer.getStart(),
					searchContainer.getEnd());
			total = CardBoxLocalServiceUtil.getCardBoxesCountOfUser(themeDisplay.getUserId());
			searchContainer.setTotal(total);
			searchContainer.setResults(results);
		%>

	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="de.ki.sbamdc.model.CardBox"
		modelVar="cardBox" keyProperty="id">
		<liferay-ui:search-container-column-text property="name" name="Name" />
		<liferay-ui:search-container-column-text name="Für alle sichtbar">
			<%=(cardBox.isShared())? "Ja":"Nein" %>
		</liferay-ui:search-container-column-text>		
	<liferay-ui:search-container-column-jsp  name="Verwaltung" path="<%=Constants.ADMIN_ACTION_CARDBOX %>"/>	
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
</liferay-ui:search-container>
<!-- SearchContainer END -->

<p>
	<portlet:actionURL name="clearCardBoxes" var="clear"/>
	<a href=<%=clear%>>Alles löschen</a>
</p>
<p>
	<a href=<%=newCardBox%>>Neue Kartei</a>
</p>
<p>
	<a href=<%=editMode%>>Back</a>
</p>