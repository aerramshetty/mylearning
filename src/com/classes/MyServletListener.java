package com.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyServletListener
 *
 */
@WebListener
public class MyServletListener implements ServletContextListener {
	Connection conn;
    /**
     * Default constructor. 
     */
    public MyServletListener() {
        // TODO Auto-generated constructor stub
    }
	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext sc = sce.getServletContext();
		try {
			Class.forName(sc.getInitParameter("Driver"));//load driver class 
			conn = DriverManager.getConnection(sc.getInitParameter("url"),sc.getInitParameter("username"),sc.getInitParameter("password"));//establish a connection between java and mysql
		} catch (Exception e) {
			
			
			e.printStackTrace();
		}//establish a connection between java and mysql
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         
    }


	
}
