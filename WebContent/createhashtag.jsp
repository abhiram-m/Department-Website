<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<title>Create Topic</title>
</head>
<body>
<div><jsp:include page="menu.jsp" /></div>

<div>
<ul class="sideul">
  <li class="sideli"><a href="createhashtag.jsp">Add New topic</a></li>
   <li class="sideli"><a href="DiscussionDeleteServlet">Delete a topic</a></li>
</ul>
</div>
<div align="center">
  <h3>Create Topic</h3>
<form action="ch" method="get">
	 <div style="color: red;">${errcreate}</div><br>
	<label for="search">Create a Topic</label>
	<input id="search" type="text" name="newtagname"/>
	<input type="submit" class="btn btn-primary" value="create"/>
</form>
</div>
<div><jsp:include page="footer.jsp" /></div>
</body>
</html>