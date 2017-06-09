<%@ include file="/init.jsp"%>

<portlet:actionURL name="toFlashcardOverview" var="back"></portlet:actionURL>
<portlet:actionURL name="toNewCardBox" var="newCardBox"></portlet:actionURL>
<portlet:actionURL name="createNewFlashcard" var="createFlashcard"></portlet:actionURL>
<liferay-ui:success key="success" message="You've successfully created a new flashcard"/>
<liferay-ui:error key="error" message="Your new flashcard could not be saved! May you left the input field empty."/>

<c:choose>
<c:when test="${! empty sessionScope.cardBoxList}">
	<aui:form action="<%=createFlashcard %>">
	<aui:field-wrapper label="Hier neue Karteikarte erstellen">
	    <liferay-ui:input-editor name="fcFrontSide" toolbarSet="simple" contents="Front side of your flashcard" width="200" />
	    <liferay-ui:input-editor name="fcBackSide" toolbarSet="simple" contents="Back side of your flashcard" width="200"/>
	    Kartenbezeichnung: <input type="text" name="<portlet:namespace/>flashcardTitle" required="true"/> </br>
	    Kartei:
		<select name= "<portlet:namespace />kartei" required="true">
			<c:forEach items="${sessionScope.cardBoxList}" var="c">
				<option value="${c.getName()}">${c.getName()}</option>
			</c:forEach>
		</select>
		</br>
	    <aui:button type="submit" value="Create"></aui:button>
	</aui:field-wrapper>
	</aui:form>
</c:when>
<c:otherwise>
	<p>Sie haben noch keine Lernkarteien! Klicken Sie <a href="<%=newCardBox%>">hier</a> um eine neue zu erstellen.</p>
</c:otherwise>
</c:choose>
<a href=<%=back%>>Zurück</a>