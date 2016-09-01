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

import seterm.dao.Examsdao;

/**
 * Servlet implementation class EditExamResultServlet
 */
@WebServlet("/EditExamResultServlet")
public class EditExamResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditExamResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = (String)(request.getParameter("eid"));
		String result = request.getParameter("examresult");
		
		Examsdao e = new Examsdao();
		int count = e.updateExamResultsbyId(id, result);
		if(count>0){
			Examsdao e1 = new Examsdao();
			LinkedHashMap<String, ArrayList> examdetails = e1.getExamResultsbyId(id);
			request.setAttribute("examdetails", examdetails);
			request.setAttribute("addcoursesuccess", "Result update Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("viewresults.jsp");
		    rd.forward(request,response);
		}else{
			Examsdao e1 = new Examsdao();
			LinkedHashMap<String, ArrayList> examdetails = e1.getExamResultsbyId(id);
			request.setAttribute("examdetails", examdetails);
			request.setAttribute("addcourseerror", "Result update Not Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("viewresults.jsp");
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
