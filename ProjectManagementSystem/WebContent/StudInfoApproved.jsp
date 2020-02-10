<%@page import="java.sql.*,code.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="LoginError.html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>IT Project</title>
    <link rel="icon" href="dbit.png" type="image/png">
	<link rel="stylesheet" href="tableOfProject.css">
	<link rel="stylesheet" href="headerProject.css">
	<link rel="stylesheet" href="FormDesign.css">
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
	<center>
		<div class="division">
			<h1>Group Member Information</h1>
			<table>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Contact</th>
				</tr>
					<%
						Connection con = DBConnect.initializeDatabase();
						String gid = request.getParameter("gid");
						PreparedStatement st = con.prepareStatement
							("select S_ID,name,email,contact,g_id from "+DBConnect.dbStudentInfo+" where G_ID='"+gid+"'");
						ResultSet rs = st.executeQuery();
								
						while(rs.next())
						{
					%>
						<tr>
							<td><%= rs.getInt(1) %></td>
							<td><%= rs.getString(2) %></td>
							<td><%= rs.getString(3) %></td>
							<td><%= rs.getString(4) %></td>
						</tr>
					<%
								gid = rs.getString(5);
						}
						st = con.prepareStatement("select query from "+DBConnect.dbQuery+" where G_ID='"+gid+"'");
						rs = st.executeQuery();
						while(rs.next())
						{
					%>
			</table>
			<p><b>Query: </b><%= rs.getString(1) %></p>
					<%
						}
						st.close();
						con.close();
					%>
			<form action="./ForApproveProject?gid=<%= gid %>" method="post">
				<button onclick="confirm('Do you want to continue?')"><img src="approved.png" style="width: 15%"/></button>
			</form>
		</div>
	</center>
	<footer>
		<p align="right"> Developed by Bilal Hungund. All Right Reserved.</p>
	</footer>
</body>
</html>