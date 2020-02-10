package code;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GoogleRedirct
 */
@WebServlet("/GoogleRedirct")
public class GoogleRedirct extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    public GoogleRedirct() 
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{

		String name = request.getParameter("search");
		Cookie google = new Cookie("search", request.getParameter("search"));
		response.addCookie(google);
		response.sendRedirect("https://scholar.google.com/scholar?hl=en&q"+name);
	}
}
