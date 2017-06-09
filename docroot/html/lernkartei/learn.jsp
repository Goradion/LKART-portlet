<%@ include file="/init.jsp"%>
<%@page import="java.util.List"%>
<%@page import="de.ki.sbamdc.model.Flashcard"%>
<%@page import="de.ki.sbamdc.service.FlashcardLocalServiceUtil" %>

<portlet:actionURL name="toMainMenu" var="back"></portlet:actionURL>
<portlet:actionURL name="toLearn" var="startLearning"></portlet:actionURL>

<h1>Hier Karteikarten lernen</h1>

<a href=<%=back %>>Zurück</a>


