<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:actionURL name="toEditMode" var="zumEditModus"></portlet:actionURL>
<portlet:actionURL name="toLearnMode" var="lernen"></portlet:actionURL>
<portlet:defineObjects />

<h1>Lernkartei-Portlet-Hauptmenü</h1>

<a href=<%=lernen %>>Lernen</a> <br>
<a href=<%=zumEditModus %>>Editor Modus</a>
