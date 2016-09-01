package seterm.controller;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seterm.dao.Coursesdao;

/**
 * Servlet implementation class AddTAInfoServlet
 */
@WebServlet("/AddTAInfoServlet")
public class AddTAInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTAInfoServlet() {
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
		String ohours = request.getParameter("ohours");
		String TAInfo = request.getParameter("ta");
		String syllabus = request.getParameter("syllabus");
		String mycid = request.getParameter("mycid");
		
		Coursesdao c = new Coursesdao();
		request.setAttribute("mycid",mycid);
		
		
		if(ohours==""||TAInfo==""||syllabus==""){
			 LinkedHashMap myofficehours = c.getMyOfficehours(mycid);
				request.setAttribute("myofficehours", myofficehours);
			request.setAttribute("addtaerror", "Please fill all details!");
			RequestDispatcher rd=request.getRequestDispatcher("addofficehours.jsp");
		    rd.forward(request,response);
		    return;
		}
	   
		int count = c.saveCourseTAinfo(mycid, ohours, TAInfo, syllabus);
		 LinkedHashMap myofficehours = c.getMyOfficehours(mycid);
			request.setAttribute("myofficehours", myofficehours);
		if(count>0){
			
			request.setAttribute("addtasuccess", "Course Info Addition Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("addofficehours.jsp");
		    rd.forward(request,response);
		}else{
			request.setAttribute("addtaerror", "Course Info Addition Not Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("addofficehours.jsp");
		    rd.forward(request,response);
		}
	}

}
