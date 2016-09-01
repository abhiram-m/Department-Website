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
<div><jsp:include page="smenu.jsp" /></div>
<div>
<ul class="sideul">

</ul>

</div>
<body>
<div align="center">
<div style="color: red;">${addcourseerror}</div>
<div style="color: green;">${addcoursesuccess}</div>
<%ArrayList<String> cnames = (ArrayList)request.getAttribute("cnames");
if(cnames.size()>0){
%>
<h3>Your Status - Courses Registered:</h3>
<%} %>
<%
if(cnames.size()==0){
%>
<h3>Your Status - Courses Registered:</h3>
<%} %>
<%for(int i=0;i<cnames.size();i++){ %>

<table>
<tr>
<td><%=cnames.get(i) %></td><td><a href="DeRegisterServlet?cname=<%=cnames.get(i)%>">De-Register</a></td>

</tr>


</table>

<%} %>

</div>
</body>
</html>