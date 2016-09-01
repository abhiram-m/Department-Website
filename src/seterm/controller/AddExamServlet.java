package seterm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seterm.dao.Examsdao;

/**
 * Servlet implementation class AddExamServlet
 */
@WebServlet("/AddExamServlet")
public class AddExamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddExamServlet() {
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
		
		String name = request.getParameter("examname");
		String date = request.getParameter("examdate");
		String info = request.getParameter("examinfo");
		String netid = (String) request.getSession().getAttribute("netid");
		
		if(name==null||date==null||info==null){
			
			request.setAttribute("addexamerror", "Please fill all values!");
			RequestDispatcher rd=request.getRequestDispatcher("addexam.jsp");
		    rd.forward(request,response);
		}
		
		Examsdao e = new Examsdao();
		int count = e.saveExam(name, date, info, netid);
		if(count>0){
			request.setAttribute("addexamsuccess", "Exam Addition Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("addexam.jsp");
		    rd.forward(request,response);
		}else{
			request.setAttribute("addexamerror", "Exam Addition Not Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("addexam.jsp");
		    rd.forward(request,response);
		}
		
		
	}

}
