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

import seterm.dao.Resourcedao;

/**
 * Servlet implementation class CheckAvailabilityServlet
 */
@WebServlet("/CheckAvailabilityServlet")
public class CheckAvailabilityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckAvailabilityServlet() {
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
		String resourcename = request.getParameter("resourcename");
		String resourcedate = request.getParameter("resourcedate");
		Resourcedao r = new Resourcedao();
		if(resourcename.equals("Select Resource...")||resourcedate==null){
			Resourcedao r1 = new Resourcedao();
			LinkedHashMap<String, ArrayList> resources = r1.getAllResources();
			request.setAttribute("resources", resources);
			request.setAttribute("error", "Please select a resource");
			
			//RequestDispatcher rd=request.getRequestDispatcher("bookresource.jsp");
			RequestDispatcher rd=request.getRequestDispatcher("reserveresource.jsp");
		    rd.forward(request,response);
		    return;
		}
		
		LinkedHashMap<String, ArrayList> reservations = r.getResourceAvailabillity(resourcename, resourcedate);
		LinkedHashMap<String, ArrayList> someresources = r.getSomeResources(resourcename);
		
		request.setAttribute("reservations", reservations);
		request.setAttribute("someresources", someresources);
		request.setAttribute("resourcename", resourcename);
		request.setAttribute("resourcedate", resourcedate);
		
		
		Resourcedao r1 = new Resourcedao();
		LinkedHashMap<String, ArrayList> resources = r1.getAllResources();
		request.setAttribute("resources", resources);
		
		//RequestDispatcher rd=request.getRequestDispatcher("bookresource.jsp");
		RequestDispatcher rd=request.getRequestDispatcher("reserveresource.jsp");
	    rd.forward(request,response);
	}

}
