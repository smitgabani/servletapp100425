package web3112021;

import java.io.IOException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(description = "This is my first annotated servlet", urlPatterns = "/httpServlet", loadOnStartup = 0)
public class HttpServletEx extends HttpServlet {

	public void init() {
		System.out.println("Init Method HTTP::");
	}

	public void destroy() {
		System.out.println("Init Method::");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("Hello From HttpServlet:");
		ServletConfig servletConfig = getServletConfig();
		ServletContext servletContext1 = getServletConfig().getServletContext();
		ServletContext servletContext = getServletContext();
		if (servletContext1 == servletContext)
			System.out.println("both are equals:");
		String email = servletConfig.getInitParameter("email");
		String phone = servletConfig.getInitParameter("phone");
		String url = servletContext.getInitParameter("dbURL");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write("hello from post");
	}

}
