<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ErrorPage.html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>IT Project</title>
    <link rel="icon" href="dbit.png" type="image/png">
	<link rel="stylesheet" href="tableOfProject.css">
	<link rel="stylesheet" href="headerProject.css">
    <style>
    p
    {
    	font-family: Times New Roman;
    	font-size: 20;
    }
    .block
	{
		border-radius: 5px;
		background-color: #f2f2f2;
		padding: 20px;
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
	<%@ page import="java.sql.*,code.DBConnect" %>
  	<%
		Connection con = DBConnect.initializeDatabase();
		PreparedStatement st = con.prepareStatement("select * from "+DBConnect.dbFacultyProject);
		ResultSet rs = st.executeQuery();
		while(rs.next())
		{
  	%>
		<div class="block">
		
		<table>
			<tr>
				<th>ID</th>
				<td><p name="id"><%= rs.getInt(1) %></p></td>
			</tr>
			<tr>
    			<th>Project Title</th>
    			<td><p><%= rs.getString(2) %></p></td>
    		</tr>	
    		<tr>
    			<th>Project Abstract</th>
    			<td><p><%= rs.getString(3) %></p></td>
    		</tr>
    		<tr>
    			<th>References</th>
    			<td><p><%= rs.getString(4) %></p></td>
    		</tr>
		</table>
		<form action="./SessioningData?id=<%= rs.getInt(1)%>" method="post">
			<button class="buttonT" type="submit">Reserve This</button>
		</form>
		</div>
		<br>
	<% } %>
	<footer>
		<p align="right"> Developed by Bilal Hungund. All Right Reserved.</p>
	</footer>
</body>
</html>