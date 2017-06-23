<%@ include file="/init.jsp"%>
<%@page import="java.util.List"%>
<%@page import="de.ki.sbamdc.model.Flashcard"%>
<%@page import="de.ki.sbamdc.service.FlashcardLocalServiceUtil"%>

<portlet:actionURL name="toMainMenu" var="back"></portlet:actionURL>
<portlet:actionURL name="submitLeitner" var="correct">
	<portlet:param name="known" value="true"/>
</portlet:actionURL>
<portlet:actionURL name="submitLeitner" var="wrong">
	<portlet:param name="known" value="false"/>
</portlet:actionURL>

<aui:container>
	<aui:row>
	<c:forEach items="${portletSessionScope.progressQueues}" var="q" varStatus="loop">
			<portlet:actionURL name="chooseProgress" var="choose">
				<portlet:param name="progress" value="${loop.index}"/>
			</portlet:actionURL>
			<span>
				<a href= <%=choose %> style='color:${"cyan"}; ${loop.index == portletSessionScope.progress ? "background-color:gray;": ""}'  class="btn btn-default">
	  				<span class="glyphicon glyphicon-folder-open" aria-hidden="true">
	  					${q.size()}
	  				</span>
				</a>
			</span>
	</c:forEach>		
	</aui:row>
	<aui:row>
		${portletSessionScope.progressQueues.get(portletSessionScope.progress).peek().getFrontSide()}
	</aui:row>
	<aui:row>
		<a href=<%=wrong%>>Falsch</a>
		<a href=<%=correct%>>Richtig</a>
	</aui:row>
</aui:container>

<a href=<%=back %>>Zurück</a>