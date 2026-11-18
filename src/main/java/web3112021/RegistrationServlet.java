package web3112021;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value = "/register", initParams = {
		@WebInitParam(name = "email", value = "webmaster@domain.com", description = "Email from webmaster"),
		@WebInitParam(name = "phone", value = "xxxx/xx.xx.xx", description = "Phone webmaster") }, description = "Servlet 3 initialisation parameter annotation example: @WebInitParam")

public class RegistrationServlet extends HttpServlet {

	public void init() {
		System.out.println("Inside Init::");
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("fname");
		res.getWriter().write("Hello World from  GET servlet:" + name);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		ServletConfig servletConfig = getServletConfig();
		ServletConfig servletConfig1 = getServletConfig();
		
		String email = servletConfig.getInitParameter("email");
		String phone = servletConfig.getInitParameter("phone");
		
		ServletContext servletContext1 = servletConfig.getServletContext();
		ServletContext servletContext = getServletContext();
		
		if (servletContext1 == servletContext)
			System.out.println("both are equals:");
		String url = servletContext.getInitParameter("dbURL");
		String servletName = servletConfig.getServletName();
		
		String name = req.getParameter("fname");
		String uname = req.getParameter("uname");
		String lname = req.getParameter("lname");
		String password = req.getParameter("password");
	
		//req.getpara
		//business logic to insert this record in the database
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training_uat", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Connection conn = (Connection)servletContext.getAttribute("connection");
		String sql = "insert into registration values(?,?,?,?)";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, uname);
			st.setString(2, name);
			st.setString(3, lname);
			st.setString(4, password);			
			st.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		res.getWriter().write("Hello World from POST servlet:" + name + ":Servlet:" + servletName);
	}

	public void destroy() {
		System.out.println("Inside Init::");
	}

	public void caluclate() {

	}

}
