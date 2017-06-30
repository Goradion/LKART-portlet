<%@ include file="/init.jsp"%>
<%@page import="java.util.List"%>
<%@page import="de.ki.sbamdc.model.Flashcard"%>
<%@page import="de.ki.sbamdc.service.FlashcardLocalServiceUtil"%>

<portlet:actionURL name="toMainMenu" var="back"></portlet:actionURL>
<portlet:actionURL name="submitLeitner" var="correct">
	<portlet:param name="known" value="true" />
</portlet:actionURL>
<portlet:actionURL name="submitLeitner" var="wrong">
	<portlet:param name="known" value="false" />
</portlet:actionURL>

<aui:container align="center">
	<aui:row>
		<c:forEach items="${portletSessionScope.progressQueues}" var="q"
			varStatus="loop">
			<portlet:actionURL name="chooseProgress" var="choose">
				<portlet:param name="progress" value="${loop.index}" />
			</portlet:actionURL>
			<span>
				<a href= <%=choose %> style='color:${portletSessionScope.progressQueues.getColor(loop.index)}; ${loop.index == portletSessionScope.progress ? "background-color:gray;": ""}'  class="btn btn-default">
	  				<span class="glyphicon glyphicon-folder-open" aria-hidden="true">
	  					${q.size()}
	  				</span>
				</a>
			</span>
	</c:forEach>		
	</aui:row>

	<!-- 	 @formatter: off -->
	<iframe id="flashcardFrame" style="max-width: 100%"
		srcdoc='
			<div id="frontSide">
				${portletSessionScope.progressQueues.get(portletSessionScope.progress).peek().getFrontSide()}
			</div>
			<div id="backSide" hidden="true">
				${portletSessionScope.progressQueues.get(portletSessionScope.progress).peek().getBackSide()}
			</div>
			'
		width="500" height="300">
	</iframe>
	<!-- 	 @formatter: on -->
	<footer>
		<div>
			<hr>
			<button id="flipTheCard" style="">Karte umdrehen</button>
			
			<div id="submittingRow">
				<a href=<%=wrong%>>Falsch</a>
				<a href=<%=correct%>>Richtig</a>
			</div>
		</div>
	</footer>
	<script type="text/javascript">
		// flips the card each time the button is clicked
		document.getElementById("flipTheCard").onclick = function() {
			var iframe = document.getElementById('flashcardFrame');
			var innerDoc = iframe.contentDocument
					|| iframe.contentWindow.document;
			var frontSideHidden = innerDoc.getElementById("frontSide")
					.getAttribute("hidden");
			var backSideHidden = innerDoc.getElementById("backSide")
					.getAttribute("hidden");
			if (frontSideHidden == null || frontSideHidden == "") {
				innerDoc.getElementById("frontSide").setAttribute("hidden",
						"true");
				innerDoc.getElementById("backSide").removeAttribute("hidden");
				document.getElementById("submittingRow").removeAttribute(
						"hidden");
			} else {
				innerDoc.getElementById("frontSide").removeAttribute("hidden");
				innerDoc.getElementById("backSide").setAttribute("hidden",
						"true");
			}
		};
	</script>


	<a href=<%=back%>>Zurück</a>
</aui:container>
