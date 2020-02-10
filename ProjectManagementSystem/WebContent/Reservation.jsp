<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ErrorPage.html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>IT Project</title>
    <link rel="icon" href="dbit.png" type="image/png">
	<link rel="stylesheet" href="headerProject.css">
	<link rel="stylesheet" href="FormDesign.css">
    <style type="text/css">
    h1
	{
		color: black;
		font-family:Courier New;
		font-size: 100%
	}
	.pclass
	{
		color: black;
		font-family: Courier New;
		font-size: 80;
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
			<li id="m01"><a href="ListProjectStud.jsp">Back</a></li>
		</ul>
		<br>
	</header>
	<br>
	<%@ page import = "javax.servlet.*"%>
	<%@ page import="java.sql.*,code.DBConnect" %>
	<div class="division">
	<%
		HttpSession sessi = request.getSession(false);
		String n = sessi.getAttribute("id3").toString();
		int id = Integer.parseInt(n);
	%>
  	<%
		Connection con = DBConnect.initializeDatabase();
		PreparedStatement st = null;
		ResultSet rs = null;
		if(id >= 2017101)
		{
			st = con.prepareStatement("select Project_Title,Abstract from "
							+DBConnect.dbStudentProject+" where P_ID="+id+";");
			rs = st.executeQuery();
			while(rs.next())
			{
  	%>
				<h1>Project Title: </h1>
				<p class="pclass"><%= rs.getString(1) %></p>
				<h1>Project Abstract: </h1>
				<p class="pclass"><%= rs.getString(2) %></p>
	<% 
			} 
		}
		else
		{
			st = con.prepareStatement("select Project_Title,Abstract from "
							+DBConnect.dbFacultyProject+" where P_ID="+id+";");
			rs = st.executeQuery();
			while(rs.next())
			{
	%>
				<h1>Project Title: </h1>
				<p class="pclass"><%= rs.getString(1) %></p>
				<h1>Project Abstract: </h1>
				<p class="pclass"><%= rs.getString(2) %></p>
	<%
			}
		}
	%>
		<h1>Group Member Details: </h1>
		<form action="./StudentDetails" method="post">
			<table class="tableOfProject">
				<tr>
					<th>Student ID</th>
					<th>Student Name</th>
					<th>Email Address</th>
					<th>Contact</th>
				</tr>
				<tr>
					<td><input type="text" placeholder="Enter ID for 1" name="id1" required></td>
					<td><input type="text" placeholder="Enter Name for 1" name="name1" required></td>
					<td><input type="email" placeholder="Enter Email for 1" name="email1" required></td>
					<td>
						<input type="text" placeholder="Enter Contact for 1" name="no1" id="no1"  maxlength="10" onkeyup="validateNumber(this)" required>
					</td>
				</tr>
				<tr>
					<td><input type="text" placeholder="Enter ID for 2" name="id2" required></td>
					<td><input type="text" placeholder="Enter Name for 2" name="name2" required></td>
					<td><input type="email" placeholder="Enter Email for 2" name="email2" required></td>
					<td>
						<input type="text" placeholder="Enter Contact for 2" name="no2" id="no2"  maxlength="10" onkeyup="validateNumber(this)" required>
					</td>
				</tr>
				<tr>
					<td><input type="text" placeholder="Enter ID for 3" name="id3" required></td>
					<td><input type="text" placeholder="Enter Name for 3" name="name3" required></td>
					<td><input type="email" placeholder="Enter Email for 3" name="email3" required></td>
					<td>
						<input type="text" placeholder="Enter Contact for 3" name="no3" id="no3"  maxlength="10" onkeyup="validateNumber(this)" required>
					</td>
				</tr>
				<tr>
					<td><input type="text" placeholder="Enter ID for 4" name="id4" required></td>
					<td><input type="text" placeholder="Enter Name for 4" name="name4" required></td>
					<td><input type="email" placeholder="Enter Email for 4" name="email4" required></td>
					<td>
						<input type="text" placeholder="Enter Contact for 4" name="no4" id="no4"  maxlength="10" onkeyup="validateNumber(this)" required>
					</td>
				</tr>
			</table>
			<h1>Any Queries: </h1><input type="text" placeholder="(if any)" name="query">
			<input type="submit" value="Submit" onclick="validateStudent()"/>
			<p id="demo" style="font-size: 60%"></p>
		</form>
	</div>
	<script type="text/javascript">
		function validateNumber(elem)
		{
			var contact = document.getElementById(elem.id).value;
			if(contact.length == 10)
			{
				document.getElementById("demo").innerHTML = "Correct"
			}
			else
				document.getElementById("demo").innerHTML = "Not Correct yet"
		}
	</script>
	<footer>
		<p align="right"> Developed by Bilal Hungund. All Right Reserved.</p>
	</footer>
</body>
</html>