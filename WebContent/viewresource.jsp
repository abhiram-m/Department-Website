<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page  import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">

<title>Resources</title>
</head>
<body>

<%if(!session.getAttribute("role").equals("Student")){ %>
<div><jsp:include page="menu.jsp" /></div>
<%}else{ %>
<div><jsp:include page="smenu.jsp" /></div>
<%} %>

<div>
<ul class="sideul">
<%String role = (String)session.getAttribute("role"); %>
<%if(role.equals("Staff")){ %>
  <li class="sideli"><a href="addresource.jsp">Add Resource</a></li>
   <%} %>
  <li class="sideli"><a href="ShowAllResourcesServlet">Reserve a resource</a></li>
  <li class="sideli"><a href="MyResourcesServlet">Cancel a resource</a></li>
</ul>
</div>

<%

Map<String, ArrayList> resources = (Map)request.getAttribute("resources");
ArrayList<String> rname = new ArrayList<String>();
ArrayList<String> rdate = new ArrayList<String>();
ArrayList<String> rtime = new ArrayList<String>();
rname=resources.get("rname");
rtime = resources.get("rtime");
rdate = resources.get("rdate");

%>
<div align="center">
<div style="color: green;">${cancelsuccess}</div>
<div style="color: red;">${cancelerror}</div>
<form id="myFormID" action="CancelResourceServlet" method="post" onsubmit="return confirm('Do you really want to cancel?');">
	<h2>Resources Booked: </h2>
	<table>
	 <%for(int i=0;i<rname.size();i++){ String value= rname.get(i)+"@"+rtime.get(i)+"@"+rdate.get(i); %>
	<tr>
	<td><input type="radio" name="cancelresname" value="<%=value%>" style="padding-right:30px;">You Booked <%=rname.get(i)%> on <%=rdate.get(i) %> at <%= rtime.get(i)%> </td><td></td>
	</tr>
	<%} %>
	
	</table>
	<input type="submit" value="Cancel!">
</form>
</div>
<div><jsp:include page="footer.jsp" /></div>
</body>

</html>