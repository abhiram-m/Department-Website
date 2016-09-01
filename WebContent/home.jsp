<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
html{
    background-image:url("css/homeimage.jpg");
    background-repeat: no-repeat;
	background-size: cover;    
}

</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<jsp:include page="menu.jsp" />
<body >
<h3>Welcome: <%=session.getAttribute("username") %>!</h3>
<div><jsp:include page="footer.jsp" /></div>
</body>
</html>