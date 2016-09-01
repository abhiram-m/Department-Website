<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page  import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">

<title>Add/View courses</title>
</head>
<body>

<div><jsp:include page="menu.jsp" /></div>

<ul class="sideul">
  <li class="sideli"><a href="DisplayCourseServlet">View Course Info</a></li>
  <li class="sideli"><a href="addcourses.jsp">Add Course Info</a></li>
  <li class="sideli"><a href="DisplayFacultycoursesServlet">View My Courses</a></li>
</ul>
</div>


<div align="center">
<% Map<String, ArrayList> coursedetails = (Map)request.getAttribute("coursedetails");
ArrayList<String> cname = coursedetails.get("cname");
ArrayList<String> cid = coursedetails.get("cid");
ArrayList<String> netid = coursedetails.get("netid");
%>
	<h2>Course Details: </h2>
	<div style="color: red;">${addcourseerror}</div>
<div style="color: green;">${addcoursesuccess}</div>
	<form action="AddMyTeachingCourseServlet" method="post">

<%for(int i=0;i<cname.size();i++){ 
if(netid.get(i)==null){
%>
<p><input type="radio" name="allcourse" value="<%=cid.get(i) %>"><%= cid.get(i) %> <%=cname.get(i) %></p>
<%}else{ %>
<p><%=cid.get(i) %> <%=cname.get(i) %></p>
<%} }%>
<input type="submit" value="Teach this course!">
</form>
</div>

<div><jsp:include page="footer.jsp" /></div>
</body>
</html>