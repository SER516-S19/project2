//var buttonList=document.querySelectorAll(".drum ");
//can be used

function execAjax(quiz_id,enrolled_id){
	var selectedAnswersList = [];
	var checkBoxes=document.getElementsByName("myAnswer");
	for(var i=0;i<checkBoxes.length;i++){
		if(checkBoxes[i].checked){
			selectedAnswersList.push(checkBoxes[i].value-'0');
		}
	}
	   /*alert(JSON.stringify({
	    	"quiz_id":quiz_id,
	    	"enrolled_id":enrolled_id,
	    	"choices":selectedAnswersList
	    	}));*/

	var saveData =$.ajax({
    url: 'submit',
    type: 'POST',
    
    contentType: 'application/json',
    data: JSON.stringify({
    	"quiz_id":quiz_id,
    	"enrolled_id":enrolled_id,
    	"choices":selectedAnswersList
    	}),
    	   success: function(result) {
    		   var successUrl = "resultpage.jsp"; // might be a good idea to return this URL in the successful AJAX call
    		    window.location.href = successUrl;
    		    },
error: function(err) {
    alert("Something went wrong");
  }
});
}
