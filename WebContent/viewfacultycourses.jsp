<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page  import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">

<title>View courses</title>
</head>
<body>

<div><jsp:include page="menu.jsp" /></div>

<div>
<ul class="sideul">
  <li class="sideli"><a href="DisplayCourseServlet">View Course Info</a></li>
  <li class="sideli"><a href="addcourses.jsp">Add Course Info</a></li>
  <li class="sideli"><a href="DisplayFacultycoursesServlet">View My Courses</a></li>
</ul>
</div>


<div align="center">
<% Map<String, ArrayList> coursedetails = (Map)request.getAttribute("mycoursedetails");
ArrayList<String> mycname = coursedetails.get("cname");
ArrayList<String> mycid = coursedetails.get("cid");
%>

<%//System.out.println(mycname.size());  %>
<form action="PreAddTAInfoServlet" method="post">
	<h2>Course Details: </h2>
	<%for(int i=0;i<mycname.size();i++){ %>
	<input type="radio" name="mycourse" value="<%=mycid.get(i) %>"> <%=mycid.get(i) %> <%=mycname.get(i) %><br><br>
	<%} %>
	<input type="submit" value="Add Details!">
	</form>
</div>
<div><jsp:include page="footer.jsp" /></div>

</body>
</html>