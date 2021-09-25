package com.demo.globalservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Bid;
import com.demo.service.BuyerService;
import com.demo.service.BuyerServiceImpl;



@WebServlet("/BuyerBidServlet")
public class BuyerBidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BuyerService bservice=new BuyerServiceImpl();
		int buyerid=Integer.parseInt(request.getParameter("buyerid"));
		int pid=Integer.parseInt(request.getParameter("pid"));
		double bidvalue= Double.parseDouble(request.getParameter("bidvalue"));
		int bidquantity= Integer.parseInt(request.getParameter("quantity"));
		Bid b=new Bid(buyerid,pid,bidvalue,bidquantity,"open");
		bservice.putBid(buyerid , b);
		String message="Added Bid Successfully";
		request.setAttribute("message",message);
		RequestDispatcher rd=request.getRequestDispatcher("/BuyerServlet");
		rd.forward(request, response);
	}

}
