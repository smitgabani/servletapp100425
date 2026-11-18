package web3112021;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

	 private static int loginCount = 0;
	  public void sessionCreated(HttpSessionEvent se) {
		  System.out.println("inside sessionCreated");
		  loginCount++;
		  se.getSession().getServletContext().setAttribute("loginCount", loginCount);
		  //increase the ocunt
	  }
	    
	
	  public void sessionDestroyed(HttpSessionEvent se) {
		  System.out.println("inside sessionDestroyed");
		  loginCount--;
	  }
	

}
