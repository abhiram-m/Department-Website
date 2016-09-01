<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page  import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<title>Alumni</title>
</head>
<%if(!session.getAttribute("role").equals("Student")){ %>
<div><jsp:include page="menu.jsp" /></div>
<%}else{ %>
<div><jsp:include page="smenu.jsp" /></div>
<%} %>


<div>
<ul class="sideul">

  <li class="sideli"><a href="addalumni.jsp">Add Alumni</a></li>
<li class="sideli"><a href="ViewAlumniServlet">View Alumni</a></li>
</ul>
</div>
<body>

<div align="center"><br>
<div style="color: red;">${error}</div>
<form action="PreAddAlumniInfoServlet" method="post">
<%Map<String, ArrayList> alumni = (Map)request.getAttribute("alumni");%>
<%//if(alumni!=null){
ArrayList<String> netid = alumni.get("netid");
ArrayList<String> fname = alumni.get("fname");
ArrayList<String> lname = alumni.get("lname");
%>
	<h2>Students List: </h2>
	<%for(int i=0;i<netid.size();i++){ %>
<input type="radio" name="alumniid" value="<%=netid.get(i) %>"> <%=fname.get(i) %> <%=lname.get(i) %><br><br>
<%} %>
<input type="submit" value="Add Details!">
	<!-- <a href="vieworaddphdinfo.jsp">PhD Student 1</a> -->
	</form>
</div>
<%//} %>
<div><jsp:include page="footer.jsp" /></div>
</body>
</html>