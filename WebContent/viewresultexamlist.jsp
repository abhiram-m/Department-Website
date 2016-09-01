<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page  import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<title>Exam List</title>
</head>
<body>
<%
ArrayList<String> ename  = new ArrayList<String>();
ArrayList<Integer> eid  = new ArrayList<Integer>();
ArrayList<String> einfo  = new ArrayList<String>();
if(!session.getAttribute("role").equals("Student")){
Map<String, ArrayList> examdetails = (Map)request.getAttribute("examdetails");
 ename = examdetails.get("ename");
 eid = examdetails.get("eid");
 einfo = examdetails.get("einfo");
}else{
	Map<String, ArrayList> examdetails = (Map)request.getAttribute("apply");
	 ename = examdetails.get("name");
	 eid = examdetails.get("id");
	
}
%>
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


<div align="center">
<div style="color: green;">${addcoursesuccess}</div>
<h3>Exams List: </h3>

<%for(int i=0;i<ename.size();i++){ %>
<p>
<a href="DisplayExamResultServlet?examid=<%=ename.get(i)%>"><%=ename.get(i) %></a></p>
<%} %>


</div>
<div><jsp:include page="footer.jsp" /></div>
</body>
</html>