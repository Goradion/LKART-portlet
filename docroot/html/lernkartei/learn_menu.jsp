<%@ include file="/init.jsp"%>

<portlet:actionURL name="toMainMenu" var="back"></portlet:actionURL>
<portlet:actionURL name="toLearnMode" var="startLearning"></portlet:actionURL>
<aui:form action="<%=startLearning %>">
<aui:field-wrapper label="Was soll gelernt werden?">
    
    <p>
    Kartei: 
	<select name= "<portlet:namespace />kartei" required="true">
		<c:forEach items="${sessionScope.cardBoxMap}" var="entry">
			<optgroup label="${entry.key}">
				<c:forEach items="${entry.value}" var="cardBox">
					<option value="${cardBox.getId()}">${cardBox.getName()}</option>
				</c:forEach>
			</optgroup>
		</c:forEach>
	</select>
    </p>
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
<a href=<%=back %>>Zurück</a>


