<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page  import = "java.util.*"%>
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
<title>Suggestions</title>
</head>
<div><jsp:include page="smenu.jsp" /></div>
<div>
<ul class="sideul">
</ul>
</div>
<body>
<div align="center">

<h3>Course Suggestions:</h3>
<%Map<String, ArrayList> m = (Map)request.getAttribute("suggestions"); 
ArrayList<String> majors = m.get("major");
%>
<form action="SuggestServlet" method="post">
Select Majors:  <select name="major" id="role">
    <option selected="selected">Select Major...</option>
     <%for(int i=0;i<majors.size();i++){ %>
  <option value="<%=majors.get(i)%>"><%=majors.get(i)%></option>
  <%} %>
  </select>
  <input type="submit">
</form>

<%ArrayList<String> cnames = (ArrayList)request.getAttribute("s");
if(cnames!=null){
%>
<h4><p>Suggested Courses:</p></h4>

<%for(int i =0;i<cnames.size();i++){ %>

	<p><%= cnames.get(i) %>	</p>

<%} %>
<%} %>
</div>
</body>
</html>