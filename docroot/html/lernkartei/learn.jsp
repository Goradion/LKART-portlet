<%@ include file="/init.jsp"%>
<%@page import="java.util.List"%>
<%@page import="de.ki.sbamdc.model.Flashcard"%>
<%@page import="de.ki.sbamdc.service.FlashcardLocalServiceUtil" %>

<portlet:actionURL name="toMainMenu" var="back"></portlet:actionURL>
<portlet:actionURL name="toLearn" var="startLearning"></portlet:actionURL>
<h1>Hier Karteikarten lernen</h1>
<aui:row>
hier sollen 5 fächer mit der anzahl hin
</aui:row>
<aui:row>
${sessionScope.flashcards.get(0).getFrontSide()}
</aui:row>
<aui:row>
<aui:col span="6"><aui:button >Falsch</aui:button></aui:col>
<aui:col span="6"><aui:button >Richtig</aui:button></aui:col>

</aui:row>


<a href=<%=back %>>Zurück</a>


