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
import javax.servlet.http.HttpSession;

import seterm.dao.Examsdao;

/**
 * Servlet implementation class AddExamResultsServlet
 */
@WebServlet("/AddExamResultsServlet")
public class AddExamResultsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddExamResultsServlet() {
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
		HttpSession session = request.getSession();
		String netid=(String) session.getAttribute("netid");
		
		
		String result = request.getParameter("examresult");
		String name1 = request.getParameter("examnameresult1").split(":")[1];
		System.out.println(request.getParameter("examnameresult1"));
		String name = request.getParameter("examnameresult2");
		
		int examid=0;
		if(name.equals("")){
			examid = Integer.parseInt(request.getParameter("examnameresult1").split(":")[0]);
			System.out.println(examid);
			 name = name1;
		}
		if(name==null||result==null){
			Examsdao e1 = new Examsdao();
			LinkedHashMap<String, ArrayList> examdetails = e1.getAllExams();
			request.setAttribute("examdetails", examdetails);
			request.setAttribute("addexamerror", "Please fill all values!");
			RequestDispatcher rd=request.getRequestDispatcher("addresult.jsp");
		    rd.forward(request,response);
		}
		System.out.println(name+"  "+examid);
		Examsdao e = new Examsdao();
		int count =e.saveExamResult(name, result, netid, examid);
		if(count>0){
			Examsdao e1 = new Examsdao();
			LinkedHashMap<String, ArrayList> examdetails = e1.getAllExams();
			request.setAttribute("examdetails", examdetails);
			request.setAttribute("addexamsuccess", "Exam Addition Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("addresult.jsp");
		    rd.forward(request,response);
		}else{
			Examsdao e1 = new Examsdao();
			LinkedHashMap<String, ArrayList> examdetails = e1.getAllExams();
			request.setAttribute("examdetails", examdetails);
			request.setAttribute("addexamerror", "Exam Addition Not Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("addresult.jsp");
		    rd.forward(request,response);
		}
	}

}
