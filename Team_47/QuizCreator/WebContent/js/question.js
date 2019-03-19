//var buttonList=document.querySelectorAll(".drum ");
//can be used

function execAjaxOnBegin(quiz_id,enrolled_id){
	
	var endDate = new Date();
	var date_format_str = endDate.getFullYear().toString()+"-"+((endDate.getMonth()+1).toString().length==2?(endDate.getMonth()+1).toString():"0"+(endDate.getMonth()+1).toString())+"-"+(endDate.getDate().toString().length==2?endDate.getDate().toString():"0"+endDate.getDate().toString())+" "+(endDate.getHours().toString().length==2?endDate.getHours().toString():"0"+endDate.getHours().toString())+":"+(endDate.getMinutes().toString().length==2?endDate.getMinutes().toString():"0"+endDate.getMinutes().toString())+":"+(endDate.getSeconds().toString().length==2?endDate.getSeconds().toString():"0"+endDate.getSeconds().toString());
	var saveData =$.ajax({
    url: 'submit',
    type: 'POST',
    
    contentType: 'application/json',
    data: JSON.stringify({
    	"quiz_id":quiz_id,
    	"enrolled_id":enrolled_id,
    	"initial" : true,
    	"choices":[],
    	"start_time": date_format_str
    	}),
    	   success: function(result) {
    		   var successUrl = "questions.jsp"; // might be a good idea to return this URL in the successful AJAX call
    		    window.location.href = successUrl;
    		    },
error: function(err) {
    alert("Something went wrong");
  }
});
}

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
	var endDate = new Date();
	var date_format_str = endDate.getFullYear().toString()+"-"+((endDate.getMonth()+1).toString().length==2?(endDate.getMonth()+1).toString():"0"+(endDate.getMonth()+1).toString())+"-"+(endDate.getDate().toString().length==2?endDate.getDate().toString():"0"+endDate.getDate().toString())+" "+(endDate.getHours().toString().length==2?endDate.getHours().toString():"0"+endDate.getHours().toString())+":"+(endDate.getMinutes().toString().length==2?endDate.getMinutes().toString():"0"+endDate.getMinutes().toString())+":"+(endDate.getSeconds().toString().length==2?endDate.getSeconds().toString():"0"+endDate.getSeconds().toString());
	var saveData =$.ajax({
    url: 'submit',
    type: 'POST',
    
    contentType: 'application/json',
    data: JSON.stringify({
    	"quiz_id":quiz_id,
    	"enrolled_id":enrolled_id,
    	"choices":selectedAnswersList,
    	"initial" : false,
    	"start_time": date_format_str,
    	"end_time" : date_format_str
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
