
<%@page import="com.viksitpro.ui.component.ComponentManager"%>
<%@ page pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<jsp:include page="inc/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="inc/navbar.jsp"></jsp:include>
	<div class="container">
		<div class="starter-template">
			<h1>Bootstrap starter template</h1>
		</div>
		
			<%=ComponentManager.getInstance().createPage(2)%>
		

		


	</div>
	<jsp:include page="inc/foot.jsp"></jsp:include>
</body>
</html>
