<%@page import="seterm.dao.Logindao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page  import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">

<title>Add Info</title>
</head>
<body>
<%if(!session.getAttribute("role").equals("Student")){ %>
<div><jsp:include page="menu.jsp" /></div>
<%}else{ %>
<div><jsp:include page="smenu.jsp" /></div>
<%} %>
<ul class="sideul">

  <li class="sideli"><a href="DisplayCourseServlet">View Course Info</a></li>
  <%if(!session.getAttribute("role").equals("Student")){ %>
  <li class="sideli"><a href="addcourses.jsp">Add Course Info</a></li>
  <li class="sideli"><a href="DisplayFacultycoursesServlet">View My Courses</a></li>
  <%} %>
</ul>
<div align ="center">

<form method="post" action="AddTAInfoServlet">
<% String mycid = (String) request.getAttribute("mycid");
Map<String, ArrayList> myofficehours = (Map) request.getAttribute("myofficehours");
ArrayList<String> ohours = myofficehours.get("ohours");
ArrayList<String> tainfo = myofficehours.get("tainfo");
ArrayList<String> syllabus = myofficehours.get("syllabus");
ArrayList<String> netid = myofficehours.get("netid");
Logindao ll = new Logindao();
String name = ll.getNamefromreg(netid.get(0));
%>

<div style="color: green;">${addtasuccess}</div>
<div style="color: red;">${addtaerror}</div>
<input type="hidden" name="mycid" value="<%=mycid%>">

<h3>Please find the info below for <%=mycid %>:</h3>
<table>
<tr>

<td>Professor:</td><td><%=name %></td>
</tr>
   <tr>
   <td>Office Hours: </td><td> <%=ohours.get(0) %></td>
 
  </tr>
  <tr>
 <td>TA Info: </td>
  <td> <%=tainfo.get(0) %></td>
 </tr>
  <tr>
 <td> Syllabus: </td>
  <td>  <%=syllabus.get(0) %></td>
  </tr>
</table>
<%if(!session.getAttribute("role").equals("Student")){ %>
<h3>Please add the info below for <%=mycid %>:</h3>
<table>
   <tr>
   <td>Office Hours: </td><td> <input type="text" class="form-control" name="ohours"></td>
 
  </tr>
  <tr>
 <td>TA Info: </td>
  <td>  <input type="text" class="form-control" name="ta"></td>
 </tr>
  <tr>
 <td> Syllabus: </td>
  <td>  <textarea class="form-control" name="syllabus" rows="4" cols="50"></textarea></td>
  </tr>
</table>

<input type="submit" value="Add/Update!">
<%} %>
</form>


</div>

</body>
<div><jsp:include page="footer.jsp" /></div>
</html>