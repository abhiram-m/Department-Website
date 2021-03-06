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
 * Servlet implementation class ViewEventsServlet
 */
@WebServlet("/ViewEventsServlet")
public class ViewEventsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEventsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Announcementsdao a = new Announcementsdao();
		LinkedHashMap<String, ArrayList> announcements = a.getAllAnnouncements();
		
		
		
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
		RequestDispatcher rd=request.getRequestDispatcher("events.jsp");
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
