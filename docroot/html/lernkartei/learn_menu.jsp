<%@ include file="/init.jsp"%>

<portlet:actionURL name="toMainMenu" var="back"></portlet:actionURL>
<portlet:actionURL name="toLearnMode" var="startLearning"></portlet:actionURL>
<aui:form action="<%=startLearning %>">
<aui:field-wrapper label="Was soll gelernt werden?">
    
    Kartei: <br />
	<select name= "<portlet:namespace />kartei" required="true">
		<c:forEach items="${sessionScope.cardBoxList}" var="c">
			<option value="${c.getId()}">${c.getUserName()}.${c.getName()}</option>
		</c:forEach>
	</select>
    
    <aui:button type="submit" value="Los gehts"></aui:button>
  
</aui:field-wrapper>
</aui:form>
<br>
<%-- <c:forEach items="${sessionScope.cardBoxList}" var="c">
	<portlet:actionURL name="toLearnMode" var="startLearning">
		<portlet:param name="cardBoxId" value="${c.getId()}"/>
	</portlet:actionURL>
	<a href = <%=startLearning%>>${c.getName()}</a> <br>
</c:forEach> --%>
<a href=<%=back %>>Zur�ck</a>


