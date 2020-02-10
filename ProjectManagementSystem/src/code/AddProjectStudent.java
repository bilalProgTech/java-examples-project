package code;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AddProjectStudent")
public class AddProjectStudent extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    public AddProjectStudent() 
    {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		response.setContentType("text/html");
		
		int initialID = 0;
		
		try 
		{
			Connection con = DBConnect.initializeDatabase();
			
			PreparedStatement st = con.prepareStatement("select P_ID from AddProjectByStudent");
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
			{
				initialID = rs.getInt(1);
			}
			if(initialID == 0)
				initialID = 2017101;
			else
				initialID = initialID + 1;
			
			if(request.getParameter("ProjectTitle").isEmpty() || request.getParameter("message").isEmpty())
				throw new Exception();
			
			st = con.prepareStatement("insert into AddProjectByStudent values(?,?,?,?,?)");
			st.setInt(1, initialID);
			st.setString(2, request.getParameter("ProjectTitle"));
			st.setString(3, request.getParameter("message"));
			st.setString(4, request.getParameter("reference"));
			st.setString(5, "Not yet");
			st.executeUpdate();
			st.close();
			con.close();
			String n = Integer.toString(initialID);
			HttpSession session = request.getSession();
			session.setAttribute("id3", n);
			response.sendRedirect("Reservation.jsp");
		}
		catch(Exception e)
		{
			response.sendRedirect("ErrorPage.html");
			e.printStackTrace();
		}
	}
}