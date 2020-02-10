<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ErrorPage.html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>IT Project</title>
    <link rel="icon" href="dbit.png" type="image/png">
	<link rel="stylesheet" href="headerProject.css">
	<link rel="stylesheet" href="FormDesign.css">
	<link rel="stylesheet" href="modalCSS.css">
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
			<li id="m01"><a href="AddProjectStud.html">Add Project</a></li>
			<li id="m01"><a href="ListProjectStud.jsp">List Project</a></li>
			<li id="m01"><a href="StudentApproved.jsp">Your Project</a></li>
			<li id="m01"><a href="Loginn.html">Login (for faculty)</a>
			</li>
		</ul>
		<br>
	</header>
	<div class="division" style="width:690px;">
		<marquee>
		<center><img src="iticon.png" style="width:650px"></center>
		<br>
		<center><img src="linux.png" style="width:20%"/></center>
		</marquee>
	</div>
	<br>
	<div class="division" style="width:690px;">
		<center>
		<a href="AddProjectStud.html">
			<img title="Add Project" src="students.png" style="width:20%;"/>
		</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="ListProjectStud.jsp" style="text-align: right;">
			<img title="List Project" src="list.png" style="width:20%;"/>
		</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="StudentApproved.jsp" style="text-align: right;">
			<img title="Show Project" src="approval.png" style="width:20%;"/>
		</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<img title="Professor Login" src="teacher.png" style="width:20%;" onclick="modalOpener()"/>
		
		</center>
	</div>
	<br>
	<div class="division" style="width: 690px;">
		<br>
		<img title="Google It!!!!" src="google1.png" style="width: 20%;"/>
		<form action="./GoogleRedirct">
			<input type="text" name="search" placeholder="Google It!!!">
			<input type="submit" value="Google">
		</form>
	</div>
	<footer>
		<p align="right"> Developed by Bilal Hungund. All Right Reserved.</p>
	</footer>
	<div id="mainModal" class="mainModal">
		<div class="content">
    		<div class="header">
    			<span class="close">&times;</span>
    			<h2>Login</h2>
  			</div><br>
  			<center>
  				<img title="Professor Login" src="teacher.png" style="width:20%;"/>
  			</center>
    		<form action="./LoginFS?unI=" method="post">
				<h1>Enter Username: </h1>
				<input type="text" name="un" placeholder="Enter Username" id="unI"/>
				<h1>Enter Password: </h1>
				<input type="password" name="pw" placeholder="Enter Password"/>
				<input type="submit" value="Fire Query!!"/>
			</form>
  		</div>
	</div>
	<script type="text/javascript">
		function modalOpener()
		{
			var span = document.getElementsByClassName("close")[0];
			var modal = document.getElementById('mainModal');
			document.getElementById('mainModal').style.display='block';
			span.onclick = function() 
			{
			    modal.style.display = "none";
			}
			window.onclick = function(event) 
			{
			    if (event.target == modal) 
			    {
			        modal.style.display = "none";
			    }
			}
		}
	</script>
</body>
</html>