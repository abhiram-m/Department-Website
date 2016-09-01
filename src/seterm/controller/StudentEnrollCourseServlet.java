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

import seterm.dao.Coursesdao;

/**
 * Servlet implementation class StudentEnrollCourseServlet
 */
@WebServlet("/StudentEnrollCourseServlet")
public class StudentEnrollCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentEnrollCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String cname = request.getParameter("cname");
		Coursesdao c =  new Coursesdao();
		int count =c.enrollCourse(cname, (String)request.getSession().getAttribute("netid"));
		Coursesdao cdao = new Coursesdao();
		LinkedHashMap<String, ArrayList> coursedetails = cdao.getAllCoursesNameandId();
		request.setAttribute("coursedetails", coursedetails);
		if(count>0){
			
			request.setAttribute("addcoursesuccess", "Course Addition Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("studentviewcourse.jsp");
		    rd.forward(request,response);
		}else{
			request.setAttribute("addcourseerror", "Course Addition Not Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("studentviewcourse.jsp");
		    rd.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
