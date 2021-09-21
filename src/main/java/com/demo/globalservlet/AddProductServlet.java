package com.demo.globalservlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
		int pid=Integer.parseInt(request.getParameter("pid"));
		String name=request.getParameter("name");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		int sellerid=Integer.parseInt(request.getParameter("sellerid"));
		int cid =Integer.parseInt(request.getParameter("cid"));
		
		double price=Double.parseDouble(request.getParameter("actualPrice"));
		String description=request.getParameter("description");
		Product p=new Product(pid,name,cid,description,price,quantity,"gg",sellerid);
		ProductService pservice=new ProductServiceImpl();
		pservice.addProduct(p);
		RequestDispatcher rd1=request.getRequestDispatcher("displayProduct");
		rd1.forward(request, response);
}
}
