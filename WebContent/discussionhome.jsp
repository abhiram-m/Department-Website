<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<title>Discussion Board</title>
</head>
<body>


<div><jsp:include page="menu.jsp" /></div>

<div>
<ul class="sideul">
  <li class="sideli"><a href="#">Add New topic</a></li>
</ul>
</div>

<div align="center">
<h3>Discussion Topics</h3>
<form action="" method="post">
<input type="text" name="discussiontopic"/>
<input type="submit" value="Add Topic!"> 
</form>
<p><a href="discussiontopics.jsp">Topic 1</a></p>
</div>
<div><jsp:include page="footer.jsp" /></div>
</body>
</html>