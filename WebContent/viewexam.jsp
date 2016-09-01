<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page  import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<title>Exams</title>
</head>
<body>
<%if(!session.getAttribute("role").equals("Student")){ %>
<div><jsp:include page="menu.jsp" /></div>
<%}else{ %>
<div><jsp:include page="smenu.jsp" /></div>
<%} %>

<div>
<ul class="sideul">
<%if(!session.getAttribute("role").equals("Student")){ %>
  <li class="sideli"><a href="addexam.jsp">Add Exam</a></li><%} %>
  <li class="sideli"><a href="ViewExamServlet">View Exams</a></li>
  <%if(!session.getAttribute("role").equals("Student")){ %>
  <li class="sideli"><a href="PreAddExamServlet">Add Exam Result</a></li><%} %>
  <%if(!session.getAttribute("role").equals("Student")){ %>
  <li class="sideli"><a href="ViewResultsListServlet">View Exam Result</a></li>
<%}else{ %>
 <li class="sideli"><a href="StudentExamResultsListServlet">View Exam Result</a></li>
<%} %>

</ul>
</div>

<%Map<String, ArrayList> examdetails = (Map)request.getAttribute("examdetails"); 
ArrayList<String> ename = examdetails.get("ename");
ArrayList<Integer> eid = examdetails.get("eid");
ArrayList<String> edate = examdetails.get("edate");
ArrayList<String> einfo = examdetails.get("einfo");
ArrayList<String> netid = examdetails.get("netid");

%>
<div align="center">
<div style="color: green;">${del}</div>
<div style="color: red;">${addcourseerror}</div>
<div style="color: green;">${addcoursesuccess}</div>
<form action="DeleteExamServlet" method="post">
<h3>Exams Available:</h3>
<table>
<tr><td><b>Exam Name </b>
	
	<td><b>Exam Date </b></td>
	
	<td><b>Exam Info </b></td>
	</tr>
	<%for(int i=0;i<ename.size();i++){ %>
	
	
	<tr>
	<td><%=ename.get(i) %></td>
	<td><%=edate.get(i) %></td>
	<td><%=einfo.get(i) %></td>
	<%if(!session.getAttribute("role").equals("Student")){ %>
	<%if(netid.get(i).equals(session.getAttribute("netid"))){ %>
	<td><a href="DeleteExamsServlet?id=<%=eid.get(i)%>">Delete</a></td>
	<%} }else{%>
	<td><a href="ApplyExamsServlet?id=<%=ename.get(i)%>">Register</a></td>
	<%} %>
	<%} %>
	</table>
	</form>
</div>
<div><jsp:include page="footer.jsp" /></div>
</body>
</html>