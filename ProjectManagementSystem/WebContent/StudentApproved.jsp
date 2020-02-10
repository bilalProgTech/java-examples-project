<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ErrorPage.html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <title>IT Project</title>
    <link rel="icon" href="dbit.png" type="image/png">
	<link rel="stylesheet" href="tableOfProject.css">
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
			<li id="m01"><a href="Loginn.html">Login (for Faculty)</a>
			</li>
		</ul>
		<br>
	</header>
	<%@ page import="java.sql.*,code.DBConnect" %>
	<%
		Connection con = DBConnect.initializeDatabase();
		PreparedStatement st = null;
		ResultSet rs = null;
	%>
	<div class="block">
		<center>
			<h1>List of Projects</h1>
			<table>
				<tr>
					<th>Faculty/Student</th>
					<th>Group ID</th>
					<th>Leader</th>
					<th>Title</th>
					<th>Project Guide</th>
					<th>Approval Date</th>
					<th>Print</th>
				</tr>
				<%
					st = con.prepareStatement
						("select R.G_ID,S.Name,P.Project_Title,P.Project_Guide,R.dateA from "
							+DBConnect.dbReservationOfProject+" R, "
							+DBConnect.dbStudentInfo+" S, "
							+DBConnect.dbFacultyProject+" P where R.G_ID = S.G_ID && P.P_ID = R.P_ID group by(S.G_ID)");
					rs = st.executeQuery();
					while(rs.next())
					{
				%>
				<tr>
					<td>Faculty</td>
					<td><%= rs.getString(1) %></td>
					<td><%= rs.getString(2) %></td>
					<td><%= rs.getString(3) %></td>
					<td><%= rs.getString(4) %></td>
					<td><%= rs.getString(5) %></td>
					<td>
						<a href="C:/Users/rizwan/Documents/<%= rs.getString(1) %>.doc">Click,</a>	
					</td>
				</tr>
				<% } %>
				<%
					st = con.prepareStatement
						("select R.G_ID,S.Name,P.Project_Title,P.Faculty,R.dateA from "
							+DBConnect.dbReservationOfProject+" R, "
							+DBConnect.dbStudentInfo+" S, "
							+DBConnect.dbStudentProject+" P where R.G_ID = S.G_ID && P.P_ID = R.P_ID group by(S.G_ID)");
					rs = st.executeQuery();
					while(rs.next())
					{
				%>
				<tr>
					<td>Student</td>
					<td><%= rs.getString(1) %></td>
					<td><%= rs.getString(2) %></td>
					<td><%= rs.getString(3) %></td>
					<td><%= rs.getString(4) %></td>
					<td><%= rs.getString(5) %></td>
					<td>
						<a href="C:/Users/rizwan/Documents/<%= rs.getString(1) %>.doc">Click,</a>	
					</td>
				</tr>
				<% } %>
			</table>
		</center>
	</div>
	<footer>
		<p align="right"> Developed by Bilal Hungund. All Right Reserved.</p>
	</footer>
</body>

</html>