<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<title>Announcements</title>
</head>
<body>

<%if(!session.getAttribute("role").equals("Student")){ %>
<div><jsp:include page="menu.jsp" /></div>
<%}else{ %>
<div><jsp:include page="smenu.jsp" /></div>
<%} %>


<div>
<ul class="sideul">
  <li class="sideli"><a href="ViewJobsServlet">Jobs</a></li>
  <li class="sideli"><a href="ViewNewsServlet">News</a></li>
   <li class="sideli"><a href="ViewEventsServlet">Events</a></li>
</ul>
</div>
<div align="center">
<div style="color: green;">${announcementsuccess}</div><br>
  <div style="color: red;">${announcementerror}</div><br>
  <h4 align="center">This page can be used to access and post all the Jobs, Events and News.</h4>
 </div>
</body>
<div><jsp:include page="footer.jsp" /></div>
</html>