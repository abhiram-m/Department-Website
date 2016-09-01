package com.hashtag;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hashtag.dao.Hashtag;
import hashtag.dao.Hashtagdao;

public class CreateHashtagServlet extends HttpServlet {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			response.setContentType("text/html");
			String hashtagname = request.getParameter("newtagname");
			HttpSession session = request.getSession();
			String netid = (String) session.getAttribute("netid");
			request.setAttribute("errcreate", "");
			ServletContext context = request.getSession().getServletContext();
			Date dt = new java.util.Date();

			java.text.SimpleDateFormat sdf = 
			     new java.text.SimpleDateFormat("yyyy-MM-dd");
			//int count = 0;
//			Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);//do not include a-z and 0-9
//			Matcher m = p.matcher(hashtagname);
//			boolean splchars = m.find();
//			
//			Pattern pattern = Pattern.compile("\\s");//no spaces
//			Matcher matcher = pattern.matcher(hashtagname);
//			boolean spaces = matcher.find();
			
			boolean nochar = hashtagname.equals("");//blank 

			if (nochar){
				request.setAttribute("errcreate", "Sorry add a topic");
				RequestDispatcher rd=request.getRequestDispatcher("createhashtag.jsp");
			    rd.forward(request,response);
			}else{
			
			Hashtag ht = new Hashtag();
			int count = ht.searchHashtag(hashtagname);
			

			
		if(count>=1){
			
			request.setAttribute("errcreate", "Sorry this topic already exist, please choose a different name");
			RequestDispatcher rd=request.getRequestDispatcher("createhashtag.jsp");
		    rd.forward(request,response);
		}else{
			
			Hashtag ht2 = new Hashtag();
			int r = ht2.createHashtag(hashtagname, sdf, dt, netid);
			
			if(r>0){
				Hashtag h  = new Hashtag();
				
				LinkedHashMap<String, ArrayList> hashtags = h.getHashtag();
				request.setAttribute("hashtags", hashtags);
			
			request.setAttribute("successmsg", "Topic created successfully");
			RequestDispatcher rd=request.getRequestDispatcher("search.jsp");
		    rd.forward(request,response);
			}else{
				Hashtag h  = new Hashtag();
				
				LinkedHashMap<String, ArrayList> hashtags = h.getHashtag();
				request.setAttribute("hashtags", hashtags);
				
				request.setAttribute("errcreate", "Sorry error occured");
				RequestDispatcher rd=request.getRequestDispatcher("createhashtag.jsp");
			    rd.forward(request,response);
			}
		}
			
			
		}
		
		}
		
	}

