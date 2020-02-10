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
	p
	{
		font-style: italic;
		font-size: 10;
		font-family: cursive;
	}
	</style>
</head>
<body>
	<header>
        <a href="www.dbit.in"><img src="dbit.png" alt="HTML5 Icon" style="width:12%;"/></a>
		<img src="itstuff.PNG" align="right" style="width:25%"/>
		<a href="MainP.jsp"><img src="it.PNG" style="width:19%;"/></a>
		<img src="comp.png" align="right" style="width:10%"/>
		<ul id="m01"><li id="m01"><a href="MainPageFaculty.jsp">Add Project</a></li>
			<li id="m01"><a href="FacultyApproved.jsp">Approved Project</a></li>
			<li id="m01"><a href="ResetPwd.jsp">Reset Password</a></li>
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
		<form action="./ResetPW?name=<%= n %>" method="post">
			<h1>Enter Password: </h1>
			<input type="password" name="pw" id="pw" placeholder="Enter Password"/>
			<h1>Confirm Password ??: </h1>
			<input type="password" placeholder="Confirm Password?" name="rpw" id="rpw" onkeyup="pwCheck()" />
			<p id="wrong"></p>
			<input type="submit" value="Register IT!!!" id="btn"/>
		</form>
	</div>
	<script type="text/javascript">
		function pwCheck()
		{
			var ch1 = document.getElementById("rpw").value;
			var ch2 = document.getElementById("pw").value;
			
			if(ch1 == ch2)
			{
				document.getElementById("wrong").innerHTML = "Correct"
			}
			else
			{
				document.getElementById("wrong").innerHTML = "Not Correct yet!"
			}
		}
	</script>
	<footer>
		<p align="right"> Developed by Bilal Hungund. All Right Reserved.</p>
	</footer>
</body>
</html>