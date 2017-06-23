<%@ include file="/init.jsp"%>
<%@page import="de.ki.sbamdc.model.Flashcard" %>
<%@page import="de.ki.sbamdc.model.CardBox" %>

<portlet:actionURL name="toFlashcardOverview" var="back"></portlet:actionURL>
<portlet:actionURL name="toMainMenu" var="mainMenu"></portlet:actionURL>

<% 
/* 	Flashcard fc = null;
	if(portletSession.getAttribute("flashcard")!=null)
		fc = (Flashcard)portletSession.getAttribute("flashcard");
	 */
	String fcFrontSide = (String)portletSession.getAttribute("fcFrontSide");
	String fcBackSide = (String)portletSession.getAttribute("fcBackSide");
	String fcTitle = (String)portletSession.getAttribute("fcTitle");
	String fcId = (String)portletSession.getAttribute("fcId");
	List<CardBox> cbList = null;
	if(portletSession.getAttribute("cardBoxList")!=null){
		cbList = (List<CardBox>)portletSession.getAttribute("cardBoxList");
	}
	String cbName = (String)portletSession.getAttribute("cardBoxName");
%>

<portlet:actionURL name="updateFlashcard" var="updateFlashcard">
	<portlet:param name="fcId" value="<%=fcId %>"/>
</portlet:actionURL>

<liferay-ui:success key="success" message="Your flashcard has been successfully updated!"/>
<liferay-ui:error key="error" message="Your flashcard could not be updated due to unknown reason!"/>
<liferay-ui:error key="titleExistsError" message="Could not update the flashcard. The name of the flashcard is already assigned!"/>

<aui:container align="center">
<aui:form action="<%=updateFlashcard %>">
<aui:field-wrapper label="Hier Karteikarte editieren">
	
		<liferay-ui:input-editor name="fcFrontSide" toolbarSet="email" contents="<%=fcFrontSide %>" width="200" />
	  	<liferay-ui:input-editor name="fcBackSide" toolbarSet="email" contents="<%=fcBackSide%>" width="200"/>
	
	    Kartenbezeichnung: <input type="text" name="<portlet:namespace/>flashcardTitle" required="true" value="<%=fcTitle %>"/>
	    Kartei: 
		<select name= "<portlet:namespace />kartei" required="true" >
			<%for (CardBox cb : cbList){ 
				if(cb.getName()==cbName){
			%>
			<option selected="selected" value="<%=cb.getName()%>"><%=cb.getName() %> </option>
			<% }else{ 	
			%>
			<option value="<%=cb.getName()%>"><%=cb.getName() %> </option>
			<%}} %>
		</select>
	    
	    <aui:button type="submit" value="Update"></aui:button>
	    
</aui:field-wrapper>
</aui:form>

<span>
<a class="btn btn-warning" href=<%=back %>>Zurück</a> 
</span>
<span>
<a class="btn btn-warning" href=<%=mainMenu%>>Hauptmenü</a>
</span>
</aui:container>
