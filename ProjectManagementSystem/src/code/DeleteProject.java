package code;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteProject")
public class DeleteProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		int n = Integer.parseInt(request.getParameter("id"));
		try 
		{
			Connection con = DBConnect.initializeDatabase();
			PreparedStatement st = con.prepareStatement("delete from addprojectbystudent where p_id="+n);
			st.executeUpdate();
			con.close();
			st.close();
			response.sendRedirect("AdminUpdation.jsp");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			response.sendRedirect("ErrorPage.html");
		}
	}
}
