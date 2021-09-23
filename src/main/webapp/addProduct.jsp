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
Product Name <input type="text" name="name" >
<label>Category</label>
<select name="cname">
<option value="others">Others</option>
<option value="furniture">Furniture</option>
</select>
Description <input type="text" name="description" >
Actual Price <input type="text" name="actualPrice" >
Quantity <input type="text" name="quantity" >
Image <input type="text" name="image" >
<button type="submit" name="btn" onclick="getData()">Add Product</button>
</form>
</body>
</html>