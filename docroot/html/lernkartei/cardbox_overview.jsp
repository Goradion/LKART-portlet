<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.List"%>
<%@page import="de.ki.sbamdc.model.CardBox" %>
<%@page import="de.ki.sbamdc.service.CardBoxLocalServiceUtil" %>
<%@page import="lkart.util.CardBoxComparatorUtil" %>
<%@page import="lkart.util.Constants" %>


<portlet:actionURL name="toEditMode" var="editMode"></portlet:actionURL>
<portlet:actionURL name="toNewCardBox" var="newCardBox"></portlet:actionURL>
<portlet:actionURL name="searchCardBoxes" var="searchCardBoxes" ></portlet:actionURL>

<%
	List<CardBox> foundCardBoxes = (List<CardBox>)portletSession.getAttribute("foundCardBoxes");
%>

<!-- SearchContainer START -->
<portlet:actionURL name="toMainMenu" var="mainMenu"></portlet:actionURL>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="<%=Constants.CARDBOX_OVERVIEW_JSP%>" />
</liferay-portlet:renderURL>

<h1>Lernkarteien</h1>

<aui:form action="<%=searchCardBoxes %>" >
    <div class="input-group">
      <input min="3" type="text" class="form-control" placeholder="Suchen nach..." name='<portlet:namespace/>cbKeyword'>
      <span class="input-group-btn">
        <button class="btn btn-default" type="submit">Suchen</button>
      </span>
    </div><!-- /input-group -->
</aui:form>

<liferay-ui:search-container var="searchContainer" delta="5" emptyResultsMessage="Keine Lernkarteien wurden gefunden."
	compactEmptyResultsMessage="Keine Lernkartei" deltaConfigurable="true" 
	iteratorURL="<%=iteratorURL%>">
	<liferay-ui:search-container-results >
		<%
			results = foundCardBoxes;
//					CardBoxLocalServiceUtil.findByUserId(themeDisplay.getUserId());
			total = results.size();
// 					CardBoxLocalServiceUtil.getCardBoxesCountOfUser(themeDisplay.getUserId());
			searchContainer.setTotal(total);
			String sortByCol = ParamUtil.getString(request, "orderByCol"); 
			String sortByType = ParamUtil.getString(request, "orderByType"); 
			if (sortByCol != null){
				results = ListUtil.sort(results, CardBoxComparatorUtil.getComparator(sortByCol, sortByType));
			}
			searchContainer.setTotal(total);
			searchContainer.setResults(ListUtil.subList(results, searchContainer.getStart(), searchContainer.getEnd()));
		%>

	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="de.ki.sbamdc.model.CardBox"
		modelVar="cardBox" keyProperty="id">
		<liferay-ui:search-container-column-text property="name" name="Name" orderable="true" />
		<liferay-ui:search-container-column-text  name = "Geteilt" orderable ="true">
			<%=(cardBox.isShared())? "Ja":"Nein" %>
		</liferay-ui:search-container-column-text>		
	<liferay-ui:search-container-column-jsp  name="Verwaltung" path="<%=Constants.ADMIN_ACTION_CARDBOX %>"/>	
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
</liferay-ui:search-container>
<!-- SearchContainer END -->

<p>
	<portlet:actionURL name="clearCardBoxes" var="clear"/>
	<a class="btn btn-danger" href=<%=clear%>>Alles löschen</a>
</p>
<p align="center">
	<a class="btn btn-warning" href=<%=editMode%>>Zurück</a>
	<a class="btn btn-primary" href=<%=newCardBox%>>Neue Kartei</a>
</p>