<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page  import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<title>PhD Students</title>
</head>
<body>

<div><jsp:include page="menu.jsp" /></div>


<div>
<ul class="sideul">
  <li class="sideli"><a href="ViewPhDStudentsServlet">View PhD students</a></li>

</ul>
</div>
<div align="center">
<form action="PreAddPhdStudentStatusServlet" method="post">
<%Map<String, ArrayList> phdstudents = (Map)request.getAttribute("phdstudents");
ArrayList<String> netid = phdstudents.get("netid");
ArrayList<String> fname = phdstudents.get("fname");
ArrayList<String> lname = phdstudents.get("lname");
%>
	<h2>Students List: </h2>
	<%for(int i=0;i<netid.size();i++){ %>
<input type="radio" name="phdstudent" value="<%=netid.get(i) %>"> <%=fname.get(i) %> <%=lname.get(i) %><br><br>
<%} %>
<input type="submit" value="Add Details!">
	<!-- <a href="vieworaddphdinfo.jsp">PhD Student 1</a> -->
	</form>
</div>
<div><jsp:include page="footer.jsp" /></div>
</body>
</html>