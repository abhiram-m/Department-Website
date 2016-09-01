<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
html{
    background-image:url("css/homeimage.jpg");
    background-repeat: no-repeat;
	background-size: cover;    
}
a{
	color:purple;

}

</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<div align="center">
<h3>WELCOME TO COMPUTER SCIENCE DEPARTMENT</h3>
<h2>Login: </h2>
<form action="LoginServlet" method="post">
 <div style="color: green;">${logout}</div>
 <div style="color: green;">${registersuccess}</div>
  <div style="color: red;">${loginerr}</div>
<div>
  <table>
   <tr>
   <td>Net ID: </td><td> <input type="text" class="form-control" name="netid"></td>
 
  </tr>
  <tr>
 <td>Password: </td>
  <td>  <input type="password" class="form-control" name="password"></td>
 </tr>
 </table>
  <input type="submit" value="Login!"><br>
  <a href="registration.jsp"> Register Now!</a> &nbsp
  
 </div>
 </form>
 </div>
</body>
</html>