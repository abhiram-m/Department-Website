<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page  import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<title>View Topics List</title>
</head>
<body>
<div><jsp:include page="menu.jsp" /></div>

<div>
<ul class="sideul">
  <li class="sideli"><a href="createhashtag.jsp">Add New topic</a></li>
   <li class="sideli"><a href="DiscussionDeleteServlet">Delete a topic</a></li>
</ul>
</div>

 
  
  <%
  Map<String, ArrayList> hashtags = (Map)request.getAttribute("hashtags");
  ArrayList<String> names= new ArrayList<String>();
  ArrayList<String> netids= new ArrayList<String>();
  names = hashtags.get("names");
  netids = hashtags.get("netids");
  
  String currnetnetid = (String) session.getAttribute("netid");
 %>
 <div align="center">
  <h3>Delete Topics</h3>
<form action="DeleteHashtagServlet" method="get">
	<div style="color: green;">${successmsg}</div>
	 <div style="color: red;">${err}</div>
	<h4>List of Topics</h4>
	
	<%for(int i=0;i<names.size();i++){%>
		
		
	<p> <input type="radio" name="deletetagname" value="<%=names.get(i) %>"> <%=names.get(i) %></p>
	  
	 <%} %>
	<input type="submit" class="btn btn-primary" value="Delete!"/>
</form>
</div>
<div><jsp:include page="footer.jsp" /></div>
</body>
</html>