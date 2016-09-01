<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page  import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<title>Update Alumni</title>
<%String studentselected = (String)(request.getAttribute("studentselected"));
Map<String, ArrayList> alumni = (Map) request.getAttribute("alumni");
ArrayList<String> fname = alumni.get("fname");
ArrayList<String> info = alumni.get("info");
 %>
</head>
<body>

<%if(!session.getAttribute("role").equals("Student")){ %>
<div><jsp:include page="menu.jsp" /></div>
<%}else{ %>
<div><jsp:include page="smenu.jsp" /></div>
<%} %>
<div>
<ul class="sideul">

  <li class="sideli"><a href="addalumni.jsp">Add Alumni</a></li>
   <li class="sideli"><a href="ViewAlumniServlet">View Alumni</a></li>

</ul>
</div>
<div align="center">
<h3>Information of <%=fname.get(0) %>: </h3>
<p>Info:  <%=info.get(0) %></p>


<form action="AddAlumniInfoServlet" method="post">
<div style="color: green;">${addphdsuccess}</div>
<div style="color: red;">${addphderror}</div>
<input type="hidden" name = "studentselected" value="<%=studentselected %>">
<table>

   <tr>
   <td>Info: </td><td> <input type="text" class="form-control" name="alumniinfo"></td>
 
  </tr>
 
 </table>
  <input type="submit" value="Add/Update Info!">
  </form>
  
  </div>
  <div><jsp:include page="footer.jsp" /></div>
</body>
</html>