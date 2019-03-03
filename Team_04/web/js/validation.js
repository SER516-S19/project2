$("input[value='Add']").prop('disabled', true);
$("input[value='Save']").prop('disabled', true);
$("input[value='Add']").addClass('btn-disabled');
$("input[value='Save']").addClass('btn-disabled');

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
    if(typeof add !== "undefined" && add){ $("input[value='Save']").prop('disabled', false);
    $("input[value='Save']").removeClass('btn-disabled');
    $("input[value='Add']").prop('disabled', true);
    $("input[value='Add']").addClass('btn-disabled');
}
    else{
    var allHaveClass = $('input.valid').length == 6;
    if (allHaveClass) {
        $("input[value='Add']").prop('disabled', false);
        $("input[value='Save']").prop('disabled', false);
        $("input[value='Add']").removeClass('btn-disabled');
        $("input[value='Save']").removeClass('btn-disabled');
        $('.error').hide();

    }
    else{	
        $("input[value='Add']").prop('disabled', true);
        $("input[value='Save']").prop('disabled', true);
        $("input[value='Add']").addClass('btn-disabled');
        $("input[value='Save']").addClass('btn-disabled');
    }
    
    }
    
        }
