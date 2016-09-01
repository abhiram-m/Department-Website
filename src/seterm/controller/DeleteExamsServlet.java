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
 * Servlet implementation class DeleteExamsServlet
 */
@WebServlet("/DeleteExamsServlet")
public class DeleteExamsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteExamsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		int id = Integer.parseInt(request.getParameter("id"));
		Examsdao e = new Examsdao();
		e.deleteExam(id);
		Examsdao e1 = new Examsdao();
		LinkedHashMap<String, ArrayList> examdetails = e1.getAllExams();
		request.setAttribute("examdetails", examdetails);
		request.setAttribute("del", "Exam Deleted!");
		RequestDispatcher rd=request.getRequestDispatcher("viewexam.jsp");
	    rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
