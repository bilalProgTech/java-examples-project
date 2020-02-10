package code;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResetPW")
public class ResetPW extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		PreparedStatement st = null;
		String n = request.getParameter("name");
		String password = request.getParameter("rpw");
		Cryption c = new Cryption();
		password = c.encryptText(password);
		try 
		{
			Connection con = DBConnect.initializeDatabase();
			if(request.getParameter("pw").equals(request.getParameter("rpw")))
			{
				st = con.prepareStatement("update faculty set pw='"+password
					+"' where name='"+n+"'");
				st.executeUpdate();
				response.sendRedirect("ResetPwd.jsp");
			}
			else
			{
				response.sendRedirect("ErrorPage.html");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			response.sendRedirect("ErrorPage.html");
		}
	}

}
