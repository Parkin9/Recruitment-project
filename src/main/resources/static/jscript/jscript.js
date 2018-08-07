document.addEventListener("DOMContentLoaded", function() {

    $('#submitButton').click(function(e) {

        e.preventDefault();
        var selectedValue = $('#columnName').val();

        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/app/home',
            data: {"columnName": selectedValue},
            dataType: 'json',
            success: function (recordsList) {

                // console.log(recordsList);

                var rawDuplicatesList = recordsList[0];
                var rawSinglesList = recordsList[1];

                var readyDuplicates = '';
                var readySingles = '';

                // console.log(rawDuplicatesList);
                // console.log(rawSinglesList);

                for(var i = 0; i < rawDuplicatesList.length; i++) {

                    readyDuplicates += '<tr><td>' + rawDuplicatesList[i].id + '</td>' +
                                            '<td>' + rawDuplicatesList[i].valueColumn1 + '</td>' +
                                            '<td>' + rawDuplicatesList[i].valueColumn2 + '</td>' +
                                            '<td>' + rawDuplicatesList[i].valueColumn3 + '</td>' +
                                            '<td>' + rawDuplicatesList[i].valueColumn4 + '</td>' + '</td></tr>';
                }

                for(var i = 0; i < rawSinglesList.length; i++) {

                    readySingles += '<tr><td>' + rawSinglesList[i].id + '</td>' +
                                            '<td>' + rawSinglesList[i].valueColumn1 + '</td>' +
                                            '<td>' + rawSinglesList[i].valueColumn2 + '</td>' +
                                            '<td>' + rawSinglesList[i].valueColumn3 + '</td>' +
                                            '<td>' + rawSinglesList[i].valueColumn4 + '</td>' + '</td></tr>';
                }

                $('#displayResult1').html(readyDuplicates);
                $('#displayResult2').html(readySingles);
                $('td').css("border", "2px solid black").css("padding", "5px");
            }
        });
    });
});