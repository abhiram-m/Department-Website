<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page  import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">

<title>Edit Announcement</title>
</head>
<body>
<div><jsp:include page="menu.jsp" /></div>

<div>
<ul class="sideul">
  <li class="sideli"><a href="ViewJobsServlet">Jobs</a></li>
  <li class="sideli"><a href="ViewNewsServlet">News</a></li>
   <li class="sideli"><a href="ViewEventsServlet">Events</a></li>
</ul>
</div>

<%Map<String, ArrayList> announcements = (Map)request.getAttribute("announcements");

ArrayList<String> details = announcements.get("details");
ArrayList<String> type = announcements.get("type");
ArrayList<String> aid = announcements.get("aid");
ArrayList<String> link = announcements.get("link");

%>
<div align="center">
<br>
<h3>Update Info:</h3>
<div style="color: red;">${addcourseerror}</div>
<div style="color: green;">${addcoursesuccess}</div>
<form action="EditAnnouncementsServlet" method="post">

Details: <input type="text" name="details" value="<%= details.get(0) %>"><br>
<%if(type.get(0).equals("job")) {%>
Links: <input type="text" name="links" value="<%= link.get(0) %>">
<%} %>
<br>
<input type="hidden" name="id" value="<%=aid.get(0)%>">
<input type="submit" value="Update!">
</form>
</div>
<div><jsp:include page="footer.jsp" /></div>
</body>
</html>