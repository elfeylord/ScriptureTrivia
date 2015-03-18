<%-- 
    Document   : Game
    Created on : Mar 16, 2015, 10:52:30 AM
    Author     : Cole
--%>

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
        <div id="countdown" class="pull-right timer">15</div>
        
        <div class="container img-rounded">
            <h3 class="pull-right">${game.yourScore}</h3>
            <h1>Category: ${category}</h1>
            <h2>${question}</h2>
            <div class="list-group">
                <c:forEach items="${answerList}" var="answer" varStatus="loop">
                    <a id="ans${loop.index}" onclick="checkAnswer('${loop.index}')" href="#" class="list-group-item ans"> ${answer}</a>
                </c:forEach>
            </div>
        </div>
        <jsp:include page="directives/Script.jsp" />
        <script src="js/jquery.redirect.js"></script>
        <script src="js/game.js"></script>
    </body>
</html>
