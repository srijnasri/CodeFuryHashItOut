<html>
<head>

<title> Login Page </title>
<link rel="stylesheet" href="css/LoginCSS.css"></link>
<script >
function check()
{
var name=document.form1.login.value;
var pass=document.form1.pass.value;

if(name=="")
{
alert("Please enter your name!");
name.focus();
return false;
}
if(pass=="")
{
alert("Please enter your password");
pass.focus();
return false;
}
if(name!=pass)
{
alert("Username and password Mismatched");
return false;	
}
}
function validatePass()
{	
	var v=document.getElementById("text2").value;
	if(v.length>=4  && v.length<6) //week password
	{
		document.getElementById("result").innerHTML="<font color=red>week password</font>";
	}
	if(v.length>=6  && v.length<8)//medium password
	{
		document.getElementById("result").innerHTML="<font color=yellow>medium password</font>";
	}
	if(v.length>=8) //strong password
	{
		document.getElementById("result").innerHTML="<font color=green>strong password</font>";
	}
	console.log(v);
}
</script>
</head>


<body>
<div class="logo">ONLINE AUCTIONING </div>
<div class="form-design">
<p class="heads">LOGIN </p>
<form action="validate" method="post" name="form1">
<input type="text" name="uname" id="uname" placeholder=" Username" minlength="3" maxlength="30" required>
<input type="password" name="pass" id="pass" placeholder=" Password" minlength="4" maxlength="15" onkeyup="validatePass()" required><div id="result"></div>
<input type="submit" name="btn" id="login-btn" value="Login Here" onclick="check()">
</form>
<div>

</body>
</html>