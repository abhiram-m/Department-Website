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
import javax.servlet.http.HttpSession;

import seterm.dao.Announcementsdao;

/**
 * Servlet implementation class AddAnnouncementsServlet
 */
@WebServlet("/AddNewsServlet")
public class AddNewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewsServlet() {
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
		String netids=(String) session.getAttribute("netid");
		
		
		String events = request.getParameter("news");
		System.out.println(events);
		String types="news";
	
		if(events==""){
			request.setAttribute("announcementerror", "Please Add News!");
			RequestDispatcher rd=request.getRequestDispatcher("news.jsp");
		    rd.forward(request,response);
			
		}
		Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = 
		new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String id = ((sdf.format(dt).replace("-", "")).replace(":", "")).replace(" ", "");
		String datenow = sdf.format(dt);
		Announcementsdao a = new Announcementsdao();
		int count = a.saveAnnouncements(netids, events, types, id, datenow, "");
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
				if(type.get(i).equals("news")){
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
			
			request.setAttribute("newsannouncements", eventsannouncements);
			
			request.setAttribute("announcementsuccess", "Announcement Addition Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("news.jsp");
		    rd.forward(request,response);
		}else{
			request.setAttribute("announcementerror", "Announcement Addition Not Successful!");
			RequestDispatcher rd=request.getRequestDispatcher("news.jsp");
		    rd.forward(request,response);
		}
	}

}
