package com.hashtag;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hashtag.dao.Hashtag;
import hashtag.dao.HashtagFeed;
import hashtag.dao.Hashtagdao;

public class SearchHashtagServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String hashtagname = request.getParameter("tagname");
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
			
			if(name.get(counter).equals(hashtagname)){
				nindex.add(counter);
				
				
			}
		}
		
		
		LinkedHashMap<String, ArrayList> i= new LinkedHashMap<String, ArrayList>();
		i.put("nindex", nindex);
		i.put("pindex",pindex);
		i.put("content",content);
		i.put("pid",pid);
		i.put("id", id);
		
	response.setContentType("text/html");
	ServletContext context = request.getSession().getServletContext();
	Hashtag ht3 = new Hashtag();
	int count = ht3.searchHashtag(hashtagname);
	
	if(count>=1){
		context.setAttribute("hash",hashtagname);
		request.setAttribute("hash",hashtagname);

		request.setAttribute("m", i);
		
		RequestDispatcher rd=request.getRequestDispatcher("viewhashtag.jsp");
	    rd.forward(request,response);
	}else{
		request.setAttribute("err", "Sorry this hashtag does not exist, would you like to create it?");
		RequestDispatcher rd=request.getRequestDispatcher("search.jsp");
	    rd.forward(request,response);
	}
		
		
	}
	
	
	
}
