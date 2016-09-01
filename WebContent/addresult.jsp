<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page  import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<title>Add Result</title>
</head>
<body>
<div><jsp:include page="menu.jsp" /></div>

<div>
<ul class="sideul">
  <li class="sideli"><a href="addexam.jsp">Add Exam</a></li>
  <li class="sideli"><a href="ViewExamServlet">View Exam</a></li>
  
  <li class="sideli"><a href="PreAddExamServlet">Add Exam Result</a></li>
  
  <li class="sideli"><a href="ViewResultsListServlet">View Exam Result</a></li>
  
</ul>
</div>
<%Map<String, ArrayList> examdetails = (Map)request.getAttribute("examdetails"); 
ArrayList<String> ename = examdetails.get("ename");
ArrayList<Integer> eid = examdetails.get("eid");
ArrayList<String> edate = examdetails.get("edate");
ArrayList<String> einfo = examdetails.get("einfo");


%>
<div align="center">
<div style="color: red;">${addexamerror}</div>
<div style="color: green;">${addexamsuccess}</div>
<h3>Please fill the details below:</h3>
<form action="AddExamResultsServlet" method="post">
<table>
	 <tr>
   <td>Exam Name*: </td><td> <select class="form-control" name="examnameresult1" id="Exam" >
    <option selected="selected">Select Exam...</option>
    <%for(int i=0;i<ename.size();i++){ %>
  <option value="<%=eid.get(i)+":"+ename.get(i)%>"><%=eid.get(i)+":"+ename.get(i)%></option>
 
 <%} %>
</select></td> </tr>
	
	 
	 <tr>
   
 
  </tr>
	
	
   <tr>
   <td>Other Exam Name: </td><td> <input type="text" class="form-control" name="examnameresult2"></td>
 
  </tr>
  <tr>
 <td>Results*: <i>(Student id: id, Result: result); </i></td>
  <td>  <textarea  class="form-control" name="examresult" placeholder="Student id: id, Result: result" ></textarea></td>
 </tr>
  </table>
  <input type="submit" value="Add Result!">
  </form>
</div>
<div><jsp:include page="footer.jsp" /></div>
</body>
</html>