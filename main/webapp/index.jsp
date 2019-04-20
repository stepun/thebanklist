<%--
  Created by IntelliJ IDEA.
  User: lexun
  Date: 19.04.2019
  Time: 12:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>

<%--@elvariable id="richestUser" type="String"--%>
<input id="textRichestUser" type="text" value="" disabled><input type="button" value="get" id="btnRichestUser"> Richest User <br>

<%--@elvariable id="allSumm" type="String"--%>
<input id="textAllSumm" type="text" value="" disabled><input type="button" value="get" id="btnAllSumm"> All accounts sum<br>
<br><a href="/">Go to main page</a>

<script>
    $(document).ready(function() {
        $( "#btnRichestUser" ).on( "click", function() {
            $.ajax({
                url: "/rest/getRichestUser",
                type: 'GET',
                success: function (response) {
                    if (response && response.status === 'success') {
                        if (typeof response.model !== 'undefined'
                            && typeof response.model.name !== 'undefined'
                            && typeof response.model.sureName !== 'undefined') {
                            $("#textRichestUser").val(response.model.name + ' ' + response.model.sureName);
                        }
                    } else if (response && response.status === 'fail') {
                        if (typeof response.message !== 'undefined') {
                            console.log(response.message);
                        }
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log(textStatus);
                },
                complete: function (jqXHR, textStatus) {
                    console.log(textStatus);
                }
            });
        });

        $( "#btnAllSumm" ).on( "click", function() {
            $.ajax({
                url: "/rest/getAccountSum",
                type: 'GET',
                success: function (response) {
                    if (response && response.status === 'success') {
                        if (typeof response.value !== 'undefined') {
                            $("#textAllSumm").val(response.value);
                        }
                    } else {

                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {

                },
                complete: function (jqXHR, textStatus) {

                }
            });
        });
    });
</script>
</body>
</html>
