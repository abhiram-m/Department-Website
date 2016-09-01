package seterm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hashtag.dao.HashtagFeed;

/**
 * Servlet implementation class DeleteDiscussionServlet
 */
@WebServlet("/DeleteDiscussionServlet")
public class DeleteDiscussionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDiscussionServlet() {
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
		ServletContext context = request.getSession().getServletContext();
		String Hashtagname = (String) context.getAttribute("hash");
		String delid = (String)request.getParameter("replyidtodelete");
		System.out.println("MYSYS  "+ delid);
		HashtagFeed hfnew = new HashtagFeed();
		hfnew.deleteDiscussion(delid);
		
		

		HashtagFeed hf = new HashtagFeed();
		
		LinkedHashMap m = hf.getReplies();
		
		ArrayList name = (ArrayList) m.get("name");
		ArrayList pid = (ArrayList) m.get("parentFeedID");
		ArrayList content = (ArrayList) m.get("content");
		ArrayList id = (ArrayList) m.get("id");
		
		ArrayList pindex = new ArrayList<>();
		ArrayList nindex = new ArrayList<>();
		
		
	for (int counter = 0; counter < pid.size(); counter++) {
			
			if(pid.get(counter).equals("parent")){
				pindex.add(counter);
				
			}
		}
		
		
		
		for (int counter = 0; counter < name.size(); counter++) {
			
			if(name.get(counter).equals(Hashtagname)){
				nindex.add(counter);
				
				
			}
		}
		
		
		LinkedHashMap<String, ArrayList> i= new LinkedHashMap<String, ArrayList>();
		i.put("nindex", nindex);
		i.put("pindex",pindex);
		i.put("content",content);
		i.put("pid",pid);
		i.put("id", id);
		
		request.setAttribute("m", i);
		
	
		RequestDispatcher rd1=request.getRequestDispatcher("viewhashtag.jsp");
	    rd1.forward(request,response);
	}

}
