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
import seterm.dao.PhdStudentsdao;

/**
 * Servlet implementation class PreAddPhdStudentStatusServlet
 */
@WebServlet("/PreAddPhdStudentStatusServlet")
public class PreAddPhdStudentStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreAddPhdStudentStatusServlet() {
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
		
		String studentselected = request.getParameter("phdstudent");
		
		PhdStudentsdao p = new PhdStudentsdao();
	    LinkedHashMap phdstudentinfo = p.getOnePhdStudents(studentselected);
	    
		request.setAttribute("studentselected", studentselected);
		request.setAttribute("phdstudentinfo", phdstudentinfo);
		RequestDispatcher rd=request.getRequestDispatcher("vieworaddphdinfo.jsp");
	    rd.forward(request,response);
	}

}
