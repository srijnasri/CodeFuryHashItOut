<%@ page language="java" import="java.util.List,com.demo.beans.Product" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Your Products:</h2>
<table border = "2">
  <%
     List<Product> plist = (List<Product>)request.getAttribute("plist");
  	 boolean emptyList = false;
     int sellerid=(int)request.getAttribute("userid");
     for(Product p:plist)	 
     {
     %>
<tr><th>Product ID</th><th>Name</th><th>Actual Price</th><th>Product Quantity</th><th>Category ID</th><th>Description</th><th>Image</th></tr>
  
    	 
    <tr>
    <td><%=p.getPid() %></td>
    <td><%=p.getName() %></td>
    <td><%=p.getActualPrice() %></td>
    <td><%=p.getQuantity() %></td>
    <td><%=p.getCid() %></td>
    <td><%=p.getDescription() %></td>
    <th><%=p.getImage() %></th>
    </tr>	 
    	
    <%
    }
  	 
  %> 
  
</table>
<a href = "addProduct.jsp?sellerid=<%=sellerid%>">Add Product</a><br>
<a href = "ScheduleAuction.jsp?sellerid=<%=sellerid%>">Schedule Auction</a>
</body>
</html>