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
 * Servlet implementation class ApplyJobsServlet
 */
@WebServlet("/ApplyJobsServlet")
public class ApplyJobsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyJobsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String jobid=(String)request.getParameter("jobidapply");
		
		Announcementsdao a = new Announcementsdao();
		int c = a.applyJob((String)request.getSession().getAttribute("netid"), jobid);
		if(c>0){
			Announcementsdao a1 = new Announcementsdao();
			LinkedHashMap<String, ArrayList> announcements = a1.getAllAnnouncements();
			
			
			
			ArrayList<String> details = new ArrayList<String>();
			ArrayList<String> type = new ArrayList<String>();
			ArrayList<String> netid = new ArrayList<String>();
			ArrayList<String> aid = new ArrayList<String>();
			ArrayList<String> links = new ArrayList<String>();
			
			
			ArrayList<String> newsdetails = new ArrayList<String>();
			ArrayList<String> newstype = new ArrayList<String>();
			ArrayList<String> newsnetid = new ArrayList<String>();
			ArrayList<String> newsaid = new ArrayList<String>();
			ArrayList<String> newslinks = new ArrayList<String>();
			
			
			netid = announcements.get("netid");
			type = announcements.get("type");
			details = announcements.get("details");
			aid = announcements.get("aid");
			links  = announcements.get("link");
			
			for(int i=0;i<type.size();i++){
				if(type.get(i).equals("job")){
					newsdetails.add(details.get(i));
					newstype.add(type.get(i));
					newsnetid.add(netid.get(i));
					newsaid.add(aid.get(i));
					newslinks.add(links.get(i));
					
				}
			}
			LinkedHashMap<String, ArrayList> eventsannouncements = new LinkedHashMap<String, ArrayList>();
			eventsannouncements.put("newsdetails", newsdetails);
			eventsannouncements.put("newstype", newstype);
			eventsannouncements.put("newsnetid", newsnetid);
			eventsannouncements.put("newsaid", newsaid);
			eventsannouncements.put("newslinks", newslinks);
			
			
			request.setAttribute("jobannouncements", eventsannouncements);
			request.setAttribute("addcoursesuccess", "Applied Successfully!");
			RequestDispatcher rd=request.getRequestDispatcher("jobs.jsp");
		    rd.forward(request,response);
		}else{
			Announcementsdao a1 = new Announcementsdao();
			LinkedHashMap<String, ArrayList> announcements = a1.getAllAnnouncements();
			
			
			
			ArrayList<String> details = new ArrayList<String>();
			ArrayList<String> type = new ArrayList<String>();
			ArrayList<String> netid = new ArrayList<String>();
			ArrayList<String> aid = new ArrayList<String>();
			ArrayList<String> links = new ArrayList<String>();
			
			
			ArrayList<String> newsdetails = new ArrayList<String>();
			ArrayList<String> newstype = new ArrayList<String>();
			ArrayList<String> newsnetid = new ArrayList<String>();
			ArrayList<String> newsaid = new ArrayList<String>();
			ArrayList<String> newslinks = new ArrayList<String>();
			
			
			netid = announcements.get("netid");
			type = announcements.get("type");
			details = announcements.get("details");
			aid = announcements.get("aid");
			links  = announcements.get("link");
			
			for(int i=0;i<type.size();i++){
				if(type.get(i).equals("job")){
					newsdetails.add(details.get(i));
					newstype.add(type.get(i));
					newsnetid.add(netid.get(i));
					newsaid.add(aid.get(i));
					newslinks.add(links.get(i));
					
				}
			}
			LinkedHashMap<String, ArrayList> eventsannouncements = new LinkedHashMap<String, ArrayList>();
			eventsannouncements.put("newsdetails", newsdetails);
			eventsannouncements.put("newstype", newstype);
			eventsannouncements.put("newsnetid", newsnetid);
			eventsannouncements.put("newsaid", newsaid);
			eventsannouncements.put("newslinks", newslinks);
			
			
			request.setAttribute("jobannouncements", eventsannouncements);
			request.setAttribute("addcourseerror", "You Already Applied for this job!");
			RequestDispatcher rd=request.getRequestDispatcher("jobs.jsp");
		    rd.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
