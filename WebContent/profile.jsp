<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page  import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<title>My Profile</title>
</head>
<%if(!session.getAttribute("role").equals("Student")){ %>
<div><jsp:include page="menu.jsp" /></div>
<%}else{ %>
<div><jsp:include page="smenu.jsp" /></div>
<%} %>
<div>
<ul class="sideul">
  <li class="sideli"><a href=""></a></li>
</ul>
</div>
<body>
<div align ="center">
<h3>My Profile:</h3>
<%Map<String, ArrayList> user = (Map)request.getAttribute("user");
ArrayList<String> fname = user.get("fname");
ArrayList<String> lname = user.get("lname");
ArrayList<String> password = user.get("password");
ArrayList<String> netid = user.get("netid");

ArrayList<String> email = user.get("email");
ArrayList<String> phone = user.get("phone");
ArrayList<String> advisor = user.get("advisor");
	
%>



<br>
	<div style="color: red;">${addcourseerror}</div>
<div style="color: green;">${addcoursesuccess}</div>
	<form action="UpdateProfileServlet" method="post">
  <table>
  
  <tr>
  <td>NetID: </td><td><%= netid.get(0)%></td>
  </tr>
   <tr>
   <td>First Name: </td><td> <input type="text" class="form-control" name="fname" value="<%=fname.get(0) %>" required></td>
 
  </tr>
  <tr>
 <td>Last Name: </td>
  <td>  <input type="text" class="form-control" name="lname" value="<%=lname.get(0) %>" required></td>
 </tr>
  <tr>
  <td>Password: </td>
  <td>  <input type="text" class="form-control" name="password" value="<%=password.get(0) %>" required></td>
   </tr> 
  
   <tr>
 <td>Email: </td>
  <td>  <input type="text" class="form-control" name="email" value="<%=email.get(0) %>" required></td>
 </tr>
 
  <tr>
 <td>Phone: </td>
  <td>  <input type="text" class="form-control" name="phone" value="<%=phone.get(0) %>" required></td>
 </tr>
 <%if(session.getAttribute("role").equals("Student")){ %>
  <tr>
 <td>Advisor: </td>
  <td>  <input type="text" class="form-control" name="advisor" value="<%=advisor.get(0) %>" required></td>
 </tr>
 <%} %>
 </table>
 
  <input type="submit" value="Update!">
  
</form>
</div>
<div><jsp:include page="footer.jsp" /></div>
</body>
</html>