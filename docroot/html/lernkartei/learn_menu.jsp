<%@ include file="/init.jsp"%>

<portlet:actionURL name="toMainMenu" var="back"></portlet:actionURL>
<portlet:actionURL name="toLearnMode" var="startLearning"></portlet:actionURL>
<liferay-ui:error key="noFlashcardsError"
	message="Die gewählte Lernkartei enthält keine Karteikarten!" />
<c:choose>
	<c:when test="${not empty sessionScope.cardBoxMap}">
		<aui:form action="<%=startLearning%>" style="text-align:center">
			<h2>Was soll gelernt werden?</h2>
			<p>
				Kartei: <select name="<portlet:namespace />kartei" required="true">
					<c:forEach items="${sessionScope.cardBoxMap}" var="entry">
						<optgroup label="${entry.key}">
							<c:forEach items="${entry.value}" var="cardBox">
								<option value="${cardBox.getId()}">${cardBox.getName()}</option>
							</c:forEach>
						</optgroup>
					</c:forEach>
				</select>
			</p>
			<p>
				<a class="btn btn-warning" href=<%=back%>>Zurück</a>
				<aui:button type="submit" value="Los gehts"></aui:button>
			</p>
		</aui:form>
	</c:when>
	<c:otherwise>
		<div style="text-align: center">
			<p>Es gibt nichts zu lernen!</p>
			<a class="btn btn-warning" href=<%=back%>>Zurück</a>
		</div>


	</c:otherwise>
</c:choose>

