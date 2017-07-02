<%@ include file="/init.jsp"%>

<liferay-ui:success key="success" message="Ihre Kartei wurde erstellt!" />
<portlet:actionURL name="saveCardBox" var="saveCardBox"></portlet:actionURL>
<portlet:actionURL name="toCardBoxOverview" var="cardBoxOverview"></portlet:actionURL>
<aui:container align="center">
	<h1>Neue Lernkartei</h1>
	<aui:form method="POST" action="${saveCardBox}">
	<p>
	<input placeholder="Name" title="Name der Lernkartei" type="text" name="<portlet:namespace/>cardBoxName"
			value="${cardBoxName}" maxlength="75" required/>
		<p/>
		<a class="btn btn-warning" href=<%=cardBoxOverview%>>Zurück</a>
		<aui:button type="submit" value="Erstellen" />
	</aui:form>
</aui:container>