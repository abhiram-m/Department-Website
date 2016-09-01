package seterm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seterm.dao.Announcementsdao;

/**
 * Servlet implementation class DeleteAnnouncementsServlet
 */
@WebServlet("/DeleteAnnouncementsServlet")
public class DeleteAnnouncementsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAnnouncementsServlet() {
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
		
		String id = request.getParameter("delevent");
		
	if(id==""){
		request.setAttribute("announcementerror", "Please select an announcement!");
		RequestDispatcher rd=request.getRequestDispatcher("announcements.jsp");
	    rd.forward(request,response);
	}
		
		
		Announcementsdao a = new Announcementsdao();
		int count = a.deleteAnnouncement(id);
		if(count>0){
			
			Announcementsdao adao = new Announcementsdao();
			LinkedHashMap<String, ArrayList> announcements = adao.getAllAnnouncements();
			
			ArrayList<String> details = new ArrayList<String>();
			ArrayList<String> type = new ArrayList<String>();
			ArrayList<String> netid = new ArrayList<String>();
			ArrayList<String> aid = new ArrayList<String>();
			
			ArrayList<String> newsdetails = new ArrayList<String>();
			ArrayList<String> newstype = new ArrayList<String>();
			ArrayList<String> newsnetid = new ArrayList<String>();
			ArrayList<String> newsaid = new ArrayList<String>();
			
			netid = announcements.get("netid");
			type = announcements.get("type");
			details = announcements.get("details");
			aid = announcements.get("aid");
			for(int i=0;i<type.size();i++){
				if(type.get(i).equals("event")){
					newsdetails.add(details.get(i));
					newstype.add(type.get(i));
					newsnetid.add(netid.get(i));
					newsaid.add(aid.get(i));
				}
			}
			LinkedHashMap<String, ArrayList> eventsannouncements = new LinkedHashMap<String, ArrayList>();
			eventsannouncements.put("newsdetails", newsdetails);
			eventsannouncements.put("newstype", newstype);
			eventsannouncements.put("newsnetid", newsnetid);
			eventsannouncements.put("newsaid", newsaid);
			
			request.setAttribute("eventsannouncements", eventsannouncements);
			
			request.setAttribute("announcementsuccess", "Announcement Deletion Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("announcements.jsp");
		    rd.forward(request,response);
		}else{
			request.setAttribute("announcementerror", "Announcement Deletion Not Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("announcements.jsp");
		    rd.forward(request,response);
		}
	}

	

}
