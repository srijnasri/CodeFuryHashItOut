package com.demo.globalservlet;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.demo.beans.Product;
import com.demo.dao.CategoryDao;
import com.demo.dao.CategoryDaoImpl;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

@WebServlet("/addProduct")
@MultipartConfig

public class AddProductServlet extends HttpServlet 
{
private static final long serialVersionUID = 1L;	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
{
	
	    System.out.println("In get method");
	    String cname =request.getParameter("cname");
	    int sellerid=Integer.parseInt(request.getParameter("sellerid"));
		CategoryDao cservice=new CategoryDaoImpl();
		int categoryID=cservice.selectId(cname);
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		double price=Double.parseDouble(request.getParameter("actualPrice"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		
        Part file=request.getPart("image");
		String imageFileName=file.getSubmittedFileName();  // get selected image file name
		System.out.println("Selected Image File Name : "+imageFileName);
		String uploadPath="C:\\Users\\lenovo\\eclips-workspace1\\Auction\\images\\"+imageFileName;
		System.out.println("in uplod" +uploadPath);
		/*try
		{
		FileOutputStream fos=new FileOutputStream(uploadPath);
		InputStream is=file.getInputStream();
		byte[] data=new byte[is.available()];
		is.read(data);
		fos.write(data);
		fos.close();
		}
		
		catch(Exception e)
		{
		   e.printStackTrace();
		}*/
		Product p=new Product(name,quantity,sellerid,categoryID,price,description,imageFileName);
		
		ProductService pservice=new ProductServiceImpl();
		pservice.addProduct(p);
		request.setAttribute("userid", sellerid);
		RequestDispatcher rd1=request.getRequestDispatcher("/displayProduct");
		rd1.forward(request, response);		
}
}