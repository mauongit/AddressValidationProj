<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Autocomplete in java web application using Jquery and JSON</title>
<script src="/AddressValidationProj/scripts/jquery.js"></script>
  <script src="/AddressValidationProj/scripts/jquery-ui.js"></script>
<script src="/AddressValidationProj/scripts/autocompleter.js"></script>
<link rel="stylesheet" 
  href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.1/jquery.mCustomScrollbar.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.1/jquery.mCustomScrollbar.js"></script>
<link rel="stylesheet" 
  href="/AddressValidationProj/css/jquery-ui.css">
<!-- User defied css -->
<link rel="stylesheet" href="/AddressValidationProj/css/style.css">

 



<script type="text/javascript">

$( document ).ready(function() {


    
    $("#result-div").hide();
    
    $(".search-container").on("keydown",function() {
    	$("#result-div").show();
    	$(".ui-autocomplete").hide();
    	
    	
    	
        $.getJSON( "http://localhost:8080/AddressValidationProj/SearchController?term="+$("#search").val(), function( data ) {
      	  var items = [];
      	  var obj = data;
      	  var array = obj.stateAddressMap;
      	    var html = "";
      	    for (var key in array) {
      		  html = html + '<div class="state"><h5>'+key+'</h5><hr/><div class="section">';
      	    	var cityArray = array[key];
      	    	for (i = 0; i < cityArray.length; i++) {
      	    		html = html + '<div class="city">'+ cityArray[i].address1 +', '+ cityArray[i].postalcode +'</div></br>';
      	    	}
      	    	html = html + '</div></div>';
      	    }
      	  	$('#result-div').html(html);
      	  $('#result-div .state .section').mCustomScrollbar();
      	});
    	
    });
    
    
   // var stateJSON = $.getJson("http://localhost:8080/AddressValidationProj/SearchController?term=52");
    //alert(stateJSON);
    

    
});
</script>


</head>
<body>

<div class="title">
        <h3>Autocomplete in java web application using Jquery and JSON</h3>
</div>
<br />
<br />
<div class="search-container">
        <div class="ui-widget">
                <input type="text" id="search" name="search" class="text-field" />
        </div>
  		
</div>

<div id="result-div"></div>

</body>
</html>

