package web3112021;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("header.jsp").include(request, response);

		/*
		 * Cookie ck = new Cookie("token", ""); ck.setMaxAge(0); response.addCookie(ck);
		 */

		HttpSession s = request.getSession(false);
		System.out.println(s.getId());
		s.invalidate();
		out.print("you are successfully logged out!");
	}
}
