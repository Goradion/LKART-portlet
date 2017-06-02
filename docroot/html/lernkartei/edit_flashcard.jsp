<%@ include file="/init.jsp"%>

<portlet:actionURL name="toFlashcardOverview" var="back"></portlet:actionURL>
<portlet:actionURL name="updateFlashcard" var="updateFlashcard">
	<portlet:param name="fcId" value="${flashcardId }"/>
</portlet:actionURL>

<!-- TEST -->
<aui:form action="<%=updateFlashcard %>">
<aui:field-wrapper label="Hier Karteikarte editieren">
    <liferay-ui:input-editor name="flashcardEditor" toolbarSet="simple" contents="${flashcardContent}" width="200" />
    
    Kartei: <br />
	<select name= "<portlet:namespace />kartei" required="true">
		<c:forEach items="${sessionScope.cardBoxList}" var="c">
			<option value="${c.getName()}">${c.getName()}</option>
		</c:forEach>
	</select>
    
    <aui:button type="submit" value="Update"></aui:button>
  
</aui:field-wrapper>
</aui:form>
<!-- TEST END -->
<a href=<%=back %>>Zurück</a>