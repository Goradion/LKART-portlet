<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<<portlet:actionURL name="test" var="toTestMethod"></portlet:actionURL>

<portlet:defineObjects />

This is the <b>Lernkarteikarten</b> portlet in View mode. <br>
<a href=<%=toTestMethod %>>Click me!</a>
