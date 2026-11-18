package com.miit.servlet;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/myfirst")
public class MyFirstServlet implements Servlet {

	private ServletConfig config;

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("inside init:::");
		this.config = config;
	}

	@Override
	public ServletConfig getServletConfig() {
		return config;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("inside service:::");
		res.getWriter().write("this is from my first servlet:");

	}

	@Override
	public String getServletInfo() {
		return "This is my First Servlet";
	}

	@Override
	public void destroy() {
		System.out.println("inside destroy:::");
	}

}
