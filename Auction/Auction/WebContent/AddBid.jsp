<%@ page language="java" import="com.demo.dao.*,java.sql.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Add bid</title>
<script>
	function validateform(){
		var bidvalue=document.forms["f"]["bidvalue"].value;
		var walletamt=document.forms["f"]["walletamt"].value;
		var minbid=document.forms["f"]["minbid"].value;
		if(bidvalue > walletamt)
			alert("Reminder to add more money: Bid more than wallet amount. The bid will be submitted for now.");
		if(bidvalue < minbid)
			{
			alert("The bid should be equal or more than price value.");
			return false;
			}
			
	}
</script>
</head>
<body>
	<%
	Connection con;
    PreparedStatement getWalletAmount;
	String pid=request.getParameter("pid");
	String quantity=request.getParameter("quantity");
	String minbid=request.getParameter("minbidvalue");
	con=DBUtil.getMyConnection();
	getWalletAmount=con.prepareStatement("select walletamount from user where userid=2");
	Double walletamt=null;
	ResultSet rs=getWalletAmount.executeQuery();
	while(rs.next())
		walletamt=Double.parseDouble(rs.getString(1));
	
	%>
				    <form name="f" action="BuyerBidServlet" onsubmit="return validateform()" method="post">
		                <label>Bid Value</label><input type="text" name="bidvalue" " value="" required=""/> <br>
		                <input type="hidden" name="walletamt" value="<%=walletamt%>">
		                <input type="hidden" name="minbid" value="<%=minbid%>">
		                <label>Quantity</label><input type="number" min="1" max="<%=quantity%>" name="quantity" value="" required=""/> <br>
		                <input type="hidden" name="buyerid" value="2">
		                <input type="hidden" name="pid" value="<%=pid%>">
		                <input type="submit" value="Add Bid" class="btn">
		 			</form>
				 

</body>
</html>