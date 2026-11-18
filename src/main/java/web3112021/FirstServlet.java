package web3112021;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class FirstServlet implements Servlet {

	private ServletConfig config;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Inside FirstServlet init method:");
		this.config = config;
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		//logic 
		res.getWriter().write("<b>Hello From Servlet:</b>");
		getServletConfig();
		
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "My first servlet";
	}

	@Override
	public void destroy() {
		System.out.println("Inside destroy method:");
		
	}

}
