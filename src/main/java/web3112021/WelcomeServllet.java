package web3112021;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/welcome", initParams = {
		@WebInitParam(name = "email", value = "webmaster@domain.com", description = "Email from webmaster"),
		@WebInitParam(name = "phone", value = "xxxx/xx.xx.xx", description = "Phone webmaster") }, description = "Servlet 3 initialisation parameter annotation example: @WebInitParam")
public class WelcomeServllet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String data = (String)request.getAttribute("data");
		ServletContext servletContext1 = getServletConfig().getServletContext();
		ServletContext servletContext = getServletContext();			
		request.getRequestDispatcher("header.jsp").include(request, response);  
		response.getWriter().print("from the welcome servlet::");;
		
		/*
		 * HttpSession s = request.getSession(false); if(s == null)
		 * response.getWriter().write("login first"); else { String uname =
		 * request.getParameter("userName"); request.getAttribute("data");
		 * response.getWriter().print("from the welcome servlet::");;
		 * s.setAttribute(uname, uname); } s.invalidate();
		 */
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String uname = request.getParameter("userName");
		response.getWriter().print("from the welcome servlet GEt Method::");;
	}
}
