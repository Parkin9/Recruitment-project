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

                //console.log(recordsList);

                var duplicatesList = recordsList[0];
                var singlesList = recordsList[1];

                var readyToDisplayDuplicates = '<tr><th class="valueTable">ID:</th>' +
                                                '<th class="valueTable">Kolumna 1.</th>' +
                                                '<th class="valueTable">Kolumna 2.</th>' +
                                                '<th class="valueTable">Kolumna 3.</th>' +
                                                '<th class="valueTable">Kolumna 4.</th></tr>';

                var readyToDisplaySingles = '<tr><th class="valueTable">ID:</th>' +
                                            '<th class="valueTable">Kolumna 1.</th>' +
                                            '<th class="valueTable">Kolumna 2.</th>' +
                                            '<th class="valueTable">Kolumna 3.</th>' +
                                            '<th class="valueTable">Kolumna 4.</th></tr>';

                // console.log(duplicatesList);
                // console.log(singlesList);

                for(var i = 0; i < duplicatesList.length; i++) {

                    readyToDisplayDuplicates += '<tr><td class="valueTable">' + duplicatesList[i].id + '</td>' +
                                                '<td class="valueTable">' + duplicatesList[i].valueColumn1 + '</td>' +
                                                '<td class="valueTable">' + duplicatesList[i].valueColumn2 + '</td>' +
                                                '<td class="valueTable">' + duplicatesList[i].valueColumn3 + '</td>' +
                                                '<td class="valueTable">' + duplicatesList[i].valueColumn4 + '</td></tr>';
                }

                for(var i = 0; i < singlesList.length; i++) {

                    readyToDisplaySingles += '<tr><td class="valueTable">' + singlesList[i].id + '</td>' +
                                                '<td class="valueTable">' + singlesList[i].valueColumn1 + '</td>' +
                                                '<td class="valueTable">' + singlesList[i].valueColumn2 + '</td>' +
                                                '<td class="valueTable">' + singlesList[i].valueColumn3 + '</td>' +
                                                '<td class="valueTable">' + singlesList[i].valueColumn4 + '</td></tr>';
                }

                $('#tableHeader1').html('<b>WARTOŚCI ZDUPLIKOWANE</b>');
                $('#tableHeader2').html('<b>WARTOŚCI UNIKATOWE</b>');

                $('#displayResult1').html(readyToDisplayDuplicates);
                $('#displayResult2').html(readyToDisplaySingles);
                $('.valueTable').css("border", "1px solid black").css("padding", "5px");
            }
        });
    });
});