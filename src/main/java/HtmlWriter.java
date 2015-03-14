/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cole
 */
public class HtmlWriter {
    public String writeNav(String profilePic)
    {
        
        return "<nav class='navbar navbar-inverse navbar-static-top'>\n" +
"	<div class='container-fluid'>\n" +
"		<!-- Brand and toggle get grouped for better mobile display -->\n" +
"		<div class='navbar-header'>\n" +
"			<button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#bs-example-navbar-collapse-1'>\n" +
"				<span class='sr-only'>Toggle navigation</span>\n" +
"				<span class='icon-bar'></span>\n" +
"				<span class='icon-bar'></span>\n" +
"				<span class='icon-bar'></span>\n" +
"			</button>\n" +
"			<a class='navbar-brand brand-logo'><img class='img-rounded' src='STtitle.svg'></a>\n" +
"		</div>\n" +
"\n" +
"		<!-- Collect the nav links, forms, and other content for toggling -->\n" +
"		<div class='collapse navbar-collapse' id='bs-example-navbar-collapse-1'>\n" +
"			<ul class='nav navbar-nav'>\n" +
"						<li><a href='/'>Home <span class='sr-only'>(current)</span></a></li>\n" +
"			</ul>\n" +
"			<ul class='nav navbar-nav navbar-right'>\n" +
"\n" +
"			<li><a href='#'>Log in</a></li>\n" +
"			<li><a class='navbar-brand brand-logo'><img class='img-rounded profile' src='" + profilePic + "'></a></li>\n" +
"		</ul>\n" +
"		</div>\n" +
"		\n" +
"	</div>\n" +
"</nav>";
    }
}
