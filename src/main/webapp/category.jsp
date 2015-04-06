<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="directives/linkedFiles.jsp" /> 
    </head>
    <body>
        <jsp:include page="directives/header.jsp" />
        <button style="z-index: 700;" class="btn btn-primary block-center" onclick="location.reload();">Fix Spinner</button>
        <div onclick="stop();" class="point">
            <div class="top-fade"></div>
            <div class="bottom-fade"></div>
            <img class="markers" src="images/marker.png">
            <div class="spinner"></div>
        </div>
        <jsp:include page="directives/Script.jsp" />
            <script src="js/jquery.redirect.js"></script>
            <script src="js/spinner.js"></script>
    </body>
</html>