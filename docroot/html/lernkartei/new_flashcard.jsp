<%@page import="javax.portlet.PortletSession"%>
<%@ include file="/init.jsp"%>
<%@page import="de.ki.sbamdc.model.CardBox"%>

<portlet:actionURL name="toFlashcardOverview" var="back"></portlet:actionURL>
<portlet:actionURL name="toNewCardBox" var="newCardBox"></portlet:actionURL>
<portlet:actionURL name="createNewFlashcard" var="createFlashcard"></portlet:actionURL>
<portlet:actionURL name="toMainMenu" var="mainMenu"></portlet:actionURL>

<%
	List<CardBox> cbList = null;
	if (portletSession.getAttribute("cardBoxList", PortletSession.APPLICATION_SCOPE) != null) {
		cbList = (List<CardBox>) portletSession.getAttribute("cardBoxList", PortletSession.APPLICATION_SCOPE);
	}
	String cbName = "";
	String fcBackSide = "Backside of your flashcard";
	String fcFrontSide = "Frontside of your flashcard";
	String flashcardTitle = "";
	
	if (portletSession.getAttribute("kartei") != null)
		cbName = (String) portletSession.getAttribute("kartei");
	if (portletSession.getAttribute("fcBackSide") != null)
		fcBackSide = (String) portletSession.getAttribute("fcBackSide");
	if (portletSession.getAttribute("fcFronSide") != null)
		fcFrontSide = (String) portletSession.getAttribute("fcFrontSide");
	if (portletSession.getAttribute("flashcardTitle") != null)
		flashcardTitle = (String) portletSession.getAttribute("flashcardTitle");
%>


<liferay-ui:success key="success"
	message="You've successfully created a new flashcard" />
<liferay-ui:error key="error"
	message="Your new flashcard could not be saved! May you left the input field empty." />
<liferay-ui:error key="titleExistsError"
	message="Could not create new flashcard. The name of the flashcard is already assigned!" />

<aui:container align="center">
<%
	if (!cbList.isEmpty() && cbList != null){
%>

<aui:form action="<%=createFlashcard%>">
	<aui:field-wrapper label="Hier neue Karteikarte erstellen">

			
		<liferay-ui:input-editor name="fcFrontSide" toolbarSet="email"
			contents="<%=fcFrontSide%>"/>
		<liferay-ui:input-editor name="fcBackSide" toolbarSet="email"
			contents="<%=fcBackSide%>"/>

   
    <label for="flashcardTitle">Kartenbezeichnung</label> <input id="flashcardTitle" type="text"
			name="<portlet:namespace/>flashcardTitle" required="true"
			value="<%=flashcardTitle%>" />
    <label for="kartei">Kartei</label>
	<select id="kartei" name="<portlet:namespace />kartei" required="true">
			<%
				for (CardBox cb : cbList) {
							if (cb.getName() == cbName) {
			%>
			<option selected="selected" value="<%=cb.getName()%>"><%=cb.getName()%>
			</option>
			<%
				} else {
			%>
			<option value="<%=cb.getName()%>"><%=cb.getName()%>
			</option>
			<%
				}
						}
			%>
		</select>

		<aui:button type="submit" value="Create"></aui:button>

	</aui:field-wrapper>
</aui:form>

<%} else { %>
	<p>Sie haben noch keine Lernkarteien! Klicken Sie <a href="<%=newCardBox%>">hier</a> um eine neue zu erstellen.</p>
<%} %>


<span>
<a class="btn btn-warning" href=<%=back %>>Zurück</a> 
</span>
<span>
<a class="btn btn-warning" href=<%=mainMenu%>>Hauptmenü</a>
</span>

</aui:container>