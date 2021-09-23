package com.demo.globalservlet;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.demo.beans.Product;
import com.demo.beans.User;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;
import com.demo.service.RegisterService;
import com.demo.service.RegisterServiceImpl;

@WebServlet("/validate1")
public class RegisterServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{
		String name=request.getParameter("fullname");
		String date=request.getParameter("dob");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date dt=null;
		try {
			dt=sdf.parse(date);
		} catch (ParseException e) {
				e.printStackTrace();
		}
		String mail=request.getParameter("mail");
		String phone=request.getParameter("phone");
		String username=request.getParameter("uname");
		String pass=request.getParameter("pass");
		String address=request.getParameter("address");
		String type=request.getParameter("radio1");
		double wallet=Double.parseDouble(request.getParameter("money"));
        User u=new User(name,dt,mail,phone,username,pass,address,wallet,type);
		RegisterService rservice=new RegisterServiceImpl();
		rservice.addUser(u);
		RequestDispatcher rd1=request.getRequestDispatcher("Register.jsp");
		rd1.forward(request, response);
	}
}
}