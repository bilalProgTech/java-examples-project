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
	p
    {
    	font-family: Times New Roman;
    	font-size: 20;
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
		<table>
				<%
					Connection con = DBConnect.initializeDatabase();
					PreparedStatement st = con.prepareStatement
							("select project_title from "+DBConnect.dbStudentProject);
					ResultSet rs = st.executeQuery();
					int i = 0;
					while(rs.next())
					{
				%>
			<tr>
				<td id="Click<%= i %>T"><%= rs.getString(1) %></td>
				<td>
					<button onclick="clickTitle(this)" id="Click<%= i %>">
						Click Here
					</button>
				</td>
			</tr>
			<% 
					i = i + 1;
					} 
			%>
		</table>
	</div>
	<br>
	<div class="division" id="divi" style="display: none;">
		<form action="./AssignedProj" method="post">
			<input type="text" id="title" name="tile" readonly/>
			<%
				st = con.prepareStatement("select abstract from addprojectbystudent where project_title='"+request.getParameter("tile")+"'");
				rs = st.executeQuery();
				while(rs.next())
				{
			%>
			<p><b>Project Abstract:	</b><%= rs.getString(1) %></p>
			<%	} %>
			<select name="ProjGuide">
				<option>Mrs. Janhavi Bairerkar</option>
				<option>Mrs. Sushree Satapathy</option>
				<option>Mrs. Aruna Khubhalkar</option>
				<option>Mrs. Mahalaxmi</option>
				<option>Mrs. Vaishali</option>
				<option>Mr. Shiv Negi</option>
				<option>Mr. Nilesh Ghavathe</option>
				<option>Mr. Tayyab Ali Sayed</option>
				<option>Mr. Prasad</option>
				<option>Mr. Uday Nayak</option>
			</select>
			<input type="submit" value="Click"/>
		</form>
	</div>
	<script type="text/javascript">
	function clickTitle(elem)
	{
		var textID = document.getElementById(elem.id+"T").innerHTML;
		document.getElementById("divi").style.display = "block";
		document.getElementById("title").value = textID;
	}
	</script>
	<footer>
		<p align="right"> Developed by Bilal Hungund. All Right Reserved.</p>
	</footer>
</body>
</html>