<%-- 
    Document   : mainMenu
    Created on : Mar 12, 2015, 4:34:12 PM
    Author     : cordondavies
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scriptures Trivia</title>
        <link rel="icon" type="image/png" href="ScripturesTriviaLogo.png">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-static-top">
		<div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      	<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
		      	</button>
		      	<a class="navbar-brand brand-logo"><img class="img-rounded" src="STtitle.svg"></a>
		    </div>

		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      	<ul class="nav navbar-nav">
                            <li><a href="/">Home <span class="sr-only">(current)</span></a></li>
		    	</ul>
		    	<ul class="nav navbar-nav navbar-right">

		        <li><a href="#">Log in</a></li>
		        <li><a class="navbar-brand brand-logo"><img class="img-rounded profile" src="${pic}"></a></li>
	      	</ul>
		    </div>
		    
		</div>
	</nav>
        <div class="container">
            <h1>Welcome ${user}!</h1>
        </div>
        
    </body>
</html>
