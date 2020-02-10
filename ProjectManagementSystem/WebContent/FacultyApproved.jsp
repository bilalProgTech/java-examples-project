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
    <style type="text/css">
	.block
	{
		border-radius: 5px;
		background-color: #f2f2f2;
		padding: 20px;
	}
	h1
	{
		color: black;
		font-family:Courier New;
		font-size: 130%
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
	<div class="division" style="width: 550px">
	<h1 align="center">----Student Projects----</h1>
	</div><br>
	<div class="block">
		<table class="tableOfProject">
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Abstract</th>
				<th>Approval</th>
			</tr>
			<%
				String approve = "", gid = "";
			
				Connection con = DBConnect.initializeDatabase();	
				PreparedStatement st = null;
				ResultSet rs = null;
				
				st = con.prepareStatement
						("select A.P_ID,A.Project_Title,A.Abstract,R.G_ID,R.approve from "
							+DBConnect.dbStudentProject+" A, "
							+DBConnect.dbReservationOfProject+" R where A.P_ID = R.P_ID && faculty='"+n+"'");
				rs = st.executeQuery();
				while(rs.next())
				{
			%>
			<tr>
				<td><%= rs.getInt(1)%></td>
				<td><%= rs.getString(2) %></td>
				<td><%= rs.getString(3) %></td>
				<%
					gid = rs.getString(4);
					approve = rs.getString(5);
					if(approve.equals("No"))
					{
				%>
				<td>
					<center>
						<form action="StudInfoApproved.jsp" method="post">
							<input type="submit" name="gid" value=<%= gid %>>
						</form>
					</center>
				</td>
				<%
					}
					else
					{
				%>
				<td>
					<a href="'C:/Users/rizwan/Documents/'<%= gid %>'.doc'">
						<button title="Project is being Approved (Contact Coordinator)">
							Approved
						</button>
					</a>
				</td>
			<% 	
					} 
				}
			%>
			</tr>
		</table>
	</div>
	<br><div class="division">
	<h1 align="center">----Your Projects----</h1>
	</div><br>
	<div class="division">
		<table class="tableOfProject">
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Approval</th>
			</tr>
			<%
				st = con.prepareStatement
						("select A.P_ID,A.Project_Title,R.G_ID,R.approve from "
							+DBConnect.dbFacultyProject+" A, "
							+DBConnect.dbReservationOfProject+" R where A.P_ID = R.P_ID"
							+"&& A.project_guide='"+n+"'");
				rs = st.executeQuery();
				while(rs.next())
				{
			%>
			<tr>
				<td><%= rs.getInt(1)%></td>
				<td><%= rs.getString(2) %></td>
				<%
					gid = rs.getString(3);
					approve = rs.getString(4);
					if(approve.compareTo("No")==0)
					{
				%>
				<td>
					<center>
						<form action="StudInfoApproved.jsp" method="post">
							<input type="submit" name="gid" value=<%= gid %>>
						</form>
					</center>
				</td>
				<%
					}
					else if(approve.startsWith("Yes"))
					{
				%>
				<td>
					<a href="C:/Users/rizwan/Documents/<%= gid %>.doc">
						<button title="Project is being Approved (Contact Coordinator)">
						Approved
						</button>
					</a>
				</td>
			<% 	
					} 
				}
			%>
			</tr>
		</table>
	</div>
	<footer>
		<p align="right"> Developed by Bilal Hungund. All Right Reserved.</p>
	</footer>
</body>
</html>