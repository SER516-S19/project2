$(document).ready(function() {
		$.ajax({
		    url : "https://opentdb.com/api.php?amount=10",
		    dataType : 'json',
		    error : function() {

		        alert("Error Occured");
		    },
		    success : function(data) {
		        var receivedData = [];
		        $.each(data.jsonArray, function(index) {
		            $.each(data.jsonArray[index], function(key, value) {
		                var point = [];

		                    point.push(key);
		                    point.push(value);
		                    receivedData.push(point);
		                }); 
		        });

		    }
		});
});

//handles the click event, sends the query
function getSuccessOutput() {
    $.ajax({
        url:'https://opentdb.com/api.php?amount=10',
        complete: function (response) {
            $('#output').html(response.responseText);
        },
        error: function () {
            $('#output').html('Bummer: there was an error!');
        },
    });
    return false;
}
// handles the click event, sends the query
function getFailOutput() {
    $.ajax({
        url:'myAjax.php',
        success: function (response) {
            console.log(data, response);
            $('#output').html(response);
        },
        error: function () {
            $('#output').html('Bummer: there was an error!');
        },
    });
    return false;
}


//handles the click event, sends the query
$(document).ready(function() {
    $.ajax({
        url:'https://opentdb.com/api.php?amount=10',
        complete: function (response) {
            $('#output').html(response.responseText);
        },
        error: function () {
            $('#output').html('Bummer: there was an error!');
        },
    });
    return false;
});
