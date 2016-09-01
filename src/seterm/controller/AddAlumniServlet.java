package seterm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seterm.dao.Alumnidao;

/**
 * Servlet implementation class AddAlumniServlet
 */
@WebServlet("/AddAlumniServlet")
public class AddAlumniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAlumniServlet() {
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
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String info = request.getParameter("info");
		Alumnidao a = new Alumnidao();
		
		if(fname==""||lname==""){
			request.setAttribute("addcourseerror", "Please fill all fields!");
			RequestDispatcher rd=request.getRequestDispatcher("addalumni.jsp");
		    rd.forward(request,response);
		}
		int count = a.addAlumniInfo(fname, lname, info);
		if(count>0){
			request.setAttribute("addcoursesuccess", "Alumni Addition Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("addalumni.jsp");
		    rd.forward(request,response);
		}else{
			request.setAttribute("addcourseerror", "Alumni Addition Not Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("addalumni.jsp");
		    rd.forward(request,response);
		}
	}

}
