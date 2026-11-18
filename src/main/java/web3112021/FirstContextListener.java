package web3112021;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class FirstContextListener implements ServletContextListener{
	
	Connection con;
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Inside contextInitialized:: ");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/training_uat", "root", "root");
		} catch (Exception e) {
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
