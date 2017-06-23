<%@ include file="/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:actionURL name="toMainMenu" var="mainMenu"></portlet:actionURL>
<portlet:actionURL name="toCardBoxOverview" var="cardBoxOverview"></portlet:actionURL>
<portlet:actionURL name="toFlashcardOverview" var="flashcardOverview"></portlet:actionURL>

<portlet:actionURL name="test" var="testURL"></portlet:actionURL>

<p style="text-align:center">
	<a class="btn btn-primary" href=<%=cardBoxOverview%>>Lernkarteiverwaltung</a>
</p>
<p style="text-align:center">
	<a class="btn btn-primary" href=<%=flashcardOverview%>>Karteikartenverwaltung</a>
</p>

<p style="text-align:center">
	<a class="btn btn-warning" href=<%=mainMenu%>>Zurück</a>
</p>

