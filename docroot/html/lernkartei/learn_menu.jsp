<%@ include file="/init.jsp"%>

<portlet:actionURL name="toMainMenu" var="back"></portlet:actionURL>
<portlet:actionURL name="toLearn" var="startLearning"></portlet:actionURL>
<h1>Hier Karteikarten lernen</h1>
<aui:form action="<%=startLearning %>">
<aui:field-wrapper label="Hier neue Karteikarte erstellen">
    
    Kartei: <br />
	<select name= "<portlet:namespace />kartei" required="true">
		<c:forEach items="${sessionScope.cardBoxList}" var="c">
			<option value="${c.getId()}">${c.getName()}</option>
		</c:forEach>
	</select>
    
    <aui:button type="submit" value="Create"></aui:button>
  
</aui:field-wrapper>
</aui:form>
<a href=<%=back %>>Zurück</a>


