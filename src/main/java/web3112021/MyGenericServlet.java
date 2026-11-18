package web3112021;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/genericServlet")
public class MyGenericServlet extends GenericServlet {


	public void init() {
		System.out.println("Init Method Genericservlet::");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.getWriter().write("Hello From GenericServlet:");
		
	}
	
	public void destroy() {
		System.out.println("Init Method::");
	}


}
