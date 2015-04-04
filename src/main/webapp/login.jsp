<%-- 
    Document   : login
    Created on : Mar 16, 2015, 2:53:53 PM
    Author     : cordondavies
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scripture Trivia | Login</title>
        <jsp:include page="directives/linkedFiles.jsp" /> 
    </head>
    <body>
        <img class="main-logo" src="STtitle.svg">
        <div class="container img-rounded">
            <h1>Welcome to Scripture Trivia</h1>
            <h2><small>Compete against your friends to test your knowledge of the Scriptures in a competitive game.
                    Then share your victory with your friends on Facebook! To get started, simply sign in with your
                Facebook account by clicking the button below. Invite your friends to do the same and challenge them 
                to a game! Keep playing until you have scored enough points to win!</small></h2>
            <br>
            <a class="btn btn-facebook center-block" href ="FacebookLogin">Log in with your facebook account</a>
        </div>
    </body>
</html>
