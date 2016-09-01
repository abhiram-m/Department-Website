package seterm.controller;

import java.io.IOException;
import java.util.LinkedHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seterm.dao.Alumnidao;
import seterm.dao.PhdStudentsdao;

/**
 * Servlet implementation class AddAlumniInfoServlet
 */
@WebServlet("/AddAlumniInfoServlet")
public class AddAlumniInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAlumniInfoServlet() {
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
		String alumniinfo = request.getParameter("alumniinfo");
		int studentselected = Integer.parseInt(request.getParameter("studentselected"));
		String students = request.getParameter("studentselected");
		Alumnidao p = new Alumnidao();
		
		
		 request.setAttribute("studentselected", students);
			
		
		
		if(alumniinfo==""){
			 LinkedHashMap alumni = p.getOneAlumni(studentselected);
			    
				request.setAttribute("alumni", alumni);
			request.setAttribute("addphderror", "Please fill all details!");
			RequestDispatcher rd=request.getRequestDispatcher("updatealumni.jsp");
		    rd.forward(request,response);
		    return;
		}
		
		
		int count = p.updateAlumniInfo(studentselected, alumniinfo);
		if(count>0){
			 LinkedHashMap alumni = p.getOneAlumni(studentselected);
			    
				request.setAttribute("alumni", alumni);
			request.setAttribute("addphdsuccess", "Alumni Info Addition Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("updatealumni.jsp");
		    rd.forward(request,response);
		}else{
			 LinkedHashMap alumni = p.getOneAlumni(studentselected);
			    
				request.setAttribute("alumni", alumni);
			request.setAttribute("addphderror", "Alumni Info Addition Not Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("updatealumni.jsp");
		    rd.forward(request,response);
		}
		
	}
	

}
