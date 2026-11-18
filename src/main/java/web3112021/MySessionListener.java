package web3112021;

import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener{
	private static int totalnumberofsession = 0;
	  public void sessionCreated(HttpSessionEvent se) {	
		  System.out.println("inside sessionCreated::");
		  se.getSession().getServletContext().setAttribute("totalnumberofsession", totalnumberofsession++);
	  }
	    
	    /** 
	     * Receives notification that a session is about to be invalidated.
	     *
	     * @implSpec
	     * The default implementation takes no action.
	     *
	     * @param se the HttpSessionEvent containing the session
	     */
	     public void sessionDestroyed(HttpSessionEvent se) {
	    	 System.out.println("inside sessionDestroyed::");
	    	 se.getSession().getServletContext().setAttribute("totalnumberofsession", totalnumberofsession--);
	     }
}
