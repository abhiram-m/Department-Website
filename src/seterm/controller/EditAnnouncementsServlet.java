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

import seterm.dao.Announcementsdao;

/**
 * Servlet implementation class EditAnnouncementsServlet
 */
@WebServlet("/EditAnnouncementsServlet")
public class EditAnnouncementsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAnnouncementsServlet() {
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
		String details = (String)request.getParameter("details");
		String links = (String)request.getParameter("links");
		String id = (String)request.getParameter("id");
		
		if(details==""||links==""){
			Announcementsdao a = new Announcementsdao();
			LinkedHashMap<String, ArrayList> announcements = a.getOneAnnouncement(id);
			request.setAttribute("announcements", announcements);
			request.setAttribute("addcourseerror", "Update Announcement Not Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("editannouncements.jsp");
		    rd.forward(request,response);
		}
		
		Announcementsdao a = new Announcementsdao();
		int count = a.updateAnnouncements(details, id, links);
		
		if(count>0){
			Announcementsdao a1 = new Announcementsdao();
			LinkedHashMap<String, ArrayList> announcements = a1.getOneAnnouncement(id);
			request.setAttribute("announcements", announcements);
			request.setAttribute("addcoursesuccess", "Update announcement Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("editannouncements.jsp");
		    rd.forward(request,response);
		}else{
			Announcementsdao a1= new Announcementsdao();
			LinkedHashMap<String, ArrayList> announcements = a1.getOneAnnouncement(id);
			request.setAttribute("announcements", announcements);
			request.setAttribute("addcourseerror", "Update Announcement Not Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("editannouncements.jsp");
		    rd.forward(request,response);
		}
		
	}

}
