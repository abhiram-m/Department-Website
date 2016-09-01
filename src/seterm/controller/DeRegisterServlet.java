package seterm.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seterm.dao.Coursesdao;

/**
 * Servlet implementation class DeRegisterServlet
 */
@WebServlet("/DeRegisterServlet")
public class DeRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String cname = (String)request.getParameter("cname");
		Coursesdao c = new Coursesdao();
		int i = c.deRegister(cname, (String)request.getSession().getAttribute("netid"));
		if(i>0){
			request.setAttribute("addcoursesuccess", "Course De Register Successful!");
			Coursesdao c1 = new Coursesdao();
			ArrayList<String> cnames = c1.getMyEnrolledCourses((String)request.getSession().getAttribute("netid"));
			request.setAttribute("cnames", cnames);
			RequestDispatcher rd=request.getRequestDispatcher("status.jsp");
		    rd.forward(request,response);
		}else{
			Coursesdao c1 = new Coursesdao();
			ArrayList<String> cnames = c1.getMyEnrolledCourses((String)request.getSession().getAttribute("netid"));
			request.setAttribute("cnames", cnames);
			request.setAttribute("addcourseerror", "Course De Register Not Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("status.jsp");
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
