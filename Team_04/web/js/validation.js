        $(document).ready(function () {
            $("input[type='submit']").prop('disabled', true);
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
                    $("input[type='submit']").prop('disabled', true);
                    $(".error").show();
                }

            });

            $("input[name='score']").on('keyup blur', function (e) {
                var input = $(this);
                var score = $(this).val();
                if (score && !isNaN(score)) { input.removeClass("invalid").addClass("valid"); allHaveClass(); }
                else {
                    input.removeClass("valid").addClass("invalid");
                    $("input[type='submit']").prop('disabled', true);
                    $(".error").show();
                }

            });

            function allHaveClass() {
                var allHaveClass = $('input.invalid').length == 0;
                if (allHaveClass) {
                    $("input[type='submit']").prop('disabled', false);
                    $('.error').hide();

                }
            }

        });
