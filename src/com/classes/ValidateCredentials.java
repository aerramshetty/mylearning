package com.classes;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ValidateCredentials")
public class ValidateCredentials extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;

	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String username = request.getParameter("uname");
		String password = request.getParameter("psw");
		try {
			Statement st = conn.createStatement();//to send the request
			ResultSet rs = st.executeQuery("select username,password from usertable;");//we have the result set in java
			
			if(rs.getString("username")==username){
				RequestDispatcher rd = request.getRequestDispatcher("LoginSuccess.html");
				rd.forward(request, response);
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("LoginFail.html");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
