package com.demo.globalservlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.demo.beans.Product;
import com.demo.dao.CategoryDao;
import com.demo.dao.CategoryDaoImpl;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	    String cname =request.getParameter("cname");
		//System.out.println(cname);
		CategoryDao cservice=new CategoryDaoImpl();
		int categoryID=cservice.selectId(cname);
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		double price=Double.parseDouble(request.getParameter("actualPrice"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		Product p=new Product(name,categoryID,description,price,quantity,"gg");
		ProductService pservice=new ProductServiceImpl();
		pservice.addProduct(p);
		//System.out.println(name);
		RequestDispatcher rd1=request.getRequestDispatcher("displayProduct");
		rd1.forward(request, response);	
}
}