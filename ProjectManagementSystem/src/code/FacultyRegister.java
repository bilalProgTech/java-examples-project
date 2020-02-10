package code;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FacultyRegister")
public class FacultyRegister extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		try
		{
			String password = request.getParameter("pw");
			Cryption c = new Cryption();
			password = c.encryptText(password);
			Connection con = DBConnect.initializeDatabase();
			PreparedStatement st = con.prepareStatement("insert into faculty values(?,?,?)");
			st.setString(1, request.getParameter("un"));
			st.setString(2, password);
			st.setString(3, request.getParameter("name"));
			st.executeUpdate();
			con.close();
			st.close();
			response.sendRedirect("ADMINRegistration.jsp");
		}
		catch(Exception e) 
		{
			response.sendRedirect("ErrorPage.html");
			e.printStackTrace();
		}
	}
}
