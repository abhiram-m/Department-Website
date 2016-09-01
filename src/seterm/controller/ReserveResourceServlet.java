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
 * Servlet implementation class ReserveResourceServlet
 */
@WebServlet("/ReserveResourceServlet")
public class ReserveResourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReserveResourceServlet() {
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
		String slot = request.getParameter("slot");
		String resname = request.getParameter("resname");
		String resdate = request.getParameter("resdate");
		HttpSession session = request.getSession();
		String uname = (String)session.getAttribute("username");
		
		if(slot==""){
			Resourcedao r1 = new Resourcedao();
			LinkedHashMap<String, ArrayList> reservations = r1.getResourceAvailabillity(resname, resdate);
			LinkedHashMap<String, ArrayList> someresources = r1.getSomeResources(resname);
			
			request.setAttribute("reservations", reservations);
			request.setAttribute("someresources", someresources);
			request.setAttribute("resourcename", resname);
			request.setAttribute("resourcedate", resdate);
			Resourcedao r2 = new Resourcedao();
			LinkedHashMap<String, ArrayList> resources = r2.getAllResources();
			request.setAttribute("resources", resources);
			
			request.setAttribute("addsloterror", "Please select a slot!");
			RequestDispatcher rd=request.getRequestDispatcher("reserveresource.jsp");
		    rd.forward(request,response);
		}
		
		
		Resourcedao r = new Resourcedao();
		int c = r.saveReservation(resname, resdate, slot, uname);
		if(c>0){
			Resourcedao r1 = new Resourcedao();
			LinkedHashMap<String, ArrayList> reservations = r1.getResourceAvailabillity(resname, resdate);
			LinkedHashMap<String, ArrayList> someresources = r1.getSomeResources(resname);
			
			request.setAttribute("reservations", reservations);
			request.setAttribute("someresources", someresources);
			request.setAttribute("resourcename", resname);
			request.setAttribute("resourcedate", resdate);
			Resourcedao r2 = new Resourcedao();
			LinkedHashMap<String, ArrayList> resources = r2.getAllResources();
			request.setAttribute("resources", resources);
			request.setAttribute("addslotsuccess", "Reservation Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("reserveresource.jsp");
		    rd.forward(request,response);
			
		}else{
			
			Resourcedao r1 = new Resourcedao();
			LinkedHashMap<String, ArrayList> reservations = r1.getResourceAvailabillity(resname, resdate);
			LinkedHashMap<String, ArrayList> someresources = r1.getSomeResources(resname);
			
			request.setAttribute("reservations", reservations);
			request.setAttribute("someresources", someresources);
			request.setAttribute("resourcename", resname);
			request.setAttribute("resourcedate", resdate);
			Resourcedao r2 = new Resourcedao();
			LinkedHashMap<String, ArrayList> resources = r2.getAllResources();
			request.setAttribute("resources", resources);
			request.setAttribute("addsloterror", "Reservation not Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("reserveresource.jsp");
		    rd.forward(request,response);
			
		}
	}

}
