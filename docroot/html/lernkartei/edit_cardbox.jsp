<%@ include file="/init.jsp"%>



<portlet:actionURL name="saveCardBox" var="saveCardBox"></portlet:actionURL>
<portlet:actionURL name="toCardBoxOverview" var="cardBoxOverview"></portlet:actionURL>

<aui:container align="center">
	<h1>Karteikasten ändern</h1>
	<aui:form method="POST" action="${saveCardBox}">
	<input type="text" name="<portlet:namespace />cardBoxId" value="${portletSessionScope.cardBoxId}" maxlength="75"  readonly	hidden="true"/> <br />
	<p>
	<input placeholder="Name" title="Name der Lernkartei" type="text" name="<portlet:namespace/>cardBoxName"
			value="${portletSessionScope.cardBoxName}" maxlength="75" required/>
		<p/>
		<p>
		<input type="checkbox" name="<portlet:namespace />shared" ${portletSessionScope.cardBoxShared ? 'checked' : ''} />
		Teilen
		</p>
		<a class="btn btn-warning" href=<%=cardBoxOverview%>>Abbrechen</a>
		<aui:button type="submit" value="Ändern" />
	</aui:form>
</aui:container>

