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
 * Servlet implementation class DisplayCourseServlet
 */
@WebServlet("/DisplayCourseServlet")
public class DisplayCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Coursesdao cdao = new Coursesdao();
		LinkedHashMap<String, ArrayList> coursedetails = cdao.getAllCoursesNameandId();
		//System.out.println("DISP");
		if(request.getSession().getAttribute("role").equals("Student")){
			request.setAttribute("coursedetails", coursedetails);
			RequestDispatcher rd=request.getRequestDispatcher("studentviewcourse.jsp");
		    rd.forward(request,response);
		}else{
		request.setAttribute("coursedetails", coursedetails);
		RequestDispatcher rd=request.getRequestDispatcher("addorviewcourses.jsp");
	    rd.forward(request,response);
	}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
