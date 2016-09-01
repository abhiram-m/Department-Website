<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page  import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<title>Events</title>
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
<%if(!session.getAttribute("role").equals("Student")){ %>
<h3>Events:</h3>

<form action="AddEventsServlet" method="post">
<div style="color: green;">${announcementsuccess}</div>
  <div style="color: red;">${announcementerror}</div>
	<textarea name="event"></textarea>
	<input type="submit" value="Add Event!">
</form>
<%} %>
<h3>Events:</h3>
	<% Map<String, ArrayList> newsannouncements = (Map) request.getAttribute("eventsannouncements");
	ArrayList<String> newsdetails = new ArrayList<String>();
	ArrayList<String> newstype = new ArrayList<String>();
	ArrayList<String> newsnetid = new ArrayList<String>();
	ArrayList<String> newsaid = new ArrayList<String>();
	newsdetails = newsannouncements.get("newsdetails");
	newstype =newsannouncements.get("newstype");
	newsnetid =newsannouncements.get("newsnetid");
	newsaid = newsannouncements.get("newsaid");
	
	%>
	<form action="DeleteAnnouncementsServlet" method="post">
	<%for(int i=0;i<newsdetails.size();i++){ %>
	
	
	<%if(newsnetid.get(i).equals(session.getAttribute("netid"))){ %>
		<p><input type="radio" name="delevent" value="<%=newsaid.get(i) %>"> <%=newsdetails.get(i)%>  &nbsp &nbsp <a href="PreEditAnnouncementServlet?delevent=<%=newsaid.get(i) %>">Edit</a></p>
	<%}else{ %>
		<p><%=newsdetails.get(i)%></p>
	
	<%} %>
	<%} %>
	<input type="submit" value="Delete!">
	</form>
	</div>
	<div><jsp:include page="footer.jsp" /></div>
</body>
</html>