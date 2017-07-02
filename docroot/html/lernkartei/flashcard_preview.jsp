<%@ include file="/init.jsp"%>
<%
	String frontSide = (String)renderRequest.getParameter("fcFrontSide");
	String backSide = (String)renderRequest.getParameter("fcBackSide");
%>

<div id="flip" style="width:450px; height:270px; max-width: 100%; text-align: center">
	<div style="position:relative;" id="frontSide" >
		<% out.print(frontSide); %>
	</div>
	<div style="position:relative;" id="backSide" hidden="true">
		<% out.print(backSide); %>
	</div>
</div>


<script type="text/javascript">

	document.getElementById("flip").setAttribute("title", "Clicken zum Umdrehen");
	// flips the card each time the button is clicked
	var flipTheCard = function() {
		
		var frontSideHidden = document.getElementById("frontSide").getAttribute("hidden");
		var backSideHidden = document.getElementById("backSide").getAttribute("hidden");
		if(frontSideHidden == null || frontSideHidden ==""){
			document.getElementById("frontSide").setAttribute("hidden", "true");
			document.getElementById("backSide").removeAttribute("hidden");
		} else {
			document.getElementById("frontSide").removeAttribute("hidden");
			document.getElementById("backSide").setAttribute("hidden", "true");
		}
	}
	document.getElementById("flip").onclick = flipTheCard;

</script>