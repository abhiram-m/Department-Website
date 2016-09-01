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
import javax.servlet.http.HttpSession;

import seterm.dao.Coursesdao;

/**
 * Servlet implementation class AddMyTeachingCourseServlet
 */
@WebServlet("/AddMyTeachingCourseServlet")
public class AddMyTeachingCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMyTeachingCourseServlet() {
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
		
		String cid = (String)request.getParameter("allcourse");
		HttpSession session = request.getSession();
		String netid = (String) session.getAttribute("netid");
		Coursesdao c = new Coursesdao();
		int count =c.saveMyCourse(cid, netid);
		if(count>0){
			Coursesdao cdao = new Coursesdao();
			LinkedHashMap<String, ArrayList> coursedetails = cdao.getAllCoursesNameandId();
			//System.out.println("DISP");
			request.setAttribute("coursedetails", coursedetails);
			request.setAttribute("addcoursesuccess", "Course Addition Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("addorviewcourses.jsp");
		    rd.forward(request,response);
		}else{
			Coursesdao cdao = new Coursesdao();
			LinkedHashMap<String, ArrayList> coursedetails = cdao.getAllCoursesNameandId();
			//System.out.println("DISP");
			request.setAttribute("coursedetails", coursedetails);
			request.setAttribute("addcourseerror", "Course Addition Not Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("addorviewcourses.jsp");
		    rd.forward(request,response);
		}
	}

}
