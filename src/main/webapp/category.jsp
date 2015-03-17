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
        <jsp:include page="directives/header.jsp" /><div class="top-fade"></div>
        <div class="bottom-fade"></div>
        <div onclick="stop();" class="spinner">
        </div>
            <script src="js/spinner.js"></script>
        <jsp:include page="directives/Script.jsp" />
    </body>
</html>