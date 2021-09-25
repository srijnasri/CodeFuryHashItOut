<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
</head>
<body>
<form name="f" action="BuyerServlet"  method="post">
                <div >
                <label>LoginID</label>
                    <input type="email" name="loginid" value="" required=""/>
                    
                </div>
                <div >
                <label>Password</label>		
                    <input type="password" name="password" value="" required=""/>
                    
                </div>
                <button type="submit" class="btn">Login</button>
 </form>
</body>
</html>