        $(document).ready(function () {
            $("input[value='Add']").prop('disabled', true);
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

            function allHaveClass() {
                var allHaveClass = $('input.invalid').length == 0;
                if (allHaveClass) {
                    $("input[value='Add']").prop('disabled', false);
                    $('.error').hide();

                }
            }

        });
