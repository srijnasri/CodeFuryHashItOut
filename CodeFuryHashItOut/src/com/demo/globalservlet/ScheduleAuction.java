package com.demo.globalservlet;
import java.io.*;
import java.sql.*;
import java.text.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.dao.DBUtil;

/**
 * Servlet implementation class CreateAuction
 */
@WebServlet("/ScheduleAuction")
@MultipartConfig(maxFileSize = 16777216)
public class ScheduleAuction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static java.sql.Date sDate;
	static java.sql.Date eDate;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		int pid = Integer.parseInt(request.getParameter("database1"));
		System.out.println(pid);
		int userid = Integer.parseInt(request.getParameter("userid"));
		double minPrice = Double.parseDouble(request.getParameter("minPrice"));
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");

		try {
			sDate = convertJavaDateToSqlDate(startDate);
			eDate = convertJavaDateToSqlDate(endDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Boolean mStartDate = ValidateInput.validateStartDateOfAuction(sDate);
		Boolean mEndDate = ValidateInput.validateEndDateOfAuction(sDate, eDate);

		if (!mStartDate) {
			request.setAttribute("sellerid", userid);
			out.print("<center><p style=\"color:red\">Not a valid Start Date!</p></center>");
			RequestDispatcher rd = request.getRequestDispatcher("ScheduleAuction.jsp");
			rd.include(request, response);
		} else {
			if (!mEndDate) {
				out.print("<center><p style=\"color:red\">End date cannot be more than 3 days of the start date.\n"
						+ "</p></center>");
				request.setAttribute("sellerid", userid);
				RequestDispatcher rd = request.getRequestDispatcher("ScheduleAuction.jsp");
				rd.include(request, response);
			} else {

				String query1 = "insert into productauction(sellerid, minbidvalue, bidstartdate, bidenddate, status, pid)"
						+ "values (?,?,?,?,'new',?)";

				try {

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DBUtil.getMyConnection();
					PreparedStatement pst = conn.prepareStatement("Select actualprice from product where pid = ?");
					pst.setInt(1, pid);
					double actualPrice = 0;
					ResultSet rs = pst.executeQuery();
					while(rs.next()) actualPrice = rs.getDouble(1);
					System.out.println(minPrice);
					System.out.println(actualPrice);
					if(minPrice > actualPrice)
					{
						out.print("<center><p style=\"color:red\">Minimum value cannot be greater than actual price of the Product\n"
								+ "</p></center>");
						request.setAttribute("sellerid", userid);
						RequestDispatcher rd = request.getRequestDispatcher("ScheduleAuction.jsp");
						rd.include(request, response);
					}
					else
					{
						PreparedStatement pst1 = conn.prepareStatement(query1);
						pst1.setInt(1,userid);
						pst1.setDouble(2, minPrice);
						pst1.setDate(3, sDate);
						pst1.setDate(4, eDate);
						pst1.setInt(5, pid);
						pst1.executeUpdate();

						request.setAttribute("userid", userid);
						RequestDispatcher rd = request.getRequestDispatcher("/displayProduct");
						rd.forward(request, response);
					}
					}
				catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
							e.printStackTrace();
						}
			}
			}
	}

	public java.sql.Date convertJavaDateToSqlDate(String date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date sDate = formatter.parse(date);
		return (new java.sql.Date(sDate.getTime()));
	}
}
