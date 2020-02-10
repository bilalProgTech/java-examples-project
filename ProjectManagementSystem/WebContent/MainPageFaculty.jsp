<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="LoginError.html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>IT Project</title>
    <link rel="icon" href="dbit.png" type="image/png">
	<link rel="stylesheet" href="headerProject.css">
	<link rel="stylesheet" href="FormDesign.css">
	<meta charset="UTF-8">
    <style>
	h1
	{
		color: black;
		font-family:Courier New;
		font-size: 130%
	}
	p
	{
		font-family: cursive;	
		font-style: oblique;
	}
	</style>
</head>
<body>
	<header>
        <a href="www.dbit.in"><img src="dbit.png" alt="HTML5 Icon" style="width:12%;"/></a>
		<img src="itstuff.PNG" align="right" style="width:25%"/>
		<a href="MainP.jsp"><img src="it.PNG" style="width:19%;"/></a>
		<img src="comp.png" align="right" style="width:10%"/>
		<ul id="m01">
			<li id="m01"><a href="MainPageFaculty.jsp">Add Project</a></li>
			<li id="m01"><a href="FacultyApproved.jsp">Approved Project</a></li>
			<li id="m01"><a href="ResetPwd.jsp">Reset Password</a></li>
			<li id="m01" name="uID"><a href="./LogoutSession">
				<%
					HttpSession sessi = request.getSession(false);
					String n = sessi.getAttribute("uname").toString();				
				%>
				Hii, 
				<%= n %></a>
			</li>
		</ul>
		<br>
	</header>
	<div class="division">
		<form action="./AddProjectDetail" method="post">
			<h1>Project Title: </h1>
			<input type="text" name="ProjectTitle" placeholder="Enter Project Title" required/>
			<h1>Project Abstract: </h1>
			<textarea required id="ta" name="message" rows="10" cols="97" placeholder="Project Abstract" maxlength="1455" onkeyup="textareaValidation()"></textarea>
			<p id="error">1455 letter is Remaining</p>
			<h1>References: </h1>
			<textarea rows="5" cols="97" name="reference" placeholder="Enter Reference(s)"></textarea>
			<input type="submit" value="Submit"/>
		</form>
	</div>
	<script type="text/javascript" src="textareaValidation.js">
	</script>
	<footer>
		<p align="right">Developed by Bilal Hungund</p>
	</footer>
</body>
</html>