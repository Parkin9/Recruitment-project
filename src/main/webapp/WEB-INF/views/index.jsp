<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Recruitment Project</title>
    <link rel="stylesheet" type="text/css" href='<c:url value="/css/style.css"/>' >
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src='<c:url value="/jscript/jscript.js"/>' type="text/javascript"></script>
</head>
<body>
    <div id="container">
        <div id="selectionForm">
            <form method="post">
                <label>Wybierz kolumnę:
                    <select id="columnName">
                        <option value="kolumna1">Kolumna 1.</option>
                        <option value="kolumna2">Kolumna 2.</option>
                        <option value="kolumna3">Kolumna 3.</option>
                        <option value="kolumna4">Kolumna 4.</option>
                    </select>
                </label><br/>
                <button id="submitButton">Wyślij</button>
            </form>
        </div>
        <div>
            <table id="displayResult1"></table>
            <hr/>
            <table id="displayResult2"></table>
        </div>
    </div>
</body>
</html>
