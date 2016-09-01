<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page  import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<title>PhD Student Info</title>
</head>
<body>
<div><jsp:include page="menu.jsp" /></div>
<div>
<ul class="sideul">
  <li class="sideli"><a href="ViewPhDStudentsServlet">View PhD students</a></li>

</ul>
</div>
<%String studentselected = (String) request.getAttribute("studentselected");
Map<String, ArrayList> phdstudentinfo = (Map) request.getAttribute("phdstudentinfo");
ArrayList<String> fname = phdstudentinfo.get("fname");
ArrayList<String> candidate = phdstudentinfo.get("candidate");
ArrayList<String> semester = phdstudentinfo.get("semester"); %>

<div align="center">
<h3>Information of <%=fname.get(0) %>: </h3>
<p>Semester:  <%=semester.get(0) %></p>
<p>Candidate: <%=candidate.get(0) %></p>
</div>

<div align="center">
<h3>Add/Update Information: </h3>

<form action="AddPhdStudentServlet" method="post">
<div style="color: green;">${addphdsuccess}</div>
<div style="color: red;">${addphderror}</div>
<input type="hidden" name = "studentselected" value="<%=studentselected %>">
<table>

   <tr>
   <td>Semester: </td><td> <input type="text" class="form-control" name="phdsemester"></td>
 
  </tr>
  <tr>
 <td>Candidate: </td>
  <td>  <input type="text" class="form-control" name="phdcandidate"></td>
 </tr>
 </table>
  <input type="submit" value="Add/Update Info!">
  </form>
 </div>
 <div><jsp:include page="footer.jsp" /></div>
</body>

</html>