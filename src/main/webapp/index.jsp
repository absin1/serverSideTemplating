  <%@page import="com.TestVelocity"%>
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
				<div class="slider multiple-items">
					<%for(int i=0; i<10;i++){ %>
					<%= new TestVelocity().getCaurosel() %>
				<% } %>
				</div>
				
				

		<div class="card" style="width: 23rem; min-height: 15rem;">
			<div class=" card-right schedule_card_color"></div>
			<div class="task_icon schedule_card_icon"></div>


			<div class="card-block p-0 m-0 bg-white">
			<div class="container pt-2 pb-2">
			<div class=" row  bg-white">
				<div class="d-flex">
				<div class="col-md-12">
					<p4 class=" schedule_card_textcolor"> <i
						class="fa fa-clock-o"></i> 04:16 PM </p4>
					<p4 class=" schedule_card_textcolor"> <i
						class="fa fa-hourglass-o"></i> 6 hrs : 0 mins </p4>
				</div></div>
				</div></div>
				<div class="container pt-2 pb-2">
					<div class=" row  bg-white">
						<div class="col-md-3  pr-0">
							<img alt="Retail Banking " align="middle" class="w-100 h-100"
								ng-src="http://business.talentify.in:9999//course_images/5.png"
								src="http://business.talentify.in:9999//course_images/5.png">
						</div>
						<div class="col-md-9">
							<h6>h6. Bootstrap heading</h6>
							<h4>h4. Bootstrap heading</h4>
							<h5>h5. Bootstrap heading</h5>
						</div>

					</div>
				</div>
				<hr class="mb-0">
				<div class="container pt-2 pb-2">
				
				<div class="row text-center">
					<div class="col-md-4 text-left">
					Attendance
					</div>
					<div class="col-md-4">
					Student
					</div>
					<div class="col-md-4">
					Trainer
					</div>
				</div>
				<div class="row text-center 	">
					<div class="col-md-4 text-left">
					59.74%
					</div>
					<div class="col-md-4">
					<div class="rateYo" data-rating="3.5" data-star_width="17"></div>
					</div>
					<div class="col-md-4">
					<div class="rateYo" data-rating="4.5" data-star_width="17"></div>
					
					</div>
				</div>
				</div>
			</div>



		</div>


		<div id="chart_div"></div>
					    <div id="gg"></div>
					    <div id="new_div"></div>
					    <div id="old_div"></div>

		<table class="Displaytable hide_div" data-display="chart_div" >
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
				<td>10</td>
				<td>14</td>
				<td>15</td>
				<td>19</td>
				<td>33</td>
			</tr>
			<tr>
				<th>Row 2</th>
				<td>21</td>
				<td>22</td>
				<td>23</td>
				<td>33</td>
				<td>62</td>
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



<table class="Displaytable hide_div" data-display="new_div" >
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
				<td>10</td>
				<td>14</td>
				<td>15</td>
				<td>19</td>
				<td>33</td>
			</tr>
			<tr>
				<th>Row 2</th>
				<td>21</td>
				<td>22</td>
				<td>23</td>
				<td>33</td>
				<td>62</td>
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
		<table class="Displaytable hide_div" data-display="old_div" >
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
				<td>10</td>
				<td>14</td>
				<td>15</td>
				<td>19</td>
				<td>33</td>
			</tr>
			<tr>
				<th>Row 2</th>
				<td>21</td>
				<td>22</td>
				<td>23</td>
				<td>33</td>
				<td>62</td>
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
		<table class="Displaytable hide_div" data-display="gg">
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
