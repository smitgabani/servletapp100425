package web3112021;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletRequestAttributeListener;

//@WebListener
public class MyServletContextListener implements ServletContextListener, ServletRequestAttributeListener {

	Connection con;
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Inside contextInitialized:: ");
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/training_uat", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sce.getServletContext().setAttribute("connection", con);
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Inside contextDestroyed:: ");
		if(null != con) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
