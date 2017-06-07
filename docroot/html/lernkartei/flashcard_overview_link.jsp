<%@ include file="/init.jsp"%>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="de.ki.sbamdc.model.Flashcard" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Flashcard flashcard = (Flashcard)row.getObject();
	long flashcardId = flashcard.getPrimaryKey();
%>


<portlet:renderURL var="DialogIframe"
windowState="<%=LiferayWindowState.POP_UP.toString()%>">
<portlet:param name="mvcPath"
value="/html/lernkartei/flashcard_preview.jsp"/>
</portlet:renderURL>
<div>
<aui:button name='<%=""+flashcardId %>'
value="Hier soll die Kartenbezeichnung stehen"> </aui:button>
</div>
<aui:script>
AUI().use('aui-base',
'aui-io-plugin-deprecated',
'liferay-util-window',
'aui-dialog-iframe-deprecated',
function(A) {
A.one('#<portlet:namespace /><%=""+flashcardId %>').on('click', function(event){
var popUpWindow=Liferay.Util.Window.getWindow(
{
dialog: {
centered: true,
constrain2view: true,
//cssClass: 'yourCSSclassName',
modal: true,
resizable: false,
width: 500
}
}
).plug(
A.Plugin.DialogIframe,
{
autoLoad: true,
iframeCssClass: 'dialog-iframe',
uri:'<%=DialogIframe.toString()%>'
}).render();
popUpWindow.show();
popUpWindow.titleNode.html("Flashcard preview");
popUpWindow.io.start();

});
});
</aui:script>


