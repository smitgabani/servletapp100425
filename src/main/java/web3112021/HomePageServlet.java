package web3112021;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomePageServlet extends HttpServlet {

	public void init() {
		System.out.println("Inside the initi method Home:::");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.print("<html><body>");
		out.print("<b>hello HttpServletEx servlet GET</b>");
		out.print("</body></html>");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ServletContext sco =  getServletContext();
		System.out.println("Sco is :"+ sco);
		Integer val = (Integer)sco.getAttribute("logincount");
		String data = (String)request.getAttribute("data");
		String n = request.getParameter("userName");
		out.print("Welcome " + n);
	}

	public void destroy() {
		System.out.println("Inside the destroy method:::");
	}

}
