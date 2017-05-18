<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:actionURL name="toMainMenu" var="mainMenu"></portlet:actionURL>
<portlet:actionURL name="toCardBoxOverview" var="cardBoxOverview"></portlet:actionURL>
<portlet:actionURL name="toFlashcardOverview" var="flashcardOverview"></portlet:actionURL>

<portlet:actionURL name="test" var="testURL"></portlet:actionURL>

<h1>Editor Modus</h1>

<p>
	<a href=<%=cardBoxOverview%>>Lernkarteien</a>
</p>
<p>
	<a href=<%=flashcardOverview%>>Karteikarten</a>
</p>

<p>
	<a href=<%=mainMenu%>>Back</a>
</p>

