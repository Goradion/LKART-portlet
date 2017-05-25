<%@ include file="/init.jsp"%>




<portlet:actionURL name="saveCardBox" var="saveCardBox"></portlet:actionURL>
<portlet:actionURL name="toCardBoxOverview" var="cardBoxOverview"></portlet:actionURL>
<h1>Neuer Karteikasten</h1>
<form method="POST" action="${saveCardBox}" >
Name:
<input type="text" name="<portlet:namespace/>cardBoxName" value="${cardBoxName}" maxlength="75" /> <br />
<input type="submit" value="Abschicken"> <br>
</form>
<p><a href=<%=cardBoxOverview%>>Zurück</a></p>