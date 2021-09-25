<%@ page language="java" import="java.util.List,com.demo.beans.Product,com.demo.dao.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Buyer Homepage</title>
<style>
	.modal {
	  display: none; /* Hidden by default */
	  position: fixed; /* Stay in place */
	  z-index: 1; /* Sit on top */
	  padding-top: 100px; /* Location of the box */
	  left: 0;
	  top: 0;
	  width: 50%; /* Full width */
	  height: 100%; /* Full height */
	  overflow: auto; /* Enable scroll if needed */
	  background-color: rgb(0,0,0); /* Fallback color */
	  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
	}
	
	/* Modal Content */
	.modal-content {
	  background-color: #fefefe;
	  margin: auto;
	  padding: 20px;
	  border: 1px solid #888;
	  width: 80%;
	}
	
	/* The Close Button */
	.close {
	  color: #aaaaaa;
	  float: right;
	  font-size: 28px;
	  font-weight: bold;
	}
	
	.close:hover,
	.close:focus {
	  color: #000;
	  text-decoration: none;
	  cursor: pointer;
	}
	* {
	  box-sizing: border-box;
	}
	
	.row {
	  margin-left:-5px;
	  margin-right:-5px;
	}
	  
	.column {
	  float: left;
	  width: 50%;
	  padding: 5px;
	}
	
	/* Clearfix (clear floats) */
	.row::after {
	  content: "";
	  clear: both;
	  display: table;
	}
	
	table {
	  border-collapse: collapse;
	  border-spacing: 0;
	  width: 100%;
	  border: 1px solid #ddd;
	}
	
	th, td {
	  text-align: left;
	  padding: 16px;
	}
	
	tr:nth-child(even) {
	  background-color: #f2f2f2;
	}
</style>
</head>
<body>
<%
	List<Product> plist=(List<Product>)request.getAttribute("plist");
	List<List<String>> alist=(List<List<String>>)request.getAttribute("alist");
	String buyerid="2";
	int s=1;
	
%>
<p>  ${message}</p>

	<div class="row">
	<div class="column">
		<h2>Bought Products</h2>
			<table>
				<tr>
					<th>serial no.</th>
					<th>Product Name</th>
					<th>Product Image</th>
				</tr>
				<%for (Product p:plist)
				{ %>
				<tr>
					<td><%=s++ %></td>
					<td><%=p.getName()%></td>
					<td><%=p.getImage()%></td>
				</tr>
				
				<% } %>
			
			</table>
     </div>
     <div class="column">
     	<h2>Product Live on Auction</h2>
			<table>
				<tr>
					<th>Serial no.</th>
					<th>Product Name</th>
					<th>Product Image</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Bid end date</th>
					<th>No. of bidders</th>
					<th>Place bid</th>
				</tr>
				<% s=1;
			  for(List<String> a : alist)
				{ 
					
		           %>
				<tr>
					<td><%=s++ %></td>
					<td><%=a.get(1)%></td>
					<td><img src="images/<%=a.get(2)%>" width="120px" height="120px"></td>
					<td><%=a.get(3)%></td>
					<td><%=a.get(4)%></td>
					<td><%=a.get(5)%></td>
					<td><%=a.get(6)%></td>
					<td><a href="AddBid.jsp?pid=<%=a.get(0)%>&quantity=<%=a.get(4)%>&minbidvalue=<%=a.get(3)%>&buyerid=<%=buyerid%>"><input type="submit" value="Add Bid" name="Add"></a></td>
				</tr>
				<%}%>
			</table>
		</div>
	</div>
</body>
</html>