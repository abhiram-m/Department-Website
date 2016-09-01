<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/sidebar.css">
  <%@ page  import = "java.util.*"%>
<!-- jQuery -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <!-- jQuery -->
<title>Reserve Resource</title>
</head>
<body>
<%if(!session.getAttribute("role").equals("Student")){ %>
<div><jsp:include page="menu.jsp" /></div>
<%}else{ %>
<div><jsp:include page="smenu.jsp" /></div>
<%} %>
<%

Map<String, ArrayList> resources = (Map)request.getAttribute("resources");
%>
<%if(resources!=null){ %>
<%
ArrayList<String> rname = new ArrayList<String>();
rname=resources.get("rname");



%>


<div>
<%String role = (String)session.getAttribute("role"); %>
<ul class="sideul">
<%if(role.equals("Staff")){ %>
  <li class="sideli"><a href="addresource.jsp">Add Resource</a></li>
   <%} %>
  <li class="sideli"><a href="ShowAllResourcesServlet">Reserve a resource</a></li>
  <li class="sideli"><a href="MyResourcesServlet">Cancel a resource</a></li>
</ul>
</div>
<div align="center">
<h3>Select a resource</h3>
<div style="color: red;">${error}</div>
<form id="myFormID" action="CheckAvailabilityServlet" method="post">
<table>
 <tr>
   <td>Resource Name:</td><td> 
  
   <select name="resourcename" id="role">
    <option selected="selected">Select Resource...</option>
     <%for(int i=0;i<rname.size();i++){ %>
  <option value="<%=rname.get(i)%>"><%=rname.get(i)%></option>
  <%} %>
</select></td> </tr>
	
	<tr>
 <td>Date: </td>
  <td>  <input type="text" class="form-control" name="resourcedate" id="datepicker"></td>
 </tr>

 </table>
 
 <!-- <input type="submit" value="Check Availability!"/> -->
 
</form>

<%} %>
</div>
<!-- CHANGES FROM bookresource -->

<%


Map<String, ArrayList> reservations = (Map)request.getAttribute("reservations");
Map<String, ArrayList> someresources = (Map)request.getAttribute("someresources");

%>
<%if(reservations!=null&&someresources!=null){ %>

<%
ArrayList<String> timeslots = reservations.get("timeslots");
ArrayList names = reservations.get("names");



ArrayList sometype = someresources.get("rtype");
ArrayList someinfo = someresources.get("rinfo");

String currname = (String)request.getAttribute("resourcename");
String date = (String)request.getAttribute("resourcedate");


ArrayList defaulttimes = new ArrayList();
defaulttimes.add("6am-7am");
defaulttimes.add("7am-8am");
defaulttimes.add("8am-9am");
defaulttimes.add("9am-10am");
defaulttimes.add("10am-11am");
defaulttimes.add("11am-12pm");
defaulttimes.add("12pm-1pm");
defaulttimes.add("1pm-2pm");
defaulttimes.add("2pm-3pm");
defaulttimes.add("3pm-4pm");
defaulttimes.add("4pm-5pm");
defaulttimes.add("5pm-6pm");
defaulttimes.add("6pm-7pm");
defaulttimes.add("7pm-8pm");
defaulttimes.add("8pm-9pm");
defaulttimes.add("8pm-10pm");
defaulttimes.add("10pm-11pm");
defaulttimes.add("11pm-12am");
%>


<div align="center">

<p>Current Resource is <%=currname %> for Date <%=date %></p>
<p>Resource type: <%= sometype.get(0) %> and Info is: <%=someinfo.get(0) %></p>
<div style="color: green;">${addslotsuccess}</div>
<div style="color: red;">${addsloterror}</div>
<form action="ReserveResourceServlet" method="post" onsubmit="return confirm('Do you really want to reserve?');">
<%int j=-1; %>


<%for(int i=0;i<defaulttimes.size();i++){%>

	<%
		
	if(timeslots.contains(defaulttimes.get(i))){
		
		j++;%>
	
	<p style="color: red;"><%=defaulttimes.get(i)%> ---- Reserved by: <%=names.get(j) %></p>
	
	<%}else{ %>
	
	<p><input type="radio" name="slot" value="<%=defaulttimes.get(i)%>"><%=defaulttimes.get(i)%><span><input type="submit" value="Reserve!"/></span></p>
	<%}%>
	
<%}	%>


<input type="hidden" name="resname" value="<%=currname %>"/>
<input type="hidden" name="resdate" value="<%= date%>"/>


</form>
</div>
<%} %>

</body>

<script type="text/javascript">

$('#datepicker').datepicker({
    inline : true,
    minDate: 0,
    onSelect : function(){
        $('#myFormID').submit();   
    }
});



  
 </script>
 
 <style type="text/css">



.column {
    float: left;
    margin: 0;
    width: 40%;
}
 
 
 </style>
</html>