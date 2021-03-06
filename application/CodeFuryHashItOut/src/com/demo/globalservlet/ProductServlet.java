package com.demo.globalservlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

@WebServlet("/displayProduct")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ProductServlet() 
    {
        super();    
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		ProductService pservice=new ProductServiceImpl();
		int sellerid = (int) request.getAttribute("userid");
		List<Product> plist=pservice.getAllProducts(sellerid);
		System.out.println("Seller id in ProductServlet: " + sellerid);
		System.out.println("List is : " + plist);
		request.setAttribute("plist", plist);
		request.setAttribute("userid", sellerid);
		RequestDispatcher rd=request.getRequestDispatcher("displayProduct.jsp");
		rd.forward(request, response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	}

