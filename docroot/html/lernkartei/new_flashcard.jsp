<%@ include file="/init.jsp"%>

<portlet:actionURL name="toFlashcardOverview" var="back"></portlet:actionURL>
<portlet:actionURL name="createNewFlashcard" var="createFlashcard"></portlet:actionURL>

<!-- TEST -->
<aui:form action="<%=createFlashcard %>">
<aui:field-wrapper label="Hier neue Karteikarte erstellen">
    <liferay-ui:input-editor name="flashcardEditor" toolbarSet="simple" contents="Hier die Karteikarte" width="200" />
    
    Kartei: <br />
	<select name= "<portlet:namespace />kartei" required="true">
		<c:forEach items="${sessionScope.cardBoxList}" var="c">
			<option value="${c.getScore()}">${c.getScore()}</option>
		</c:forEach>
	</select>
    
    <aui:button type="submit" value="Create"></aui:button>
  
</aui:field-wrapper>
</aui:form>
<!-- TEST END -->
<a href=<%=back %>>Zurück</a>