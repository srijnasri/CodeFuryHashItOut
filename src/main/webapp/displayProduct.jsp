<%@ page language="java" import="java.util.List,com.demo.beans.Product" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border = "2">
<tr><th>Product Id</th><th>Product Name</th><th>Product Price</th><th>Product Quantity</th><th>Seller ID</th><th>Category ID</th><th>Description</th><th>Image</th></tr>
  
  <%
     List<Product> plist = (List<Product>)request.getAttribute("plist");
     for(Product p:plist)	 
     {
     %>
    	 
    <tr>
    <td><%=p.getPid() %></td>
    <td><%=p.getName() %></td>
    <td><%=p.getActualPrice() %></td>
    <td><%=p.getQuantity() %></td>
    <td><%=p.getSellerID() %></td>
    <td><%=p.getCid() %></td>
    <td><%=p.getDescription() %></td>
    <th><%=p.getImage() %></th>
    </tr>	 
    	
    <%
    } 
  %> 
  
</table>
<a href = "addProduct.jsp">Add Product</a>
</body>
</html>