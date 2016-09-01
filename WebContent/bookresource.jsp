<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page  import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<title>Reserve Resource</title>
</head>
<%if(!session.getAttribute("role").equals("Student")){ %>
<div><jsp:include page="menu.jsp" /></div>
<%}else{ %>
<div><jsp:include page="smenu.jsp" /></div>
<%} %>
<body>
<%


Map<String, ArrayList> reservations = (Map)request.getAttribute("reservations");
ArrayList<String> timeslots = reservations.get("timeslots");
ArrayList names = reservations.get("names");


Map<String, ArrayList> someresources = (Map)request.getAttribute("someresources");
ArrayList sometype = someresources.get("rtype");
ArrayList someinfo = someresources.get("rinfo");

String currname = (String)request.getAttribute("resourcename");
String date = (String)request.getAttribute("resourcedate");


ArrayList defaulttimes = new ArrayList();
defaulttimes.add("8am-9am");
defaulttimes.add("9am-10am");
defaulttimes.add("10am-11am");
defaulttimes.add("11am-12pm");
defaulttimes.add("12pm-1pm");
defaulttimes.add("1pm-2pm");
defaulttimes.add("2pm-3pm");



%>
<div>
<%String role = (String)session.getAttribute("role"); %>
<ul class="sideul">
<%if(role.equals("Staff")){ %>
  <li class="sideli"><a href="addresource.jsp">Add Resource</a></li>
   <%} %>
  <li class="sideli"><a href="ShowAllResourcesServlet">Reserve a resource</a></li>
  
  <li class="sideli"><a href="MyResourcesServlet">Cancel a resource</a></li>
</ul>
</div>
<div align="center">
<p>Current Resource is <%=currname %> for Date <%=date %></p>
<p>Resource type: <%= sometype.get(0) %> and Info is: <%=someinfo.get(0) %></p>
<div style="color: green;">${addslotsuccess}</div>
<div style="color: red;">${addsloterror}</div>
<form action="ReserveResourceServlet" method="post">
<%int j=-1; %>

<%for(int i=0;i<defaulttimes.size();i++){%>

	<%
		
	if(timeslots.contains(defaulttimes.get(i))){
		
		j++;%>
	
	<p style="color: red;"><%=defaulttimes.get(i)%> ---- Reserved by: <%=names.get(j) %></p>
	
	<%}else{ %>
	
	<p><input type="radio" name="slot" value="<%=defaulttimes.get(i)%>"><%=defaulttimes.get(i)%></p>
	<%}%>
	
<%}	%>


<input type="hidden" name="resname" value="<%=currname %>"/>
<input type="hidden" name="resdate" value="<%= date%>"/>

<input type="submit" value="Reserve!"/>
</form>
</div>
<div><jsp:include page="footer.jsp" /></div>
</body>
</html>