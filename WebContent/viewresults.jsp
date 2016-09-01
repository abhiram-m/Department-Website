<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page  import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<title>Result</title>
</head>
<%if(!session.getAttribute("role").equals("Student")){ %>
<div><jsp:include page="menu.jsp" /></div>
<%}else{ %>
<div><jsp:include page="smenu.jsp" /></div>
<%} %>

<body>
<% Map<String, ArrayList> examdetails = (Map)request.getAttribute("examdetails");
ArrayList<String> ename = examdetails.get("ename");
ArrayList<Integer> eid = examdetails.get("eid");
ArrayList<String> einfo = examdetails.get("einfo");
%>

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

<div align="center"><br>
<div style="color: red;">${addcourseerror}</div>
<div style="color: green;">${addcoursesuccess}</div>
<h3>Exam Results: </h3>
<%String[] info = einfo.get(0).split(";"); 
%>

<table>
<tr>
<td  align="center"><b>Student ID</b></td>
<td  align="center"><b>Result</b></td>
</tr>


<%for(int i=0;i<info.length;i++){%>
<tr>
<td  align="center"><%=(info[i].split(",")[0]).split(":")[1] %></td>
<td  align="center"><%=(info[i].split(",")[1]).split(":")[1] %></td>




<%} %>
<%if(session.getAttribute("role").equals("Faculty")){ %>
<td  align="center"><a href="DeleteExamResultServlet?id=<%=eid.get(0)%>">Delete!</a></td>
<%} %>
</tr>
</table>

<br>
<%if(!session.getAttribute("role").equals("Student")){ %>

Update Result:
<form action="EditExamResultServlet" method="post">	
	<input type="hidden" value="<%=eid.get(0) %>" name="eid">
<table>

 <td>Results:<i>(Student id: id, Result: result); </i> </td>
  <td>  <textarea  class="form-control" name="examresult" placeholder="(Student id: id, Result: result);"></textarea></td>
 </tr>
  </table>
  <input type="submit" value="Add Result!">
</form>
<%} %>

</div>

<div><jsp:include page="footer.jsp" /></div>

</body>
</html>