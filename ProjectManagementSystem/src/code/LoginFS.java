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

@WebServlet("/LoginFS")
public class LoginFS extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    public LoginFS() 
    {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		String un = request.getParameter("un");
		String p = request.getParameter("pw");
		Cryption c = new Cryption();
		p = c.encryptText(p);
		String id = "", pw = "";
		String n = "";
		try
		{
			Connection con = DBConnect.initializeDatabase();
			PreparedStatement st = con.prepareStatement("select * from faculty where ID='"+un+"' and PW='"+p+"'");
			ResultSet rs = st.executeQuery();
			while(rs.next())
			{
				id = rs.getString(1);
				pw = rs.getString(2);
				n = rs.getString(3);
			}
			if(un.equals("admin") &&  p.equals("gxxoqzmxezg"))
			{
				HttpSession session = request.getSession();
				session.setAttribute("uname", n);
				response.sendRedirect("ADMINRegistration.jsp");
			}
			else if(id.equals(un) && p.equals(pw))
			{
				HttpSession session = request.getSession();
				session.setAttribute("uname", n);
				response.sendRedirect("MainPageFaculty.jsp");
			}
			else
			{
				response.sendRedirect("ErrorPage.html");
			}
		} 
		catch (Exception e) 
		{
			response.sendRedirect("ErrorPage.html");
			e.printStackTrace();
		}
	}
}
