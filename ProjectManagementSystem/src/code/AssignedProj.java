package code;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AssignedProj")
public class AssignedProj extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		try 
		{
			Connection con = DBConnect.initializeDatabase();
			PreparedStatement st = con.prepareStatement("update addprojectbystudent set Faculty='"+
					request.getParameter("ProjGuide")+"' where Project_Title='"+request.getParameter("tile")+"'");
			st.executeUpdate();
			st = con.prepareStatement("update reservation set approve='No', dateA='-' where p_id="
					+ "	(select p_id from addprojectbystudent where project_title='"
					+request.getParameter("tile")+"')");
			st.executeUpdate();
			st.close();
			con.close();
			response.sendRedirect("AssigningProject.jsp");
		} 
		catch (Exception e) 
		{
			response.sendRedirect("ErrorPage.html");
		}
	}
}
