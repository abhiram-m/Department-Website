<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page  import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<title>Jobs</title>
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
<h3>Add Job:</h3>
<form action="AddJobsServlet" method="post">

<div style="color: green;">${announcementsuccess}</div>
  <div style="color: red;">${announcementerror}</div>
	<textarea name="job"></textarea><br><br>
	Job Link/email: <input type="text" name="link"/>
	
	<input type="submit" value="Add Job!">
</form>
<%} %>
<br>
<div style="color: red;">${addcourseerror}</div>
<div style="color: green;">${addcoursesuccess}</div>
<h3>Jobs:</h3>
<% Map<String, ArrayList> newsannouncements = (Map) request.getAttribute("jobannouncements");
	ArrayList<String> newsdetails = new ArrayList<String>();
	ArrayList<String> newstype = new ArrayList<String>();
	ArrayList<String> newsnetid = new ArrayList<String>();
	ArrayList<String> newsaid = new ArrayList<String>();
	ArrayList<String> newslinks = new ArrayList<String>();
	
	newsdetails = newsannouncements.get("newsdetails");
	newstype =newsannouncements.get("newstype");
	newsnetid =newsannouncements.get("newsnetid");
	newsaid = newsannouncements.get("newsaid");
	newslinks = newsannouncements.get("newslinks");
	%>
	<form action="DeleteAnnouncementsServlet" method="post">
	<%for(int i=0;i<newsdetails.size();i++){ %>
	
	
	<%if(newsnetid.get(i).equals(session.getAttribute("netid"))){ %>
		<p><input type="radio" name="delevent" value="<%=newsaid.get(i) %>"> <%=newsdetails.get(i)%>&nbsp &nbsp <a href="PreEditAnnouncementServlet?delevent=<%=newsaid.get(i) %>">Edit</a></p>
	<%}else{ %>
		<p><%=newsdetails.get(i)%></p>
	
	<%} %>
	<%if(!newslinks.get(i).contains("@")){ %>
	<p>Details Here: <a target="blank" href="http://<%=newslinks.get(i) %>"><%= newslinks.get(i) %></a></p>
	<%}else{ %>
	
	<p>Email: <a target="blank" href="mailto:<%=newslinks.get(i) %>"><%= newslinks.get(i) %></a></p>
	<%} %>
	<%if(session.getAttribute("role").equals("Student")){ %>
	<a href="ApplyJobsServlet?jobidapply=<%=newsaid.get(i) %>">Click Here to Apply</a>
	<%} %><br>
	<hr>
	<%} %>
	<%if(!session.getAttribute("role").equals("Student")){ %>
	<input type="submit" value="Delete!"><%} %>
	</form>
	</div>
	<div><jsp:include page="footer.jsp" /></div>
</body>
</html>