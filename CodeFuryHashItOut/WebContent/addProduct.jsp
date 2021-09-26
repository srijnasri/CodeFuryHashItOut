<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
	function validateData() {
		return true;
	}
</script>
</head>
<body>
	<% String sellerid=request.getParameter("sellerid"); %>
	<form action="addProduct" method="post"
		onsubmit="return validateData()" enctype="multipart/form-data">
		Product Name <input type="text" name="name"> <label>Category</label>
		
		<select name="cname">
			<option value="others">Others</option>
			<option value="furniture">Furniture</option>
			<option value="showPice">Show price</option>
			<option value="cars">Cars</option>
		</select> Description <input type="text" name="description"> 
		Actual Price <input type="text" name="actualPrice"> 
		Quantity <input type="text" name="quantity"> 
		Add Image <input type="file"
			name="image"> <input type="submit" value="Add Image">
			<input type="hidden" name="sellerid" value="<%=sellerid %>">
		<button type="submit" name="btn" onclick="getData()">Add
			Product</button>
	</form>
</body>
</html>