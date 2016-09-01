<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<title>Add Course</title>
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
<h3>Please give the course name: </h3>
<form action="CoursesServlet" method="post">
<div style="color: red;">${addcourseerror}</div>
<div style="color: green;">${addcoursesuccess}</div>
Course Name: <input type = "text" name="coursename"/>
Course ID: <input type = "text" name="courseid"/>
<input type="submit" value="Add Course!">
</form>
</div>
<div><jsp:include page="footer.jsp" /></div>
</body>
</html>