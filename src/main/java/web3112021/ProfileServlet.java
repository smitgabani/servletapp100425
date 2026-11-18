package web3112021;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("header.jsp").include(request, response);
		/*
		 * Cookie[] ck = request.getCookies(); String value = null; for (int i = 0; i <
		 * ck.length; i++) { if(ck[i].getName().equals("token")) value =
		 * ck[i].getValue(); } if(value != null && value != "") { response.getWriter().
		 * write("You are already logged in and here is your profile::"); }else {
		 * response.getWriter().
		 * write("You are not already logged in you need to login again"); }
		 */
		HttpSession s = request.getSession(false);
		System.out.println(s.getId());
		if(s != null && s.getAttribute("user") != null) {
			response.getWriter().write("You are already logged in and here is your profile::");
		}else {
			response.getWriter().write("You are not already logged in and you need to login again::");
		}
		
	}
}
