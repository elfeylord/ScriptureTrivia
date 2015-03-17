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
        
        <div class="container img-rounded">
            <h1>${question}</h1>
            <c:forEach items="${answerList}" var="answer">
                <div> ${answer}</div>
            </c:forEach>
        </div>
        <jsp:include page="directives/Script.jsp" />
    </body>
</html>
