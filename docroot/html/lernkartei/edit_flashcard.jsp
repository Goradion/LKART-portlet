<%@ include file="/init.jsp"%>
<%@page import="de.ki.sbamdc.model.Flashcard" %>
<%@page import="de.ki.sbamdc.model.CardBox" %>
<portlet:actionURL name="toFlashcardOverview" var="back"></portlet:actionURL>
<portlet:actionURL name="updateFlashcard" var="updateFlashcard">
	<portlet:param name="fcId" value="<%=(String)portletSession.getAttribute("flashcardId") %>"/>
</portlet:actionURL>

<% 
	Flashcard fc = null;
	if(portletSession.getAttribute("flashcard")!=null)
		fc = (Flashcard)portletSession.getAttribute("flashcard");
	List<CardBox> cbList = null;
	if(portletSession.getAttribute("cardBoxList")!=null){
		cbList = (List<CardBox>)portletSession.getAttribute("cardBoxList");
	}
	String cbName = (String)portletSession.getAttribute("cardBoxName");
%>

<aui:form action="<%=updateFlashcard %>">
<aui:field-wrapper label="Hier Karteikarte editieren">
	
    <liferay-ui:input-editor name="flashcardEditor" toolbarSet="simple" contents="<%=fc.getContent() %>" width="200" />
  	<hr/>
	Kartenbezeichnung: <input type="text" name="<portlet:namespace/>flashcardTitle" required="true" value="<%=fc.getTitle() %>"/>
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

<a href=<%=back %>>Zurück</a>