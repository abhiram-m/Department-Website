<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<!-- jQuery -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <!-- jQuery -->
<title>Add Exam</title>
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

<div align="center">
<br>
<div style="color: red;">${addexamerror}</div>
<div style="color: green;">${addexamsuccess}</div>
<form action="AddExamServlet" method="post">
<h3>Please fill the details below:</h3>
<table>
   <tr>
   <td>Exam Name: </td><td> <input type="text" class="form-control" name="examname" required></td>
 
  </tr>
  <tr>
 <td>Date: </td>
  <td>  <input type="text" class="form-control" name="examdate" id="datepicker"></td>
 </tr>
  <tr>
 <td> Other Info: </td>
  <td>  <input type="text" class="form-control" name="examinfo" required></td>
  </tr>
  </table>
<input type="submit" value="Add Exam!">
</form>
</div>
<div><jsp:include page="footer.jsp" /></div>
</body>
<script>
  $(function() {
    $( "#datepicker" ).datepicker();
  });
 </script>
</html>