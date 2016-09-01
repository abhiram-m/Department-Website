package com.hashtag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hashtag.dao.Hashtag;

/**
 * Servlet implementation class DeleteHashtagServlet
 */
@WebServlet("/DeleteHashtagServlet")
public class DeleteHashtagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteHashtagServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String hashtagname = request.getParameter("deletetagname");
		Hashtag ht = new Hashtag();
		int count = ht.deleteHashtag(hashtagname);
		
		if(count>0){
			Hashtag h  = new Hashtag();
			
			LinkedHashMap<String, ArrayList> hashtags = h.getHashtag();
			request.setAttribute("hashtags", hashtags);
		
		request.setAttribute("successmsg", "Topic deleted successfully");
		RequestDispatcher rd=request.getRequestDispatcher("deletehashtag.jsp");
	    rd.forward(request,response);
		}else{
			Hashtag h  = new Hashtag();
			
			LinkedHashMap<String, ArrayList> hashtags = h.getHashtag();
			request.setAttribute("hashtags", hashtags);
			
			request.setAttribute("err", "Sorry error occured");
			RequestDispatcher rd=request.getRequestDispatcher("deletehashtag.jsp");
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
