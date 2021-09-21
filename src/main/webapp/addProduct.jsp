<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title> 
<script>
function validateData()
{	
	return true;
}
</script>
</head> 
<body>
<form action="addProduct" method="get" onsubmit="return validateData()">
Product id <input type="text" name="pid" >
Product Name <input type="text" name="name" >
Quantity <input type="text" name="quantity" >
Seller id <input type="text" name="sellerid" >
Category id <input type="text" name="cid">
Product Price <input type="text" name="actualPrice" >
Description <input type="text" name="description" >


<button type="submit" name="btn">Add Product</button>
</form>
</body>
</html>