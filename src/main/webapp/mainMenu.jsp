<%-- 
    Document   : mainMenu
    Created on : Mar 12, 2015, 4:34:12 PM
    Author     : cordondavies
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scriptures Trivia</title>
        <jsp:include page="directives/linkedFiles.jsp" /> 
    </head>
    <body>
        <jsp:include page="directives/header.jsp" /> 
        <div class="container img-rounded">
            <h1>Welcome ${username}!</h1>
            <div>
                <h2>Your friends that play</h2>
                <div class="list-group">
                <c:forEach items="${friends}" var="friend">
                    <a href="#" class="list-group-item" onclick="confirmStart('${friend.name}','${friend.id}')"> ${friend.name} <!--<img class="img-rounded" src="test"/>--></a>
                </c:forEach>
                </div>
            </div>
            <div>
                <h2>Your turn:</h2>
            </div>
            <div>
                <h2>Their turn:</h2>
            </div>
        </div>
            
        <jsp:include page="directives/Script.jsp" />
        <script src="js/prompt.js" type="text/javascript"></script>
        <script src="js/bootbox.min.js" type="text/javascript"></script>
    </body>
</html>
