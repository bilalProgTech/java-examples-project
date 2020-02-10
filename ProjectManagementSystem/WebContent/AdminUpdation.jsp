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
	<link rel="stylesheet" href="tableOfProject.css">
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
	<%@ page import="java.sql.*,code.DBConnect" %>
	<div class="division">
		<h1><center>Delete Projects</center></h1>
		<table>
		<%
			Connection con = DBConnect.initializeDatabase();
			PreparedStatement st = con.prepareStatement("select p_id,project_title from "+DBConnect.dbStudentProject);
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
		%>
			<tr>
				<td><p><%= rs.getString(2) %></p></td>
				<td>
					<form action="./DeleteProject?id=<%= rs.getString(1) %>" method="post">
						<button type="submit">Delete</button>
					</form>
				</td>
			</tr>
		<%
			}
		%>
		</table>
	</div>
	<footer>
		<p align="right"> Developed by Bilal Hungund. All Right Reserved.</p>
	</footer>
</body>
</html>