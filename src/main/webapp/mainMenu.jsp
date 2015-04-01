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
            <h1>Welcome, ${username}!</h1>
            <div>
                <h2>Your friends that play</h2>
                <div class="list-group">
                <c:forEach items="${friends}" var="friend">
                    <a href="#" class="list-group-item" onclick="confirmStart('${friend.name}','${friend.id}')"><img class="img-rounded profile" src="https://graph.facebook.com/${friend.id}/picture"/> ${friend.name} </a>
                </c:forEach>
                </div>
            </div>
            <div>
                <h2>Your turn:</h2>
                <c:forEach items="${yourGames}" var="yourGame">
                    <a href="#" onclick="confirmCont('${yourGame.friend.name}','${yourGame.gameId}', '${yourGame.friend.facebookId}')" class="list-group-item"><img class="img-rounded profile" src="https://graph.facebook.com/${yourGame.friend.facebookId}/picture"/> ${yourGame.friend.name}<span class="pull-right">${yourGame.user.score}-${yourGame.friend.score}</span></a>
                </c:forEach>
            </div>
            <div>
                <h2>Their turn:</h2>
                <c:forEach items="${theirGames}" var="theirGame">
                    <a class="list-group-item disabled"><img class="img-rounded profile" src="https://graph.facebook.com/${theirGame.friend.facebookId}/picture"/> ${theirGame.friend.name}<span class="pull-right">${theirGame.user.score}-${theirGame.friend.score}</span></a>
                </c:forEach>
            </div>
        </div>
            
        <jsp:include page="directives/Script.jsp" />
        <script src="js/prompt.js" type="text/javascript"></script>
        <script src="js/bootbox.min.js" type="text/javascript"></script>
            <script src="js/jquery.redirect.js"></script>
    </body>
</html>
