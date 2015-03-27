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
        <div onclick="stop();" class="point">
            <div class="top-fade"></div>
            <div class="bottom-fade"></div>
            <img class="marker-left" src="images/markerleft.svg">
            <img class="marker-right" src="images/markerright.svg">
            <div class="spinner"></div>
        </div>
        <jsp:include page="directives/Script.jsp" />
            <script src="js/jquery.redirect.js"></script>
            <script src="js/spinner.js"></script>
    </body>
</html>