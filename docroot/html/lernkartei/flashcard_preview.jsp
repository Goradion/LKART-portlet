<%@ include file="/init.jsp"%>
<%
	String frontSide = (String)renderRequest.getParameter("fcFrontSide");
	String backSide = (String)renderRequest.getParameter("fcBackSide");
%>

<div id="frontSide">
	<% out.print(frontSide); %>
</div>
<div id="backSide" hidden="true">
	<% out.print(backSide); %>
</div>
<footer>
<div align="center">
	<hr>
	<button id="flipTheCard" style="">Karte umdrehen</button>
</div>
</footer>



<script type="text/javascript">
	// flips the card each time the button is clicked
	document.getElementById("flipTheCard").onclick = function(){
		var frontSideHidden = document.getElementById("frontSide").getAttribute("hidden");
		var backSideHidden = document.getElementById("backSide").getAttribute("hidden");
		console.log("frontSideHidden = "+frontSideHidden);
		console.log("backSideHidden = "+backSideHidden);
		if(frontSideHidden == null || frontSideHidden ==""){
			document.getElementById("frontSide").setAttribute("hidden", "true");
			document.getElementById("backSide").removeAttribute("hidden");
		} else {
			document.getElementById("frontSide").removeAttribute("hidden");
			document.getElementById("backSide").setAttribute("hidden", "true");
		}
	};
</script>