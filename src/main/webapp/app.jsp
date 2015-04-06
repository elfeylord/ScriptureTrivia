<%-- 
    Document   : app
    Created on : Apr 6, 2015, 7:13:01 AM
    Author     : Cole
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scripture Trivia | Winner</title>
        <jsp:include page="directives/linkedFiles.jsp" /> 
        <style type="text/css">
            div{color:#fff}
            a{color:#fff; font-size: 30px}
        </style>
    </head>
    <body> 
        
        <jsp:include page="directives/header.jsp" /> 
        <a href ="http://scripturetrivia-scripturetrivia.rhcloud.com"> Click here to Play The Game</a>
        <div>
            Sign in with your facebook account and play with your friends that play Scripture Trivia as well!
            <img src="images/Login.JPG" alt="Scripture Trivia" height="500" width="800">
        </div>
        <div>
            Choose to start a new game with you friends, or continue to play a game that’s your turn.
            <img src="images/Home.JPG" alt="Scripture Trivia" height="500" width="800">
        </div>
        <div>
            Once you have selected a game, spin the category wheel to get a category of scripture trivia questions to answer!
            <img src="images/Category.JPG" alt="Scripture Trivia" height="500" width="800">
        </div>
        <div>
            Answer the question! But be quick, you only have 15 seconds!             Get it correct and keep playing.
            <img src="images/Answer.JPG" alt="Scripture Trivia" height="500" width="800">
        </div>
        <div>
            Get it wrong, or let the time run out and it will be your friend’s turn to play...
            <img src="images/Answer2.JPG" alt="Scripture Trivia" height="500" width="800">
        </div>
        <div>
            Once you win, tell all your friends on facebook so they too can know that you're the best!                    
            <img src="images/Win.JPG" alt="Scripture Trivia" height="200" width="800">
        </div>
        <div>
            <img src="images/Facebook.JPG" alt="Scripture Trivia" height="250" width="400">
        </div>
        
        
        <jsp:include page="directives/Script.jsp" />
        <script src="js/jquery.redirect.js"></script>
        
    </body>
</html>