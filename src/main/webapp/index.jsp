  <%@ page pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<jsp:include page="inc/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="inc/navbar.jsp"></jsp:include>
	<div class="container">
		<div class="starter-template">
			<h1>Bootstrap starter template</h1>
			</div>
			<div class="slider multiple-items">
					<%for(int i=0; i<10;i++){ %>
				<div class="card p-2 m-3 border-0" style="width: 20rem;">
				<div class="myborder">
				<div class="card-block">
					<h4 class="card-title">Card title</h4>
					<p class="card-text">Some quick example text</p>
				</div>
				<img class="card-img-top" height="30%" width="100%" src="http://www.course-view.com/courses_img/Teaching%20picture.jpg" alt="Card image cap">
					<div class="card-block">
						<p class="card-text">Some quick example text to build on the
							card title and make up the bulk of the card's content.</p>
						
					</div>
					</div>
					<a href="#" class="btn caurosal_button theme_background">Go somewhere</a>
				</div>
				<% } %>
				</div>
					
					    <div id="chart_div"></div>
					    <div id="gg"></div>

<table class="Displaytable" data-display="chart_div">
  <tr>
    <th></th>
    <th>
      Forms
    </th>
    <th>
      A
    </th>
    <th>
      B
    </th>
    <th>
      C
    </th>
    <th>
      TotalTime
    </th>
  </tr>
  <tr>
    <th>
      Row 1
    </th>
    <td>
      1
    </td>
    <td>
      1
    </td>
    <td>
      1
    </td>
    <td>
      1
    </td>
    <td>
      3
    </td>
  </tr>
  <tr>
    <th>
      Row 2
    </th>
    <td>
      2
    </td>
    <td>
      2
    </td>
    <td>
      2
    </td>
    <td>
      2
    </td>
    <td>
      6
    </td>
  </tr>
  <tr>
    <th>
      Row 3
    </th>
    <td>
      3
    </td>
    <td>
      3
    </td>
    <td>
      3
    </td>
    <td>
      3
    </td>
    <td>
      9
    </td>
  </tr>
</table>

<table class="Displaytable" data-display="gg">
  <tr>
    <th></th>
    <th>
      Forms
    </th>
    <th>
      A
    </th>
    <th>
      B
    </th>
    <th>
      C
    </th>
    <th>
      TotalTime
    </th>
  </tr>
  <tr>
    <th>
      Row 1
    </th>
    <td>
      1
    </td>
    <td>
      1
    </td>
    <td>
      1
    </td>
    <td>
      1
    </td>
    <td>
      3
    </td>
  </tr>
  <tr>
    <th>
      Row 2
    </th>
    <td>
      2
    </td>
    <td>
      2
    </td>
    <td>
      2
    </td>
    <td>
      2
    </td>
    <td>
      6
    </td>
  </tr>
  <tr>
    <th>
      Row 3
    </th>
    <td>
      3
    </td>
    <td>
      3
    </td>
    <td>
      3
    </td>
    <td>
      3
    </td>
    <td>
      9
    </td>
  </tr>
</table>
					
			
		</div>
	<jsp:include page="inc/foot.jsp"></jsp:include>
</body>
</html>
