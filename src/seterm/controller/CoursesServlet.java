package seterm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import seterm.dao.Coursesdao;

/**
 * Servlet implementation class CoursesServlet
 */
@WebServlet("/CoursesServlet")
public class CoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CoursesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String coursename = request.getParameter("coursename");
		String courseid = request.getParameter("courseid");
		
		HttpSession session = request.getSession();
		String netid = (String) session.getAttribute("netid");
		Coursesdao c = new Coursesdao();
		if(coursename==""||courseid==""){
			request.setAttribute("addcourseerror", "Please fill all fields!");
			RequestDispatcher rd=request.getRequestDispatcher("addcourses.jsp");
		    rd.forward(request,response);
		    return;
		}
		int count = c.saveCourseinfo(coursename, courseid);
		if(count>0){
			request.setAttribute("addcoursesuccess", "Course Addition Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("addcourses.jsp");
		    rd.forward(request,response);
		}else{
			request.setAttribute("addcourseerror", "Course Addition Not Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("addcourses.jsp");
		    rd.forward(request,response);
		}
	}

}
