package code;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessioningData")
public class SessioningData extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    public SessioningData() 
    {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException 
    {
    	String n = request.getParameter("id");
		HttpSession session = request.getSession();
		session.setAttribute("id3", n);
		response.sendRedirect("Reservation.jsp");
    }
}
