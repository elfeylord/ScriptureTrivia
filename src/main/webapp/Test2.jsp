<%-- 
    Document   : Test2
    Created on : Mar 9, 2015, 1:30:23 PM
    Author     : Cole
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:forEach items="${profiles}" var="post">
     
            <p>${post}</p>
   
          
        </c:forEach>
    </body>
</html>
