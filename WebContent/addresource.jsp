<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<title>Add Resource</title>
</head>
<body>
<div><jsp:include page="menu.jsp" /></div>
<div>
<%String role = (String)session.getAttribute("role"); %>
<ul class="sideul">
 <%if(role.equals("Staff")){ %>
  <li class="sideli"><a href="addresource.jsp">Add Resource</a></li>
   <%} %>
  <li class="sideli"><a href="ShowAllResourcesServlet">Reserve a resource</a></li>
 
   <li class="sideli"><a href="MyResourcesServlet">Cancel a resource</a></li>
  
</ul>
</div>

<div align="center">
<form action="AddResourceServlet" method="post">
<h3>Please fill the information to add the resource:</h3>
<div style="color: green;">${addressuccess}</div>
<div style="color: red;">${addreserror}</div>
  <table>
   <tr>
   <td>Name: </td><td> <input type="text" class="form-control" name="resourcename"></td>
 
  </tr>
  <tr>
 <td>Resource Type: </td>
  <td>  <input type="text" class="form-control" name="resourcetype"></td>
 </tr>
  <tr>
 <td> Other Details: </td>
  <td>  <textarea class="form-control" name="resourceinfo"></textarea></td>
  </tr>
 </table>
  <input type="submit" value="Add Resource!">
</form> 
</div>  
<div><jsp:include page="footer.jsp" /></div>
</body>
</html>