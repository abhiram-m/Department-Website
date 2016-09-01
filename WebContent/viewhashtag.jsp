<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   <%@ page  import = "java.util.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="css/sidebar.css">
<title>View Topics</title>
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
  <li class="sideli"><a href="createhashtag.jsp">Add New topic</a></li>
 
   <li class="sideli"><a href="DiscussionDeleteServlet">Delete a topic</a></li><%} %>
</ul>
</div>

<div align="center">
	<form action="newview" method="get" id="myform">
		<%ServletContext context = request.getSession().getServletContext();
		String currHashtag = (String) context.getAttribute("hash"); %>
		<p>Current Topic: <%=currHashtag %></p>
		<!-- <div>${hash}</div><br> -->
		<div style="color: red;">${errpost}</div><br>
		<div style="color: red;">${errpostblank}</div><br>
		<h3><label for="postnew">Create new post</label></h3><br>
		<textarea rows="4" cols="50" name="newpost" id="postnew"></textarea>
		<input type="submit" name="action" class="btn btn-primary" value="post"/>
		
		<%
				
				
				Map<String, ArrayList> p = (Map) request.getAttribute("m");
				
				ArrayList nindex = p.get("nindex");
				ArrayList pindex = p.get("pindex");
				ArrayList content = p.get("content");
				ArrayList pid = p.get("pid");
				ArrayList id = p.get("id");
				String mainpost ="";
				String primaryid="";
				
			%><p>Recent Posts:</p><%
			String abc="abc";
			for (int counter = 0; counter < pindex.size(); counter++) {
	        if (nindex.contains(pindex.get(counter))) {
	        	System.out.println(pindex.get(counter));
	        	primaryid = (String) (id.get((Integer) pindex.get(counter)));
	        	
	        	 mainpost = (String) (content.get((Integer) pindex.get(counter)));%> 
	        
	        
	         <form action="newview" method="get">
	        <h3> <input type="radio" name="replyidtodelete" value="<%=mainpost%>"><%out.println(mainpost);%></h3>
	       <%if(!session.getAttribute("role").equals("Student")){ %>  <input type="submit" name="action" value='Delete'></form><%} %><br>
	        
				 <form action="newview" method="get">
				 
				
				<label for="repynew">Reply</label><br>
				
				<input name="replynew"  id="repynew">
				
				<input name="replyposts" type="hidden" value="<%=primaryid %>" >
		<input type="submit" name="action" class="btn btn-primary" value="reply"/><br>
				
				 </form> 
				 	 
				 <% }else{primaryid="abcdefghijklmnopqrstuvwxyzqwerty";}
				

				//String abc="abc";
				%>
			
			
				<% 	for (int c = 0; c < pid.size(); c++) {
	    			
	    			if(pid.get(c).equals(primaryid)){%>
	    			<form action="DeleteDiscussionServlet" method="post">
	    			<input type="radio" name="replyidtodelete" value="<%=content.get(c)%>"><%	  out.println(content.get(c));%>
	    			<%if(!session.getAttribute("role").equals("Student")){ %>	<input type="submit" value='Delete'><%} %>
			</form>
	    				
	    				<br><%
						
								
					}
				}%>
				
	       <% }
	    
				 %>
				
				  
	</form>
	
	
</div>
<div><jsp:include page="footer.jsp" /></div>
</body>

<script type="text/javascript">


</script>
</html>