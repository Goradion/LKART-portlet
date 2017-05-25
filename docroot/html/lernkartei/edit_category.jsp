<%@ include file="/init.jsp"%>



<portlet:actionURL name="saveCardBox" var="saveCardBox"></portlet:actionURL>
<portlet:actionURL name="toCardBoxOverview" var="cardBoxOverview"></portlet:actionURL>
<h1>Karteikasten ändern</h1>
<form method="POST" action="${saveCardBox}" >
<input type="text" name="<portlet:namespace />cardBoxId" value="${sessionScope.cardBoxId}" maxlength="75"  readonly	hidden="true"/> <br />
Name:
<input type="text" name="<portlet:namespace />cardBoxName" value="${sessionScope.cardBoxName}" maxlength="75" /> <br/>
Sichtbar schalten:
<input type="checkbox" name="<portlet:namespace />shared" value="shared" ${sessionScope.shared ? 'checked' : ''} /><br/>
<input type="submit" value="Abschicken"> <br>
</form>

<p><a href=<%=cardBoxOverview%>>Zurück</a></p>