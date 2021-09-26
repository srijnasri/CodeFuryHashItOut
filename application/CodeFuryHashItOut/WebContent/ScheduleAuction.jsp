<%@ page import="java.util.ArrayList,java.util.List, com.demo.service.*,com.demo.beans.*" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css" media="all" />
<title>Schedule Auction</title>
</head>
<body>
	<center>
		<h1>Schedule Auction</h1>
	</center>
	
	<form action="ScheduleAuction" method="post"
		enctype="multipart/form-data">
		<p class="prod">
			<select name="database1">
				<option value="" selected name = "prodName">Select Product</option>
				<%
				int sellerId = Integer.parseInt(request.getParameter("sellerid"));
				System.out.println("SellerID in SA.jsp : " + sellerId);
				ScheduleAuctionServiceImpl sas = new ScheduleAuctionServiceImpl(); 
				List<Product> productList = sas.getSellerProducts(sellerId);
				//ArrayList<String> productList = (ArrayList<String>) request.getAttribute("productList");
				for (Product p : productList) {
				%>
				<option value="<%=p.getPid()%>"><%=p.getName() + " Actual Price: " + p.getActualPrice()%> /-</option>
				<%
					}
				%>
			</select>
		<p>
			<label for="MinPrice">Minimum Bid Value</label>
		</p>
		<input type = "hidden" name = "userid" value="<%=sellerId%>">
		<input id="minPrice" name="minPrice" placeholder="Minimum Bid Value"
			tabindex="4" type="text" required="required"> <br>
		<p class="startDate">
			<label for="Start Date">Start Date</label>
		</p>
		<input id="startDate" name="startDate" placeholder="YYYY-MM-DD"
			tabindex="5" type="date" required="required">
		
		<p class="endDate">
			<label for="End Date">End Date</label>
		</p>
		<input id="endDate" name="endDate" placeholder="YYYY-MM-DD"
			tabindex="6" type="date" required="required"> <br></br> <input
			class="buttom" name="Submit" id="Submit" value="Schedule Auction"
			type="Submit" tabindex="7">

	</form>
</body>
</html>