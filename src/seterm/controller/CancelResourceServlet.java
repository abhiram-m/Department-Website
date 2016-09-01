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

import seterm.dao.Resourcedao;

/**
 * Servlet implementation class CancelResourceServlet
 */
@WebServlet("/CancelResourceServlet")
public class CancelResourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelResourceServlet() {
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
		String resourcename = request.getParameter("cancelresname");
		//HttpSession session = request.getSession();
		//String uname = (String)session.getAttribute("username");
		String[] s = resourcename.split("@");
		Resourcedao r = new Resourcedao();
		int c = r.cancelReservation(s[0], s[2], s[1]);
		
		if(c>0){
			Resourcedao r1 = new Resourcedao();
			HttpSession session = request.getSession();
			String uname = (String)session.getAttribute("username");
			LinkedHashMap<String, ArrayList> resources = r1.getMyResources(uname);
			request.setAttribute("resources", resources);
			request.setAttribute("cancelsuccess", "Cancellation Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("viewresource.jsp");
		    rd.forward(request,response);
		}else{
			Resourcedao r1 = new Resourcedao();
			HttpSession session = request.getSession();
			String uname = (String)session.getAttribute("username");
			LinkedHashMap<String, ArrayList> resources = r1.getMyResources(uname);
			request.setAttribute("resources", resources);
			request.setAttribute("cancelerror", "Cancellation Not Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("viewresource.jsp");
		    rd.forward(request,response);
		}
	}

}
