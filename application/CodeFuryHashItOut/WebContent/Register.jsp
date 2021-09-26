<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Register Page</title>
<link rel="stylesheet" href="css/RegisterCSS.css"></link>
<script src="register.js">
	function check() {
		var name = document.form1.fullname.value;
		var dob = document.form1.dob.value;
		var email = document.form1.mail.value;
		var mob = document.form1.phone.value;

		var uname = document.form1.uname.value;
		var pwd = document.form1.pass.value;
		var cpwd = document.form1.cpass.value;
		var addr = document.form1.address.value;

		var money = document.form1.money.value;
		if (name == "") {
			alert("Please enter your name!");
			name.focus();
			return false;
		}
		if (dob == "") {
			alert("Please enter DateOfBirth!");
			dob.focus();
			return false;
		}
		if (email == "") {
			alert("Please enter your Email Id!");
			email.focus();
			return false;
		}
		if (mob == "") {
			alert("Please enter your mobile number!");
			mob.focus();
			return false;
		}
		if (uname == "") {
			alert("Please enter your username!");
			uname.focus();
			return false;
		}
		if (pwd == "") {
			alert("Please enter your password");
			pwd.focus();
			return false;
		}
		if (cpwd == "") {
			alert("Please confirm your password");
			cpwd.focus();
			return false;
		}
		if (addr == "") {
			alert("Please enter your address");
			addr.focus();
			return false;
		}
		var Radiobutton1 = document.getElementById('radio11').checked;
		var Radiobutton2 = document.getElementById('radio22').checked;
		var prefer = document.getElementsByName('radio1');
		var radioValue;
		if (RadioButton1 == false && Radiobutton2 == false) {
			alert("Select any 1 Radio Button");
			return false;
		}
		for (var i = 0; i < prefer.length; i++) {
			if (prefer[i].checked == true)
				radioValue = prefer[i].value;
		}
		if (money == "") {
			alert("Please enter wallet amount");
			money.focus();
			return false;
		}
		if (name != pass) {
			alert("Username and password Mismatched");
			return false;
		}
	}
	function validatePass() {
		var v = document.getElementById("pass1").value;
		if (v.length >= 4 && v.length < 6) //week password
		{
			document.getElementById("result").innerHTML = "<font color=red>week password</font>";
		}
		if (v.length >= 6 && v.length < 8)//medium password
		{
			document.getElementById("result").innerHTML = "<font color=yellow>medium password</font>";
		}
		if (v.length >= 8) //strong password
		{
			document.getElementById("result").innerHTML = "<font color=green>strong password</font>";
		}
		console.log(v);
	}
	function validateCPass() {
		var v = document.getElementById("pass1").value;
		var v1 = document.getElementById("cpass1").value;
		if (v != v1) //password mismatched
		{
			document.getElementById("result1").innerHTML = "<font color=red>Password Mismatch</font>";
		}
		if (v == v1)//password matches
		{
			document.getElementById("result1").innerHTML = "<font color=green>Password Matched</font>";
		}
		console.log(v);
	}
</script>
</head>


<body>
	<div class="logo">ONLINE AUCTIONING</div>
	<div class="form-design">
		<p class="heads">REGISTER</p>
		<form action="validate1" method="post" name="form1">
		
			<label class="label1">Name</label> 
			<input type="text" name="fullname"
				placeholder="  Full Name..." id="text1" minlength="3" maxlength="30"
				required> 
			<label class="label2">Date of Birth</label>
			<input type="date" name="dob" id="dob1" min="2010-01-01"
				placeholder="  Date in YYYY-MM-DD..." required>
			 <label class="label3">Email</label>
			 <input type="email" name="mail"
				id="mail1" pattern="^[a-z0-9]\.[a-z]{2,3}+$"
				placeholder="  Email..." maxlength="30" required>
			 <label class="label4">Phone No.</label> <input type="tel" name="phone"
				pattern="^[6-9]{1}[0-9]{0,9}$"
				title="Number must start from 6,7,8,9 only" id="phone1" min="1"
				placeholder="  Mobile No..." maxlength="10" required> 
			<label class="label5">Username</label> 
			<input type="text" name="uname"
				id="uname1" placeholder="  UserName..." minlength="3" maxlength="30"
				required> 
			<label class="label6">Password</label> 
			<input type="password" name="pass" id="pass1" placeholder="  Password..."
				minlength="4" maxlength="15" onkeyup="validatePass()" required>
			<div id="result"></div>
			<label class="label7">Confirm<br>Password</label> 
			<input type="password" name="cpass" id="cpass1"
				placeholder="  Re-type Password..." minlength="4" maxlength="15"
				onkeyup="validateCPass()" required>
			<div id="result1"></div>
			<label class="label8">Address</label>
			<input type="text"
				name="address" id="address1" minlength="5"
				placeholder="  Address (Optional)..." maxlength="100"> 
			<label class="label9">Type of User</label> 
			<input type="radio" name="radio1" value="Buyer" required>
			<label class="label91">Buyer</label>
			<input type="radio" name="radio1" value="Seller" required> 
			<label class="label92">Seller</label>
			<label class="label10">Wallet<br>Amount </label> 
			<input type="number" name="money" id="money1"
				placeholder="  Amount in Rs. (Optional)..." minlength="4"
				maxlength="10" min=500> 
			<input type="submit" name="btn" id="login-btn" value="Register Here" onclick="check()">
		</form>
		</div>
</body>
</html>