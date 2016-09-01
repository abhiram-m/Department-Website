<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page  import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<title>Insert title here</title>
</head>
<%if(!session.getAttribute("role").equals("Student")){ %>
<div><jsp:include page="menu.jsp" /></div>
<%}else{ %>
<div><jsp:include page="smenu.jsp" /></div>
<%} %>

<div>
<ul class="sideul">
</ul>

</div>
<body>

<%Map<String, ArrayList> users = (Map)request.getAttribute("users");
ArrayList<String> fname = users.get("fname");
ArrayList<String> lname = users.get("lname");
ArrayList<String> email = users.get("email");
%>
<div align="center"><br>
<table>

<tr>
<td><b>First Name</b></td><td><b>Last Name</b></td><td><b>Email</b></td>
</tr>
<%for(int i=0;i<fname.size();i++){ %>
<tr>
<td><%=fname.get(i) %></td><td><%=lname.get(i) %></td><td><a href="mailto:<%= email.get(i)%>"><%=email.get(i) %></a></td>
</tr>
<%} %>


</table>
</div>
</body>
</html>