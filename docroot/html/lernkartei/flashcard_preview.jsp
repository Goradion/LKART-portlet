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




<script type="text/javascript">
	document.onclick = function(){
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