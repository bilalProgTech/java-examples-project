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

@WebServlet("/StudentDetails")
public class StudentDetails extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    public StudentDetails() 
    {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String dbID = "";
		int initialID = 1001;
		try 
		{
			Connection con = DBConnect.initializeDatabase();
			PreparedStatement st = null;
			st = con.prepareStatement("select G_ID from Reservation");
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				dbID = rs.getString(1);
				initialID = Integer.parseInt(dbID);
			}
			if(initialID == 0)
				initialID = 1001;
			else
				initialID = initialID + 1;
			for (int i = 1; i <= 4; i++) 
			{
				st = con.prepareStatement("insert into Student values(?,?,?,?,?)");
				st.setInt(1, Integer.parseInt(request.getParameter("id"+i)));
				st.setString(2, request.getParameter("name"+i));
				st.setString(3, request.getParameter("email"+i));
				st.setInt(4, Integer.parseInt(request.getParameter("no"+i)));
				st.setString(5, ""+initialID);
				st.executeUpdate();
				st.close();
			}
			HttpSession sessi = request.getSession(false);
			String n = sessi.getAttribute("id3").toString();
			st = con.prepareStatement("insert into Reservation values(?,?,?,?)");
			st.setString(1, ""+initialID);
			st.setString(2, n);
			st.setString(3, "No");
			st.setString(4, "-");
			st.executeUpdate();
			st.close();
			
			st = con.prepareStatement("insert into query values(?,?)");
			st.setString(1, ""+initialID);
			if(request.getParameter("query").isEmpty())
			{
				st.setString(2, "No Query");
			}
			else
			{
				st.setString(2, request.getParameter("query"));
			}
			st.executeUpdate();
			st.close();
			
			con.close();
			response.sendRedirect("ListProjectStud.jsp");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			response.sendRedirect("ErrorPage.html");
		}
	}
}
