<%-- 
    Document   : win
    Created on : Mar 19, 2015, 10:57:41 AM
    Author     : cordondavies
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scripture Trivia | Winner</title>
        <jsp:include page="directives/linkedFiles.jsp" /> 
    </head>
    <body>
        <jsp:include page="directives/header.jsp" /> 
        <div class="container img-rounded">
            <h1>You Lost!</h1>
            <h2>Better luck next time!</h2>
            
            <a class="btn btn-success" href="#" onclick="$.redirect('/ScriptureTrivia/CreateGame', {'id': '${myGame.id}', 'name': ${myGame.friend.name}});">Start a new game with ${myGame.friend.name}</a>
        </div>
        <jsp:include page="directives/Script.jsp" />
        <script src="js/jquery.redirect.js"></script>
        <script type="text/javascript">
            var youlose = new Audio("sounds/waaah.wav");
            youlose.play();
        </script>
    </body>
</html>