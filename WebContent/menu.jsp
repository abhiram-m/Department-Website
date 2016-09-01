<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<style>
.menuul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #6D3D98;
}

.menuli {
    float: left;
    border-right:1px solid #bbb;
}

.menuli:last-child {
    border-right: none;
}

.menuli a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

.menuli a:hover:not(.active) {
    background-color: #EEB111;
}

.active {
    background-color: #4CAF50;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul class="menuul">
  <li class="menuli"><a href="home.jsp">Home</a></li>
  <%if(session.getAttribute("role").equals("Faculty")){ %>
  <li class="menuli"><a href="DisplayCourseServlet">Add/View Courses</a></li>
  <%} %>
  <li class="menuli"><a href="ViewPhDStudentsServlet">PhD Status</a></li>
  <li class="menuli"><a href="MyResourcesServlet">Manage Resources</a></li>
  <li class="menuli"><a href="announcements.jsp">Announcements</a></li>
  <li class="menuli"><a href="DiscussionHomeServlet">Discussion</a></li>
  <li class="menuli"><a href="ViewAlumniServlet">Alumni</a></li>
  <li class="menuli"><a href="ViewExamServlet">Exams</a></li>
  
  <li class="menuli" style="float:right"><a href="Logout">Logout</a></li>
  <li class="menuli" style="float:right"><a href="ViewProfileServlet">Profile</a></li>
</ul>



</body>
</html>