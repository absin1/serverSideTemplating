
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
		<div class="slider multiple-items">
			<%=ComponentManager.getInstance().createPage(2)%>
		</div>

		<div id="chart_div"></div>
		<div id="gg"></div>

		<table class="Displaytable" data-display="chart_div">
			<tr>
				<th></th>
				<th>Forms</th>
				<th>A</th>
				<th>B</th>
				<th>C</th>
				<th>TotalTime</th>
			</tr>
			<tr>
				<th>Row 1</th>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>3</td>
			</tr>
			<tr>
				<th>Row 2</th>
				<td>2</td>
				<td>2</td>
				<td>2</td>
				<td>2</td>
				<td>6</td>
			</tr>
			<tr>
				<th>Row 3</th>
				<td>3</td>
				<td>3</td>
				<td>3</td>
				<td>3</td>
				<td>9</td>
			</tr>
		</table>

		<table class="Displaytable" data-display="gg">
			<tr>
				<th></th>
				<th>Forms</th>
				<th>A</th>
				<th>B</th>
				<th>C</th>
				<th>TotalTime</th>
			</tr>
			<tr>
				<th>Row 1</th>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>3</td>
			</tr>
			<tr>
				<th>Row 2</th>
				<td>2</td>
				<td>2</td>
				<td>2</td>
				<td>2</td>
				<td>6</td>
			</tr>
			<tr>
				<th>Row 3</th>
				<td>3</td>
				<td>3</td>
				<td>3</td>
				<td>3</td>
				<td>9</td>
			</tr>
		</table>


	</div>
	<jsp:include page="inc/foot.jsp"></jsp:include>
</body>
</html>
