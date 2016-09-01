<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<title>Add Alumni</title>
</head>
<body>
<div><jsp:include page="menu.jsp" /></div>
<div>
<ul class="sideul">
  <li class="sideli"><a href="addalumni.jsp">Add Alumni</a></li>
<li class="sideli"><a href="ViewAlumniServlet">View Alumni</a></li>
</ul>
</div>
<div align="center">
<h3>Please fill details below:</h3>
<form action="AddAlumniServlet" method="post">
<div style="color: green;">${addcoursesuccess}</div>
<div style="color: red;">${addcourseerror}</div>
<table>

   <tr>
   <td>First Name: </td><td> <input type="text" class="form-control" name="fname"></td>
 
  </tr>
 <tr>
   <td>Last Name: </td><td> <input type="text" class="form-control" name="lname"></td>
 
  </tr>
 <tr>
   <td>Info: </td><td> <input type="text" class="form-control" name="info"></td>
 
  </tr>
 
 </table>
  <input type="submit" value="Add/Update Info!">
  </form>
</div>
<div><jsp:include page="footer.jsp" /></div>
</body>
</html>