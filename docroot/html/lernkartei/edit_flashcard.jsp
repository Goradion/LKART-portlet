<%@ include file="/init.jsp"%>

<portlet:actionURL name="toFlashcardOverview" var="back"></portlet:actionURL>
<portlet:actionURL name="updateFlashcard" var="updateFlashcard">
	<portlet:param name="fcId" value="${sessionScope.flashcardId }"/>
</portlet:actionURL>

<p><%=(String)portletSession.getAttribute("flashcardId") %></p>
<p><%=(String)portletSession.getAttribute("flashcardContent") %></p>

<!-- TEST -->
<aui:form action="<%=updateFlashcard %>">
<aui:field-wrapper label="Hier Karteikarte editieren">
	Kartenbezeichnung: <input type="text" name="<portlet:namespace/>flashcardTitle" required="true"/>
    <liferay-ui:input-editor name="flashcardEditor" toolbarSet="simple" contents="${sessionScope.flashcardContent}" width="200" />
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