$( document ).ready(function() {
	$('.multiple-items').slick({
		  infinite: false,
		  adaptiveHeight: false,
		  slidesToShow: 3,
		  slidesToScroll: 3,
		  dots: true,
		  arrows: true,
		});
	
	
	
	
	google.charts.load('current', {'packages':['corechart']});

    // Set a callback to run when the Google Visualization API is loaded.
    google.charts.setOnLoadCallback(drawChart);

    // Callback that creates and populates a data table,
    // instantiates the pie chart, passes in the data and
    // draws it.
    function drawChart() {
    	  var tableRows = [];
    	  var results = document.getElementsByClassName('Displaytable');
    	  Array.prototype.forEach.call(results, function(table) {
    	  Array.prototype.forEach.call(table.rows, function(row) {
    		    var tableColumns = [];
    		    Array.prototype.forEach.call(row.cells, function(cell) {
    		        var cellText = cell.textContent || cell.innerText;
    		        switch (cell.cellIndex) {
    		        case 0:
    		            tableColumns.push(cellText.trim());
    		            break;

    		          default:
    		            switch (row.rowIndex) {
    		              case 0:
    		                tableColumns.push(cellText.trim());
    		                break;

    		              default:
    		                tableColumns.push(parseFloat(cellText));
    		            }
    		        }
    		      });
    		      tableRows.push(tableColumns);
    		    });
    	  
    	  var display_graph_div = table.getAttribute("data-display");
    	  var data = google.visualization.arrayToDataTable(tableRows);
    	  var chart = new google.visualization.ColumnChart(document.getElementById(display_graph_div));
    	  chart.draw(data);
    	  });
    	 
    }
    $(".rateYo").each(function() {
    	  var rating = $( this ).data( "rating" );
    	  var star_width = $( this ).data( "star_width" )+'px';
    	  $( this ).rateYo({
    	        rating: rating,
    	        readOnly: true,
    	        starWidth: star_width
    	      });

    });
    
/*    $("#rateYo").rateYo({
        rating: 3.2,
        readOnly: true,
        starWidth: "17px"
      });
*/});