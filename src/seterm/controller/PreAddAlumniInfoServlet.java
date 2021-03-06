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

import seterm.dao.Alumnidao;
import seterm.dao.PhdStudentsdao;

/**
 * Servlet implementation class PreAddAlumniInfoServlet
 */
@WebServlet("/PreAddAlumniInfoServlet")
public class PreAddAlumniInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreAddAlumniInfoServlet() {
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
		
	String s = (request.getParameter("alumniid"));
		
	if(s==null){
		Alumnidao a = new Alumnidao();
		LinkedHashMap<String, ArrayList> alumni = a.getAllAlumni();
		request.setAttribute("alumni", alumni);
		request.setAttribute("error", "Please select a value");
		RequestDispatcher rd=request.getRequestDispatcher("viewalumni.jsp");
	    rd.forward(request,response);
		
	}else{
	int studentselected = Integer.parseInt(request.getParameter("alumniid"));
	String student = request.getParameter("alumniid");
		Alumnidao p = new Alumnidao();
	    LinkedHashMap alumni = p.getOneAlumni(studentselected);
	    
		request.setAttribute("studentselected", student);
		request.setAttribute("alumni", alumni);
		RequestDispatcher rd=request.getRequestDispatcher("updatealumni.jsp");
	    rd.forward(request,response);
	}
	}

}
