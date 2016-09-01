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
<%if(!session.getAttribute("role").equals("Student")){ %>
<div><jsp:include page="menu.jsp" /></div>
<%}else{ %>
<div><jsp:include page="smenu.jsp" /></div>
<%} %>
<div>
<ul class="sideul">
 
</ul>
</div>


<div align="center">
<div style="color: red;">${addcourseerror}</div>
<div style="color: green;">${addcoursesuccess}</div>
<% Map<String, ArrayList> coursedetails = (Map)request.getAttribute("coursedetails");
ArrayList<String> mycname = coursedetails.get("cname");
ArrayList<String> mycid = coursedetails.get("cid");
%>

<%//System.out.println(mycname.size());  %>
<form action="PreAddTAInfoServlet" method="post">
	<h2>Course Details: </h2>
	<%for(int i=0;i<mycname.size();i++){ %>
	<input type="radio" name="mycourse" value="<%=mycid.get(i) %>"> <%=mycid.get(i) %> <%=mycname.get(i) %> <a href="StudentEnrollCourseServlet?cname=<%=mycname.get(i)%>">Enroll</a><br><br>
	<%} %>
	<input type="submit" value="View Details!">
	</form>
</div>
<div><jsp:include page="footer.jsp" /></div>

</body>
</html>