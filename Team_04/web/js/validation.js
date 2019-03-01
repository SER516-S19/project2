$("input[value='Add']").prop('disabled', true);
$("input[value='Save']").prop('disabled', true);
$('.error').hide();

$(".formtext").on('keyup blur', function (e) {
    var input = $(this);
    var message = $(this).val();
    if (message) {
        input.removeClass("invalid").addClass("valid");
        allHaveClass();
    }
    else {
        input.removeClass("valid").addClass("invalid");
        $("input[value='Add']").prop('disabled', true);
        $(".error").show();
    }

});

$("input[name='score']").on('keyup blur', function (e) {
    var input = $(this);
    var score = $(this).val();
    if (score && !isNaN(score)) { input.removeClass("invalid").addClass("valid"); allHaveClass(); }
    else {
        input.removeClass("valid").addClass("invalid");
        $("input[value='Add']").prop('disabled', true);
        $(".error").show();
    }

});

function allHaveClass(add) {
    
    var allHaveClass = $('input.valid').length == 6;
    if (allHaveClass) {
        console.log('if');
        $("input[value='Add']").prop('disabled', false);
        $("input[value='Save']").prop('disabled', false);
        $('.error').hide();

    }
    else{	
        console.log('else');
        $("input[value='Add']").prop('disabled', true);
        $("input[value='Save']").prop('disabled', true);
        
    }
    
    if(typeof add !== "undefined") { $("input[value='Save']").prop('disabled', false);}
}

