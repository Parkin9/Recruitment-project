document.addEventListener("DOMContentLoaded", function() {

    $('#submitButton').click(function(e) {

        e.preventDefault();
        var selectedValue = $('#columnNumber').val();

        // Testing function
        // console.log(columnNumber);

        $.post(

            'http://localhost:8080/app/home',
            {
                columnNumber: selectedValue
            }
        );
    });
});