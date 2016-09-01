package seterm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seterm.dao.User;

/**
 * Servlet implementation class UpdateProfileServlet
 */
@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String advisor = request.getParameter("advisor");
		
		if(advisor==""){
			advisor = "none";
		}
		
		String netid = (String)request.getSession().getAttribute("netid");
		if(firstname==""||lastname==""||password==""){
			User u1 = new User();
			LinkedHashMap<String, ArrayList> user = u1.getOneUser(netid);
			request.setAttribute("user", user);
			request.setAttribute("addcourseerror", "Profile uppdate Not Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("profile.jsp");
		    rd.forward(request,response);
		}
		
		
		User u = new User();
		
		int count =u.updateUserinfo(password,firstname,lastname,netid,email,phone,advisor);
		
		if(count>0){
			User u1 = new User();
			LinkedHashMap<String, ArrayList> user = u1.getOneUser(netid);
			request.setAttribute("user", user);
			request.setAttribute("addcoursesuccess", "Profile uppdate Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("profile.jsp");
		    rd.forward(request,response);
		}else{
			User u1 = new User();
			LinkedHashMap<String, ArrayList> user = u1.getOneUser(netid);
			request.setAttribute("user", user);
			request.setAttribute("addcourseerror", "Profile uppdate Not Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("profile.jsp");
		    rd.forward(request,response);
		}
	}

}
