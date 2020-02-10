<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="LoginError.html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>IT Project</title>
    <link rel="icon" href="dbit.png" type="image/png">
	<link rel="stylesheet" href="headerProject.css">
	<link rel="stylesheet" href="FormDesign.css">
    <style>
	h1
	{
		color: black;
		font-family:Courier New;
		font-size: 130%;
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
			<li id="m01"><a href="ADMINRegistration.jsp">Registration</a></li>
			<li id="m01"><a href="AssigningProject.jsp">Assigned Project</a></li>
			<li id="m01"><a href="AdminUpdation.jsp">Updation</a></li>
			<li id="m01"><a href="./LogoutSession">
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
		<form action="./FacultyRegister" method="post">
			<h1>Enter his/her Username: </h1>
			<input type="text" name="un" placeholder="Enter Username" id="unI"/>
			<h1>Enter his/her Password: </h1>
			<input type="password" name="pw" placeholder="Enter Password"/>
			<h1>Enter his/her Name: </h1>
			<input type="text" name="name" placeholder="Enter Name" id="name"/>
			<input type="submit" value="Register IT!!!"/>
		</form>
	</div>
	<footer>
		<p align="right"> Developed by Bilal Hungund. All Right Reserved.</p>
	</footer>
</body>
</html>