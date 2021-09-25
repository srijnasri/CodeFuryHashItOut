package com.demo.globalservlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;

import com.demo.beans.Product;
import com.demo.service.BuyerService;
import com.demo.service.BuyerServiceImpl;

@WebServlet("/BuyerServlet")
public class BuyerServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int buyerid=2;
	BuyerService bservice=new BuyerServiceImpl();
	List<Product> plist= bservice.allboughtProducts(buyerid);
	List<List<String>> alist= bservice.allauctionProducts(buyerid);
	request.setAttribute("plist", plist);
	request.setAttribute("alist", alist);
	RequestDispatcher rd=request.getRequestDispatcher("BuyerHomePage.jsp");
	rd.forward(request, response);
	}
}
