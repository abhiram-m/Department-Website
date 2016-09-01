<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jQuery -->
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <!-- jQuery -->
<title>Registration</title>
</head>
<body>
<h2>Registration: </h2>
<form action="RegistrationServlet" method="post">
	 <div style="color: red;">${registerfail}</div><br>
  <table>
   <tr>
   <td>First Name: </td><td> <input type="text" class="form-control" name="fname"></td>
 
  </tr>
  <tr>
 <td>Last Name: </td>
  <td>  <input type="text" class="form-control" name="lname"></td>
 </tr>
  <tr>
 <td> NET ID: </td>
  <td>  <input type="text" class="form-control" name="netid"></td>
  </tr>
  <tr>
  <td>Password: </td>
  <td>  <input type="password" class="form-control" name="password"></td>
   </tr> 
   
   <tr>
   <td>Role:</td><td> <select name="role" id="Student">

  <option selected="selected" value="Student">Student</option>
 
</select></td> </tr>
 
 </table>
 
  <div id="autoUpdate">
  
  <table>
  
  
 
 <tr>
   <td>Year of Joining: </td> <td><select name="joinyear">
   <option selected="selected">Select Year...</option>
  <option value="1990">1990</option>
  <option value="1991">1991</option>
  <option value="1992">1992</option>
  <option value="1993">1993</option>
  <option value="1994">1994</option>
  <option value="1995">1995</option>
  <option value="1996">1996</option>
  <option value="1997">1997</option>
  <option value="1998">1998</option>
  <option value="1999">1999</option>
  <option value="2000">2000</option>
  <option value="2001">2001</option>
  <option value="2002">2002</option>
  <option value="2003">2003</option>
  <option value="2004">2004</option>
  <option value="2005">2005</option>
  <option value="2006">2006</option>
  <option value="2007">2007</option>
  <option value="2008">2008</option>
  <option value="2009">2009</option>
  <option value="2010">2010</option>
  <option value="2011">2011</option>
  <option value="2012">2012</option>
  <option value="2013">2013</option>
  <option value="2014">2014</option>
  <option value="2015">2015</option>
  <option value="2016">2016</option>
  </select></td>
  </tr>
    
    <tr>
   <td>Program: </td> <td><select name="program">
   <option selected="selected">Select Program...</option>
  <option value="BA">BS</option>
  <option value="BA">BA</option>
  <option value="MS">MS</option>
  <option value="PhD">PhD</option>
  </select></td>
  </tr>
  <tr>
  <td>Major: </td>
  <td>  <input type="text" class="form-control" name="major"></td>
   </tr> 
    
    <tr>
  <td>Semester (PhD Only): </td>
  <td>  <input type="text" class="form-control" name="phdsem"></td>
   </tr> 
  </table>
 </div>
  <br>
  <input type="submit" value="Register!">
  
</form>

<div><jsp:include page="footer.jsp" /></div>
</body>


</html>