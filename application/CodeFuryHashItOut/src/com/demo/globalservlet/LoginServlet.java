package com.demo.globalservlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.demo.beans.User;
import com.demo.dao.DBUtil;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;
@WebServlet("/validate")
public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		PrintWriter out=response.getWriter();
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		String tOfUser=null;
		LoginService lservice=new LoginServiceImpl();
		int userid=lservice.validateUser(uname,pass);
		System.out.println("User ID in LoginServlet: " + userid);
		try {
		Connection con = DBUtil.getMyConnection();
		PreparedStatement ps;
		ps = con.prepareStatement("SELECT typeofuser from user where userid=?");
		ps.setInt(1, userid);
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			tOfUser = rs.getString(1);
		}
		if(tOfUser.equalsIgnoreCase("buyer"))
		{
			request.setAttribute("userid",userid);
			RequestDispatcher rdBuyer = request.getRequestDispatcher("/BuyerServlet");
			rdBuyer.forward(request,response);
		}
		
		else if(tOfUser.equalsIgnoreCase("seller")){
			request.setAttribute("userid",userid);
			RequestDispatcher rd1=request.getRequestDispatcher("/displayProduct");
			rd1.forward(request, response);
		}
		else {
			out.println("<h1>Username or Password not found</h1>");
			RequestDispatcher rd1=request.getRequestDispatcher("login.jsp");
			rd1.include(request, response);
			
		}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		
	}
}
