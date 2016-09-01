package seterm.controller;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seterm.dao.PhdStudentsdao;

/**
 * Servlet implementation class AddPhdStudentServlet
 */
@WebServlet("/AddPhdStudentServlet")
public class AddPhdStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPhdStudentServlet() {
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
		String phdsemester = request.getParameter("phdsemester");
		String phdcandidate = request.getParameter("phdcandidate");
		String studentselected = request.getParameter("studentselected");
		
		PhdStudentsdao p = new PhdStudentsdao();
		
		
		 request.setAttribute("studentselected", studentselected);
			
		
		
		if(phdsemester==""||phdcandidate==""){
			 LinkedHashMap phdstudentinfo = p.getOnePhdStudents(studentselected);
			 request.setAttribute("phdstudentinfo", phdstudentinfo);
			request.setAttribute("addphderror", "Please fill all details!");
			RequestDispatcher rd=request.getRequestDispatcher("vieworaddphdinfo.jsp");
		    rd.forward(request,response);
		    return;
		}
		
		
		int count = p.savePhdInfo(studentselected, phdcandidate, phdsemester);
		if(count>0){
			 LinkedHashMap phdstudentinfo = p.getOnePhdStudents(studentselected);
			 request.setAttribute("phdstudentinfo", phdstudentinfo);
			request.setAttribute("addphdsuccess", "PhD Info Addition Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("vieworaddphdinfo.jsp");
		    rd.forward(request,response);
		}else{
			 LinkedHashMap phdstudentinfo = p.getOnePhdStudents(studentselected);
			 request.setAttribute("phdstudentinfo", phdstudentinfo);
			request.setAttribute("addphderror", "PhD Info Addition Not Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("vieworaddphdinfo.jsp");
		    rd.forward(request,response);
		}
		
	}

}
