package web3112021;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(value = "/login", initParams = {
		@WebInitParam(name = "email", value = "webmaster@domain.com", description = "Email from webmaster"),
		@WebInitParam(name = "phone", value = "xxxx/xx.xx.xx", description = "Phone webmaster") }, description = "Servlet 3 initialisation parameter annotation example: @WebInitParam")
public class LoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		ServletConfig sc = getServletConfig();
		String email = sc.getInitParameter("email");
		System.out.println("email :: " + email);

		ServletContext sco = getServletContext();
		ServletContext sco1 = getServletConfig().getServletContext();
		sco.getInitParameter("dbusername");
		System.out.println("Sco is :" + sco);
		String n = request.getParameter("userName");
		String p = request.getParameter("userPass");

		ServletConfig servletConfig = getServletConfig();
		Connection conn = (Connection)sco.getAttribute("connection");
		if (p.equals("servlet")) {
			// write a code here to connect to db and fire a query
			// select * from user where uname="n" and password = p;
			// HttpSession s = request.getSession();
			// s.setMaxInactiveInterval(0)
			sco.setAttribute("key", "value"); // application
			/*
			 * Cookie c = new Cookie("token", n); response.addCookie(c);
			 */

			HttpSession s = request.getSession();
			System.out.println(s.getId());
			s.setAttribute("user", n);
			RequestDispatcher rd = request.getRequestDispatcher("welcome");
			request.setAttribute("data", "caluclatesd");
			sco.setAttribute("somdata", rd);
			rd.forward(request, response);

			// Integer val = (Integer) sco.getAttribute("logincount");

			// sco.setAttribute("logincount", ++val);
			//response.sendRedirect("welcome");
			// request.setAttribute("something", "value");

		} else {
			out.println("Sorry UserName or Password Error!");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
	}
}
