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
 * Servlet implementation class PreEditAnnouncementServlet
 */
@WebServlet("/PreEditAnnouncementServlet")
public class PreEditAnnouncementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PreEditAnnouncementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("delevent");
		
		if(id==""){
			request.setAttribute("announcementerror", "Please select an announcement!");
			RequestDispatcher rd=request.getRequestDispatcher("announcements.jsp");
		    rd.forward(request,response);
		}
		
		Announcementsdao a = new Announcementsdao();
		LinkedHashMap<String, ArrayList> announcements = a.getOneAnnouncement(id);
		request.setAttribute("announcements", announcements);
		RequestDispatcher rd=request.getRequestDispatcher("editannouncements.jsp");
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
